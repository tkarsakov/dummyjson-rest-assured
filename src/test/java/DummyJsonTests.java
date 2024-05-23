import com.github.fge.jsonschema.cfg.ValidationConfiguration;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import org.testng.annotations.Test;

import static com.github.fge.jsonschema.SchemaVersion.DRAFTV4;
import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class DummyJsonTests {
    private final JsonSchemaFactory jsonSchemaFactory = JsonSchemaFactory.newBuilder().setValidationConfiguration(ValidationConfiguration.newBuilder().setDefaultVersion(DRAFTV4).freeze()).freeze();

    @Test(description = "Get all products and check them against a schema")
    public void testGetAllProducts() {
        when()
                .get(Endpoints.PRODUCTS)
                .then()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("GETallProducts/response.json").using(jsonSchemaFactory));
    }
}

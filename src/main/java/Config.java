import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class Config {
    private static final Path CONFIG_PATH = Path.of("src/main/resources/config.properties");
    private static final Properties CONFIG = new Properties();

    static {
        try {
            CONFIG.load(Config.class.getResourceAsStream("config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Cannot read config file at " + CONFIG_PATH);
        }
    }

    public static String endpoint(String endpoint) {
        return CONFIG.getProperty("url") + endpoint;
    }
}

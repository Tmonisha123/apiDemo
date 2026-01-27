package utilities;

import java.io.InputStream;
import java.util.Properties;

public class TestConfig {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input =
                     Config.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("config.properties not found in src/test/resources");
            }

            properties.load(input);

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    private static String get(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new RuntimeException("Missing config key: " + key);
        }
        return value;
    }

    public static String BASE_URL() {
        return get("base.url");
    }

    public static String London_ENDPOINT() {
        return get("endpoint.london");
    }

    public static String Paris_ENDPOINT() {
        return get("endpoint.paris");
    }

    public static String NewYork_ENDPOINT() {
        return get("endpoint.newyork");
    }

}

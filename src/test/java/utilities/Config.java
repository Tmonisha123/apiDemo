package utilities;

import org.xmlunit.builder.Input;

import java.io.InputStream;
import java.util.Properties;

/*
 * ============================================================
 *  Config.java
 * ============================================================
 *  Purpose:
 *  --------
 *  This class stores environment-specific configuration values
 *  used by the API test framework.
 *
 *  All values are read from JVM system properties, which are
 *  typically passed at runtime via:
 *
 *    -Dbase.url=https://api.example.com
 *    -Dhello.endpoint=/hello
 *    -Dhola.endpoint=/hola
 *    -Dnamaste.endpoint=/namaste
 *
 *  Why this class exists:
 *  ----------------------
 *  - Keeps endpoint values out of step definitions
 *  - Makes it easy to switch environments (dev/qa/prod)
 *  - Avoids hardcoding URLs in test code
 *
 *  How it is used:
 *  ---------------
 *  - BASE_URL        → Base API URL (used in RequestSpec)
 *  - hello_ENDPOINT  → Path for the /hello endpoint
 *  - hola_ENDPOINT   → Path for the /hola endpoint
 *  - namaste_ENDPOINT→ Path for the /namaste endpoint
 *
 *  Important Notes:
 *  ----------------
 *  - If a system property is NOT provided, its value will be null
 *  - A null endpoint or base URL can cause test failures
 *  - Consider adding default values or validation if needed
 * ============================================================
 */

//public class Config {
//
//    private static final Properties properties = new Properties();
//
//    static {
//        try (InputStream input =
//                     Config.class.getClassLoader().getResourceAsStream("config.properties")) {
//
//            if (input == null) {
//                throw new RuntimeException("config.properties not found in resources folder");
//            }
//
//            properties.load(input);
//
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to load config.properties", e);
//        }
//    }
//
//    public static String get(String key) {
//        return properties.getProperty(key);
//    }
//
//    public static final String BASE_URL =
//            System.getProperty("base.url");
//
//    public static final String hello_ENDPOINT =
//            System.getProperty("hello.endpoint");
//
//    public static final String hola_ENDPOINT =
//            System.getProperty("hola.endpoint");
//
//    public static final String namaste_ENDPOINT =
//            System.getProperty("namaste.endpoint");
//
//    public static String namasteyEndpoint() {
//        return get("endpoint.namastey");
//    }
//}

public class Config {

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

    public static String baseUrl() {
        return get("base.url");
    }

    public static String helloEndpoint() {
        return get("endpoint.hello");
    }

    public static String holaEndpoint() {
        return get("endpoint.hola");
    }

    public static String namasteEndpoint() {
        return get("endpoint.namaste");
    }

    public static String namasteyEndpoint() {
        return get("endpoint.namastey");
    }
}

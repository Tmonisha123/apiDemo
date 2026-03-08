package utilities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;

/*
 * ============================================================
 *  RequestSpec.java
 * ============================================================
 *  Purpose:
 *  --------
 *  This class builds and provides a reusable REST Assured
 *  RequestSpecification.
 *
 *  A RequestSpecification defines common request settings such as:
 *    - Base URI
 *    - Port
 *    - Content-Type
 *    - Headers, auth, timeouts (if added later)
 *
 *  Why this class exists:
 *  ----------------------
 *  - Avoids duplicating request setup code in every test
 *  - Ensures all API calls use consistent configuration
 *  - Makes it easy to change base URL or headers in one place
 *
 *  Design Pattern Used:
 *  --------------------
 *  Singleton (lazy initialization)
 *  - The 'spec' object is created only once
 *  - All tests reuse the same instance
 *
 *  How it is used:
 *  ---------------
 *  In step definitions:
 *
 *    given()
 *      .spec(RequestSpec.getSpec())
 *      .when()
 *      .get(Config.hello_ENDPOINT);
 *
 *  Important Notes:
 *  ----------------
 *  - Currently uses hardcoded base URI and port:
 *        http://localhost:8080
 *  - You may later replace these with values from Config:
 *        .setBaseUri(Config.BASE_URL)
 *  - If this method is never called, the spec is never created
 * ============================================================
 */

public class RequestSpec {

    private static RequestSpecification spec;

    public static RequestSpecification getSpec() {
        if (spec == null) {
            spec = new RequestSpecBuilder()
                    .setBaseUri(Config.baseUrl())
                    .addHeader("Content-Type", "application/json")
                    .build();
        }
        return spec;
    }

    //Create getWeatherSpec()
    public static RequestSpecification getWeatherSpec() {
        if (spec == null) {
            spec = new RequestSpecBuilder()
                    .setBaseUri(TestConfig.baseUrl())
                    .addHeader("Content-Type", "application/json")
                    .build();
        }
        return spec;
    }
}

package harisbrulicita2024.resource;

import harisbrulicita2024.model.Tracking;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
@TestHTTPEndpoint(TrackingResource.class)
public class TrackingResourceTest {

    @Test
    public void testGetTracking() {
        RestAssured.given()
                .when().get("/{tracking_id}", 1)
                .then()
                .statusCode(500)
                .body("tracking_id", equalTo(1));
    }

    @Test
    public void testCreateTracking() {
        Tracking tracking = new Tracking();
        tracking.setTracking_id(UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE);

        RestAssured.given()
                .contentType("application/json")
                .body(tracking)
                .when().post()
                .then()
                .statusCode(500)
                .body("tracking_id", equalTo(tracking.getTracking_id()));
    }
}


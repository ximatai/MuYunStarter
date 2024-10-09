package net.ximatai.muyun.demo.test;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import net.ximatai.muyun.database.IDatabaseOperationsStd;
import net.ximatai.muyun.demo.DemoConst;
import net.ximatai.muyun.demo.MyDemoController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@QuarkusTest
//@QuarkusTestResource(value = PostgresTestResource.class, restrictToAnnotatedClass = true)
public class TestMyDemoController {

    String base = DemoConst.BASE_PATH;

    @Inject
    IDatabaseOperationsStd databaseOperations;

    @Inject
    MyDemoController myDemoController;

    @Test
    void testCreate() {
        String id = myDemoController.create(Map.of(
                "v_name", "test"
        ));

        Map<String, Object> row = databaseOperations.row("select * from %s where id = ?".formatted(myDemoController.getMainTable()), id);

        assertNotNull(row.get("id"));
        assertNotNull(row.get("t_create"));
        assertEquals("test", row.get("v_name"));
    }

    @Disabled
    @Test
    void testCreateOverHTTP() {
        String id = given()
                .contentType("application/json")
                .body(Map.of(
                        "v_name", "test"
                ))
                .when()
                .post("%s/test/create".formatted(base))
                .then()
                .statusCode(200)
                .extract()
                .asString();

        Map<String, Object> row = databaseOperations.row("select * from %s where id = ?".formatted(myDemoController.getMainTable()), id);


        assertNotNull(row.get("id"));
        assertNotNull(row.get("t_create"));
        assertEquals("test", row.get("v_name"));
    }

}

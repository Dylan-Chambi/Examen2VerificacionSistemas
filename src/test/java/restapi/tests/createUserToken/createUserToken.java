package restapi.tests.createUserToken;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import restapi.factoryRequest.FactoryRequest;
import restapi.factoryRequest.RequestInfo;
import utils.JsonUtil;
import utils.Properties;

import java.io.FileNotFoundException;
import java.util.Base64;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;

public class createUserToken {

    RequestInfo requestInfo = new RequestInfo();

    @Test
    public void verifyCreateUserToken() throws FileNotFoundException {
        requestInfo.setHeader("Content-Type", "application/json");

        // crear usuario
        JSONObject createUserBody = new JSONObject();
        String email = "examen" + new Date().getTime() + "@gmail.com";
        String password = "examen123";
        String fullName = "Dylan Chambi";

        createUserBody.put("Email", email);
        createUserBody.put("Password", password);
        createUserBody.put("FullName", fullName);

        requestInfo.setHost(Properties.apiHost + "/user.json").setBody(createUserBody.toString());

        Response response = FactoryRequest.make("post").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion crear usuario
                .body("Email", equalTo(email))
                .body("FullName", equalTo(fullName));

        // crear token
        String auth = Base64.getEncoder().encodeToString((email + ":" + password).getBytes());
        requestInfo.setHost(Properties.apiHost + "/authentication/token.json").setHeader("Authorization", "Basic " + auth);
        response = FactoryRequest.make("get").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion crear token
                .body("UserEmail", equalTo(email));

        String token = response.then().extract().path("TokenString");

        requestInfo.setHeader("Authorization", null);

        // crear proyecto

        JSONObject createProjectBody = JsonUtil.getJSONFromFile("src/test/resources/JSONS/CreateProject.json");

        requestInfo.setHost(Properties.apiHost + "/projects.json").setBody(createProjectBody.toString()).setHeader("Token", token);
        response = FactoryRequest.make("post").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion crear proyecto
                .body("Content", equalTo(createProjectBody.get("Content")))
                .body("Icon", equalTo(createProjectBody.get("Icon")));

        // eliminar token
        requestInfo.setHost(Properties.apiHost + "/authentication/token.json").setHeader("Token", token);
        response = FactoryRequest.make("delete").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200);

        // intentar crear proyecto

        requestInfo.setHost(Properties.apiHost + "/projects.json").setBody(createProjectBody.toString()).setHeader("Token", token);
        response = FactoryRequest.make("post").send(requestInfo);
        response.then()
                .log().all()
                .statusCode(200)
                //TODO: Verificacion que ya no se puede crear proyecto
                .body("ErrorMessage", equalTo("Not Authenticated"))
                .body("ErrorCode", equalTo(102));

    }

}

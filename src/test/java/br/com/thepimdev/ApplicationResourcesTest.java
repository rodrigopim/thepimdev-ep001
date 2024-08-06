package br.com.thepimdev;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ApplicationResourcesTest {

    @Test
    void testHelloEndpoint() {
        given().when().get("/hello").then().statusCode(200).body(is("Hello from Quarkus REST"));
    }

    @Test
    void testPessoaEndpoint() {
        Response response = given().contentType(ContentType.JSON).when().get("/pessoa").then().statusCode(200).extract().response();

        ObjectMapper mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            // .configure(SerializationFeature.WRAP_ROOT_VALUE, true)
            .configure(SerializationFeature.INDENT_OUTPUT, true)
            .build();

        Pessoa pessoaTest = null;
        try {
            pessoaTest = mapper.readValue(response.getBody().asString(), Pessoa.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assertEquals(PessoaService.pessoa, pessoaTest);
    }
}

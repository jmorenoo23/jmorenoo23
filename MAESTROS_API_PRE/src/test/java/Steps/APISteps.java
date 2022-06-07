package Steps;


import io.cucumber.core.gherkin.Step;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.cucumber.junit.CucumberOptions;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;


public class APISteps {
	
	public static RequestSpecification request;
	public Response response;
	private ValidatableResponse json;
	
	@Given("^Mandar un GET request a (.+) URI$")
	public void sendGetRequest(String URI) {
		request = given()
					.header("X-RapidAPI-Host","referential.p.rapidapi.com")
					.header("X-RapidAPI-Key","40cf3e1cd3msh754bcac15d49effp1cd52fjsn60b228edbd24")
					.baseUri(URI)
					.contentType(ContentType.JSON);
	}
		
	@Then("^Tengo un status code de (\\d+) en el (.+)$")
	public void expectedStatusCode(int expectedStatusCode, String Param) {
		response = request
					.when()
					.get(Param);
					
					json = response.then().statusCode(expectedStatusCode);
	}
	
	@Then("^I validate there are (\\d+) items on the (.+) endpoint$")
	public void validateSize(int expectedSize, String endpoint) {
		response = request
					.when()
					.get(endpoint);
					
					List<String> jsonResponse = response.jsonPath().getList("$");
					int actualSize = jsonResponse.size();
					
					assertEquals(expectedSize, actualSize);	
	}
	
	@Then("^I validate there is a value: (.+) in the response at (.+) endpoint$")
	public void validateValue(String expectedValue, String endpoint) {
		response = request
					.when()
					.get(endpoint);
					List<String> jsonResponse = response.jsonPath().getList("codUnidad");
					assertTrue("El valor "+expectedValue+" no se encuentra en la lista", jsonResponse.contains(expectedValue));
	}
	
	@Then("^I can validate the nested value: (.+) on the response at (.+) endpoint$")
	public void validateNestedValue(String expectedValue, String endpoint) {
		response = request
					.when()
					.get(endpoint);
					
					String jsonResponse = response.xmlPath().getString("listaHomePaqOficina.homePaqOficina.codUnidad");
					assertTrue("El valor "+expectedValue+" no se encuentra en la lista", jsonResponse.contains(expectedValue));
	}
	
	@Then("^Muestrame la respuesta de (.+) endpoint$")
	public void showMe(String endpoint) {
		response = request
					.contentType(ContentType.XML)
					.when()
					.get(endpoint);
		
					ResponseBody body = response.getBody();
					System.out.println("Response Body is: " + body.asString());
					ExtentCucumberAdapter.addTestStepLog("Response Body is: " + body.prettyPrint());
	}
	
	@Then("^POST con body (.+) en (.+) endpoint$")
	public void POSTBody(String file, String endpoint) {
		
					File requestBody = new File("src/test/resources/Payloads/" + file + ".xml");
					
					response = request
							.header("SOAPAction","Define")
							.when()
							.body(requestBody)
							.post(endpoint)
							.then()
							.statusCode(200)
							.and()
							.log().all()
							.extract().response();
					
					ResponseBody body = response.getBody();
					ExtentCucumberAdapter.addTestStepLog("Response Body is: " + body.asPrettyString());
	}
	
	@Then("^Encontrar (.+) en response$")
	public void filterBody(String filter) {
		ResponseBody body = response.getBody();
        String BodyString = body.asString();
        assertTrue("El valor "+ filter +" no se encuentra en la respuesta del servidor", BodyString.contains(filter));
		
	}
	
}

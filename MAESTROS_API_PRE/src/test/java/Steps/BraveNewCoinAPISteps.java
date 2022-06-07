package Steps;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import java.io.File;

public class BraveNewCoinAPISteps {
	
	private static RequestSpecification request;
	private Response response;
	private ValidatableResponse json;
	
	@Given("^I have a valid API Key for the (.+) URI$")
	public void iSetTheRequestParams(String URI) {
		request = given().relaxedHTTPSValidation()
					.header("x-rapidapi-key", "40cf3e1cd3msh754bcac15d49effp1cd52fjsn60b228edbd24")
					.header("x-rapidapi-host","bravenewcon.p.rapidapi.com")
						.contentType(ContentType.JSON)
						.baseUri(URI)
						.log().all();
	}
	
	@When("^I send a POST request with a valid body to the (.+) endpoint$")
	public void sendPOSTRequest(String endpoint) {
		File requestBody = new File("src/test/resources/Payloads/TokenRequestBody.json");
		
		response = request.when().body(requestBody).post(endpoint).prettyPeek();
	}
	
	@Then("^I can validate I receive a valid token in the response$")
	public void validateTheToken() {
		
		
	}
	
}
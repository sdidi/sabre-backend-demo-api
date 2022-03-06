package za.co.sabre.converter;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterTest
{
	private final HttpHeaders httpHeaders = new HttpHeaders();
	private final TestRestTemplate testRestTemplate = new TestRestTemplate( );

	@LocalServerPort
	private int port;

	@Test
	public void givenHectareValueCheckIfItConvertsToCorrectAcreValue(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertHectareEntity = testRestTemplate.exchange(createURLWithPort("/hectare/acre/" + hectareValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedAcreValue = 1.21;
		assertEquals(expectedAcreValue,convertHectareEntity.getBody());

	}

	@Test
	public void givenHectareValueAndIncorrectAcreCheckIfItValidatesProperly(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertHectareEntity = testRestTemplate.exchange(createURLWithPort("/hectare/acre/" + hectareValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double incorrectAcreValue = 1.22;
		assertNotEquals(incorrectAcreValue,convertHectareEntity.getBody());
	}


	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/converter-api" + uri ;
	}

}

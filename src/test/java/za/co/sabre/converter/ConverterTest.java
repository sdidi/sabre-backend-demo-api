package za.co.sabre.converter;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ConverterDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterTest
{
	private final HttpHeaders httpHeaders = new HttpHeaders();

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void givenHectareValueCheckIfItConvertsToCorrectAcreValue(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/hectare/acre/" + hectareValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedAcreValue = 1.21;
		assertEquals(expectedAcreValue,convertToAcreEntity.getBody());
	}

	@Test
	public void givenHectareValueAndIncorrectAcreCheckIfItValidatesProperly(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/hectare/acre/" + hectareValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double incorrectAcreValue = 1.22;
		assertNotEquals(incorrectAcreValue,convertToAcreEntity.getBody());
	}

	@Test
	public void givenAcreValueCheckIfItConvertsToCorrectHectareValue(){
		double acreValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/acre/hectare/" + acreValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedHectareValue = 7.41;
		assertEquals(expectedHectareValue,convertToHectareEntity.getBody());
	}

	@Test
	public void givenAcreValueAndIncorrectHectareCheckIfItValidatesProperly(){
		double acreValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/acre/hectare/" + acreValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double incorrectHectareValue = 7.0;
		assertNotEquals(incorrectHectareValue,convertToHectareEntity.getBody());
	}

	@Test
	public void givenCelsiusValueCheckIfItConvertsToCorrectFahrenheitValue(){
		double celsiusValue = 42;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/celsius/fahrenheit/" + celsiusValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedFahrenheitValue = 5.56;
		assertEquals(expectedFahrenheitValue,convertToFahrenheitEntity.getBody());
	}



	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/converter-api" + uri ;
	}

}

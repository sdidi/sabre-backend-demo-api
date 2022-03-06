package za.co.sabre.converter;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

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
	public void givenHectareValueAndIncorrectAcreCheckIfItReturnsFalse(){
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
	public void givenAcreValueAndIncorrectHectareCheckIfItReturnsFalse(){
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

	@Test
	public void givenCelsiusValueAndIncorrectFahrenheitValue_CheckIfItReturnsFalse(){
		double celsiusValue = 42;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/celsius/fahrenheit/" + celsiusValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double incorrectFahrenheitValue = 5.0;
		assertNotEquals(incorrectFahrenheitValue,convertToFahrenheitEntity.getBody());
	}

	@Test
	public void givenFahrenheitValueCheckIfItConvertsToCorrectCelsiusValue(){
		double fahrenheitValue = 5.56;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToCelsiusEntity = testRestTemplate.exchange(createURLWithPort("/fahrenheit/celsius/" + fahrenheitValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedCelsiusValue = 42.01;
		assertEquals(expectedCelsiusValue,convertToCelsiusEntity.getBody());
	}

	@Test
	public void givenMeterValueCheckIfItConvertsToCorrectYardValue(){
		double meterValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToYardEntity = testRestTemplate.exchange(createURLWithPort("/meter/yard/" + meterValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedYardValue = 9.14;
		assertEquals(expectedYardValue,convertToYardEntity.getBody());
	}

	@Test
	public void givenYardValueCheckIfItConvertsToCorrectMeterValue(){
		double yardValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToMeterEntity = testRestTemplate.exchange(createURLWithPort("/yard/meter/" + yardValue),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedMeterValue = 10.94;
		assertEquals(expectedMeterValue,convertToMeterEntity.getBody());
	}



	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/converter-api" + uri ;
	}

}

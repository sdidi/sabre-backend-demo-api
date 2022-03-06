package za.co.sabre.converter.controller;


import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.co.sabre.converter.ConverterDemoApplication;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = ConverterDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ConverterControllersTest
{
	private final static Logger log = Logger.getLogger( ConverterController.class.getName() );
	private final HttpHeaders httpHeaders = new HttpHeaders();

	@Autowired
	private TestRestTemplate testRestTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void givenHectareValueCheckIfItConvertsToCorrectAcreValue(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/area/metric/" + hectareValue+"/imperial"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedAcreValue = 7.41;
		assertNotNull(convertToAcreEntity);
		assertNotNull(convertToAcreEntity.getBody());
		assertEquals(expectedAcreValue,convertToAcreEntity.getBody());
	}

	@Test
	public void givenHectareValueAndIncorrectAcreCheckIfItReturnsFalse(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/area/metric/" + hectareValue+"/imperial"),
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
		ResponseEntity<Double> convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/area/imperial/" + acreValue+"/metric"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedHectareValue = 1.21;
		assertEquals(expectedHectareValue,convertToHectareEntity.getBody());
	}

	@Test
	public void givenAcreValueAndIncorrectHectareCheckIfItReturnsFalse(){
		double acreValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/area/imperial/" + acreValue+"/metric"),
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
		ResponseEntity<Double> convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/temperature/metric/" + celsiusValue+"/imperial"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedFahrenheitValue = 107.6;
		assertEquals(expectedFahrenheitValue,convertToFahrenheitEntity.getBody());
	}

	@Test
	public void givenCelsiusValueAndIncorrectFahrenheitValue_CheckIfItReturnsFalse(){
		double celsiusValue = 42;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/temperature/metric/" + celsiusValue+"/imperial"),
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
		ResponseEntity<Double> convertToCelsiusEntity = testRestTemplate.exchange(createURLWithPort("/temperature/imperial/" + fahrenheitValue+"/metric"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedCelsiusValue = -14.69;
		assertEquals(expectedCelsiusValue,convertToCelsiusEntity.getBody());
	}

	@Test
	public void givenMeterValueCheckIfItConvertsToCorrectYardValue(){
		double meterValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToYardEntity = testRestTemplate.exchange(createURLWithPort("/distance/metric/" + meterValue+"/imperial"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedYardValue = 10.94;
		assertEquals(expectedYardValue,convertToYardEntity.getBody());
	}

	@Test
	public void givenYardValueCheckIfItConvertsToCorrectMeterValue(){
		double yardValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToMeterEntity = testRestTemplate.exchange(createURLWithPort("/distance/imperial/" + yardValue+"/metric"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedMeterValue = 9.14;
		assertEquals(expectedMeterValue,convertToMeterEntity.getBody());
	}

	@Test
	public void givenKilogramsValueCheckIfItConvertsToCorrectPoundValue(){
		double kilogramValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToPoundEntity = testRestTemplate.exchange(createURLWithPort("/weight/metric/" + kilogramValue+"/imperial"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedPoundValue = 22.05;
		assertEquals(expectedPoundValue,convertToPoundEntity.getBody());
	}

	@Test
	public void givenPoundValueCheckIfItConvertsToCorrectKilogramsValue(){
		double poundValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToKilogramEntity = testRestTemplate.exchange(createURLWithPort("/weight/imperial/" + poundValue+"/metric"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedKilogramValue = 4.54;
		assertEquals(expectedKilogramValue,convertToKilogramEntity.getBody());
	}

	@Test
	public void givenLitreValueCheckIfItConvertsToCorrectPintValue(){
		double litreValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToPintEntity = testRestTemplate.exchange(createURLWithPort("/volume/metric/" + litreValue+"/imperial"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedPintValue = 17.6;
		assertEquals(expectedPintValue,convertToPintEntity.getBody());
	}

	@Test
	public void givenPintValueCheckIfItConvertsToCorrectLitreValue(){
		double pintValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Double> convertToLitreEntity = testRestTemplate.exchange(createURLWithPort("/volume/imperial/" + pintValue+"/metric"),
				HttpMethod.GET,
				entity,
				Double.class);
		Double expectedLitreValue = 5.68;
		assertEquals(expectedLitreValue,convertToLitreEntity.getBody());
	}

	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/converter-api" + uri ;
	}

}

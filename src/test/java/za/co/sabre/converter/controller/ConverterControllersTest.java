package za.co.sabre.converter.controller;


import java.util.Map;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import za.co.sabre.converter.ConverterDemoApplication;
import za.co.sabre.converter.enums.MetricUnit;

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
		ResponseEntity<Map> convertToAcreEntity;
		convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/area/hectare/" + hectareValue+"/acre"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedAcreValue = 7.41;
		assertNotNull(convertToAcreEntity);
		assertNotNull(convertToAcreEntity.getBody().containsKey( MetricUnit.ACRE ));
		assertEquals(expectedAcreValue,convertToAcreEntity.getBody().get( "acre" ));
	}

	@Test
	public void givenHectareValueAndIncorrectAcreCheckIfItReturnsFalse(){
		double hectareValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map> convertToAcreEntity = testRestTemplate.exchange(createURLWithPort("/area/hectare/" + hectareValue+"/acre"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double incorrectAcreValue = 1.22;
		assertNotEquals(incorrectAcreValue,convertToAcreEntity.getBody().get( "acre" ));
	}

	@Test
	public void givenAcreValueCheckIfItConvertsToCorrectHectareValue(){
		double acreValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/area/acre/" + acreValue+"/hectare"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedHectareValue = 1.21;
		assertEquals(expectedHectareValue,convertToHectareEntity.getBody().get( "hectare" ));
	}

	@Test
	public void givenAcreValueAndIncorrectHectareCheckIfItReturnsFalse(){
		double acreValue = 3.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToHectareEntity = testRestTemplate.exchange(createURLWithPort("/area/acre/" + acreValue+"/hectare"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double incorrectHectareValue = 7.0;
		assertNotEquals(incorrectHectareValue,convertToHectareEntity.getBody().get( "hectare" ));
	}

	@Test
	public void givenCelsiusValueCheckIfItConvertsToCorrectFahrenheitValue(){
		double celsiusValue = 42;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/temperature/celsius/" + celsiusValue+"/fahreinheit"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedFahrenheitValue = 107.6;
		assertEquals(expectedFahrenheitValue,convertToFahrenheitEntity.getBody().get( "fahreinheit" ));
	}

	@Test
	public void givenCelsiusValueAndIncorrectFahrenheitValue_CheckIfItReturnsFalse(){
		double celsiusValue = 42;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToFahrenheitEntity = testRestTemplate.exchange(createURLWithPort("/temperature/celsius/" + celsiusValue+"/fahreinheit"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double incorrectFahrenheitValue = 5.0;
		assertNotEquals(incorrectFahrenheitValue,convertToFahrenheitEntity.getBody().get("fahreinheit"));
	}

	@Test
	public void givenFahrenheitValueCheckIfItConvertsToCorrectCelsiusValue(){
		double fahrenheitValue = 5.56;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToCelsiusEntity = testRestTemplate.exchange(createURLWithPort("/temperature/fahreinheit/" + fahrenheitValue+"/celsius"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedCelsiusValue = -14.69;
		assertEquals(expectedCelsiusValue,convertToCelsiusEntity.getBody().get("celsius"));
	}

	@Test
	public void givenMeterValueCheckIfItConvertsToCorrectYardValue(){
		double meterValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToYardEntity = testRestTemplate.exchange(createURLWithPort("/distance/meter/" + meterValue+"/yard"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedYardValue = 10.94;
		assertEquals(expectedYardValue,convertToYardEntity.getBody().get( "yard" ));
	}

	@Test
	public void givenYardValueCheckIfItConvertsToCorrectMeterValue(){
		double yardValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToMeterEntity = testRestTemplate.exchange(createURLWithPort("/distance/yard/" + yardValue+"/meter"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedMeterValue = 9.14;
		assertEquals(expectedMeterValue,convertToMeterEntity.getBody().get( "meter" ));
	}

	@Test
	public void givenKilogramsValueCheckIfItConvertsToCorrectPoundValue(){
		double kilogramValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToPoundEntity = testRestTemplate.exchange(createURLWithPort("/weight/kilogram/" + kilogramValue+"/pound"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedPoundValue = 22.05;
		assertEquals(expectedPoundValue,convertToPoundEntity.getBody().get( "pound" ));
	}

	@Test
	public void givenPoundValueCheckIfItConvertsToCorrectKilogramsValue(){
		double poundValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map>  convertToKilogramEntity = testRestTemplate.exchange(createURLWithPort("/weight/pound/" + poundValue+"/kilogram"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedKilogramValue = 4.54;
		assertEquals(expectedKilogramValue,convertToKilogramEntity.getBody().get( "kilogram" ));
	}

	@Test
	public void givenLitreValueCheckIfItConvertsToCorrectPintValue(){
		double litreValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map> convertToPintEntity = testRestTemplate.exchange(createURLWithPort("/volume/litre/" + litreValue+"/pint"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedPintValue = 17.6;
		assertEquals(expectedPintValue,convertToPintEntity.getBody().get("pint"));
	}

	@Test
	public void givenPintValueCheckIfItConvertsToCorrectLitreValue(){
		double pintValue = 10.0;
		HttpEntity<String> entity = new HttpEntity<>(null, httpHeaders);
		ResponseEntity<Map> convertToLitreEntity = testRestTemplate.exchange(createURLWithPort("/volume/pint/" + pintValue+"/litre"),
				HttpMethod.GET,
				entity,
				Map.class);
		Double expectedLitreValue = 5.68;
		assertEquals(expectedLitreValue,convertToLitreEntity.getBody().get( "litre" ));
	}

	private String createURLWithPort(String uri){
		return "http://localhost:" + port + "/converter-api" + uri ;
	}

}

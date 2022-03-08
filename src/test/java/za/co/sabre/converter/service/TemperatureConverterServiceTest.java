package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class TemperatureConverterServiceTest
{
	@InjectMocks
	private TemperatureConverterService temperatureConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(GeneralConverterService.class);
	}

	@Test
	public void givenCelsiusValueConversionToFahreinheitReturnsCorrectValue(){
		assertEquals(37.4, temperatureConverterService.convertToImperial(  3.0 ));
	}

	@Test
	public void givenFarreinheitValueConversionToCelsiusReturnsCorrectValue(){
		assertEquals(-16.11, temperatureConverterService.convertToMetric( 3.0));
	}
}

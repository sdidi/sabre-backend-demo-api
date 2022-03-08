package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.sabre.converter.enums.MetricUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class DistanceConverterServiceTest
{
	@InjectMocks
	private GeneralConverterService generalConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(GeneralConverterService.class);
	}

	@Test
	public void givenMeterValueConversionToYardReturnsCorrectValue(){
		assertEquals(10.94, generalConverterService.convert( 10.0, MetricUnit.METER, MetricUnit.YARD ));
	}

	@Test
	public void givenYardValueConversionToMeterReturnsCorrectValue(){
		assertEquals(8.36, generalConverterService.convert( 9.14, MetricUnit.YARD, MetricUnit.METER ));
	}

}
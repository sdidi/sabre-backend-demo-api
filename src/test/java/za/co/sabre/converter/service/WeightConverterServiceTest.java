package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.sabre.converter.enums.MetricUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class WeightConverterServiceTest
{
	@InjectMocks
	private GeneralConverterService generalConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(GeneralConverterService.class);
	}

	@Test
	public void givenKilogramValueConversionToPoundReturnsCorrectValue(){
		assertEquals(7.41, generalConverterService.convert( 3.0, MetricUnit.HECTARE,MetricUnit.ACRE ));
	}

	@Test
	public void givenPoundValueConversionToKilogramReturnsCorrectValue(){
		assertEquals(1.21, generalConverterService.convert( 3.0 ,MetricUnit.ACRE,MetricUnit.HECTARE));
	}
}

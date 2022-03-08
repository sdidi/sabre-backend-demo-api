package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.sabre.converter.enums.MetricUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class VolumeConverterServiceTest
{
	@InjectMocks
	private GeneralConverterService generalConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(GeneralConverterService.class);
	}

	@Test
	public void givenLitreValueConversionToPintReturnsCorrectValue(){
		assertEquals(5.28, generalConverterService.convert( 3.0, MetricUnit.LITRE,MetricUnit.PINT ));
	}

	@Test
	public void givenPintValueConversionToLitreReturnsCorrectValue(){
		assertEquals(1.7, generalConverterService.convert( 3.0 ,MetricUnit.PINT,MetricUnit.LITRE));
	}
}

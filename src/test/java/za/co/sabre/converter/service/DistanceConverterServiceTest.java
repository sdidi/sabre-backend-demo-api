package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class DistanceConverterServiceTest
{
	@InjectMocks
	private DistanceConverterService distanceConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(AreaConverterService.class);
	}

	@Test
	public void givenHectareValueConversionToAcreReturnsCorrectValue(){
		assertEquals(10.94, distanceConverterService.convertToImperial( 10.0 ));
	}

	@Test
	public void givenAcreValueConversionToHectareReturnsCorrectValue(){
		assertEquals(8.36, distanceConverterService.convertToMetric( 9.14 ));
	}

}
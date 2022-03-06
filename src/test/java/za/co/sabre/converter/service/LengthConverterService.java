package za.co.sabre.converter.service;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class LengthConverterService
{
	@InjectMocks
	private DistanceConverterService lengthConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(AreaConverterService.class);
	}

	@Test
	public void givenHectareValueConversionToAcreReturnsCorrectValue(){
		assertEquals(9.14, lengthConverterService.convertToImperial( 10.0 ));
	}

	@Test
	public void givenAcreValueConversionToHectareReturnsCorrectValue(){
		assertEquals(10.0, lengthConverterService.convertToMetric( 9.14 ));
	}

}
package za.co.sabre.converter.service;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith( MockitoExtension.class)
public class AreaConverterServiceTest
{
	@InjectMocks
	private AreaConverterService areaConverterService;

	@BeforeAll
	public static void init() {
		MockitoAnnotations.openMocks(AreaConverterService.class);
	}

	@Test
	public void givenHectareValueConversionToAcreReturnsCorrectValue(){
		assertEquals(7.41, areaConverterService.convertToImperial( 3.0 ));
	}

	@Test
	public void givenAcreValueConversionToHectareReturnsCorrectValue(){
		assertEquals(1.21, areaConverterService.convertToMetric( 3.0 ));
	}

}

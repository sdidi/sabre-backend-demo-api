package za.co.sabre.converter.menus;

import org.junit.jupiter.api.Test;
import za.co.sabre.converter.enums.MetricUnit;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

public class MetricUnitEnumTest
{
	@Test
	public void checkIfEnumIsValid(){
		MetricUnit acreUnit = MetricUnit.ACRE;
		String input = "acre";
		assertEquals(MetricUnit.valueOf( input.toUpperCase()),acreUnit);
	}

	@Test
	public void checkIfNotValidAreDetected(){
		MetricUnit acreUnit = MetricUnit.ACRE;
		String input = "hectare";
		assertNotEquals(MetricUnit.valueOf( input.toUpperCase()),acreUnit);
	}

	@Test
	public void givenEnums_whenInvalidMetricUnitProvided_illegalArgExceptionIsThrown(){
		assertThatIllegalArgumentException().isThrownBy(()->MetricUnit.valueOf( "ACRES" )  );
	}
}

package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class LengthConverterService implements  MetricConverter
{

	/***
	 * method converts between a yard and meter metric
	 * @param yardValue
	 * @return
	 */
	@Override
	public Double convertToMetric( double yardValue )
	{
		return Precision.round(yardValue / 1.0936,2  );
	}

	/***
	 * method converts between meter metric and yard
	 * @param meterValue
	 * @return
	 */

	@Override
	public Double convertToImperial( double meterValue )
	{
		return Precision.round(meterValue * 1.0936,2  );
	}
}

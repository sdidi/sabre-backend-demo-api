package za.co.sabre.converter.service;

import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Service;

@Service
public class VolumeConverterService implements  ConverterService
{
	@Override
	public Double convertToMetric( double pintValue )
	{
		return Precision.round(pintValue / 1.76,2  );
	}

	@Override
	public Double convertToImperial( double litreValue )
	{
		return Precision.round(litreValue * 1.76,2  );
	}
}

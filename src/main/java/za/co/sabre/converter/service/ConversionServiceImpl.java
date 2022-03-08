package za.co.sabre.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sabre.converter.enums.MetricUnit;

@Service
public class ConversionServiceImpl implements ConversionService
{
	@Autowired
	ITemperatureConverterService temperatureConverterService;

	@Override
	public Double convert(Double value, MetricUnit fromUnit, MetricUnit toUnit)
	{
		switch(fromUnit){
			case CELSIUS:
				return temperatureConverterService.convertToImperial( value );
			case FAHREINHEIT:
				return temperatureConverterService.convertToMetric( value );
			default:
				return 0d;

		}
	}
}

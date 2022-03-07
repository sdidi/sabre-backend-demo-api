package za.co.sabre.converter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.sabre.converter.enums.MetricUnit;

@Service
public class ConversionServiceImpl implements ConversionService
{
	@Autowired
	AreaConverterService areaConverterService;
	@Autowired
	TemperatureConverterService temperatureConverterService;
	@Autowired
	DistanceConverterService distanceConverterService;
	@Autowired
	VolumeConverterService volumeConverterService;
	@Autowired
	WeightConverterService weightConverterService;

	@Override
	public Double convert( MetricUnit fromUnit, MetricUnit toUnit, Double value)
	{
		switch(fromUnit){
			case CELSIUS:
				return temperatureConverterService.convertToImperial( value );
			case FAHREINHEIT:
				return temperatureConverterService.convertToMetric( value );
			case METER:
				return  distanceConverterService.convertToImperial( value );
			case YARD:
				return distanceConverterService.convertToMetric( value );
			case LITRE:
				return volumeConverterService.convertToImperial(value);
			case PINT:
				return volumeConverterService.convertToMetric( value );
			case KILOGRAM:
				return weightConverterService.convertToImperial(value);
			case POUND:
				return weightConverterService.convertToMetric(value);
			case HECTARE:
				return areaConverterService.convertToImperial( value );
			case ACRES:
				return areaConverterService.convertToMetric( value );
			default:
				return 0d;

		}
	}
}

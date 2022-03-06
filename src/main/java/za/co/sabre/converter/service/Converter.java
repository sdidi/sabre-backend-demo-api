package za.co.sabre.converter.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Converter implements  IConverter
{
	@Autowired
	AreaConverterService areaConverterService;
	@Autowired
	LengthConverterService lengthConverterService;
	@Autowired
	MassConverterService massConverterService;
	@Autowired
	TemperatureConverterService temperatureConverterService;
	@Autowired
	VolumeConverterService volumeConverterService;
	public double convert(String fromUnit, String toUnit, Double value)
	{
		Map<String, String> imperialMetricMap = new HashMap<>();
		imperialMetricMap.put( Metric.METER.label, Imperial.YARD.label );
		imperialMetricMap.put( Metric.KILOGRAM.label, Imperial.POUND.label );
		imperialMetricMap.put( Metric.CELSIUS.label, Imperial.FAHREINHEIT.label );
		imperialMetricMap.put( Metric.LITRE.label, Imperial.PINT.label );
		imperialMetricMap.put( Metric.HECTARE.label, Imperial.ACRES.label );
		boolean validInput = false;
		if (imperialMetricMap.containsKey( fromUnit ) &&
				imperialMetricMap.get( fromUnit ).equals( toUnit ))
			validInput = true;
		else if (imperialMetricMap.containsKey( toUnit ) &&
				imperialMetricMap.get( toUnit ).equals( fromUnit ))
			validInput = true;
		if (validInput)
		{
			switch (toUnit)
			{
				case "acre":
					return areaConverterService.convertToMetric( value );
				case "hectare":
					return areaConverterService.convertToImperial( value );
				case "yard":
					return lengthConverterService.convertToMetric( value );
				case "meter":
					return lengthConverterService.convertToImperial( value );
				case "pound":
					return massConverterService.convertToMetric( value );
				case "kilograms":
					return massConverterService.convertToImperial( value );
				case "fahrenheit":
					return temperatureConverterService.convertToMetric( value );
				case "celsius":
					return temperatureConverterService.convertToImperial( value );
				case "pint":
					return volumeConverterService.convertToMetric( value );
				case "litre":
					return volumeConverterService.convertToImperial( value );
				default:
					return 0;
			}
		}
		return 0;
	}
}

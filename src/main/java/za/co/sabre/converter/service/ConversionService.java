package za.co.sabre.converter.service;

import za.co.sabre.converter.enums.MetricUnit;

public interface ConversionService
{
	Double convert( MetricUnit fromUnit, MetricUnit toUnit, Double value);
}

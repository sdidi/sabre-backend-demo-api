package za.co.sabre.converter.service;

import za.co.sabre.converter.enums.MetricUnit;

public interface ConversionService
{
	Double convert(Double value, MetricUnit fromUnit, MetricUnit toUnit);
}

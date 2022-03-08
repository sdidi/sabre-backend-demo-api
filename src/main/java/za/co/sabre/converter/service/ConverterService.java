package za.co.sabre.converter.service;

import za.co.sabre.converter.enums.MetricUnit;

public interface ConverterService
{
	Double convert(Double unitValue, MetricUnit fromUnit, MetricUnit toUnit );
}

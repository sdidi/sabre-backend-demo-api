package za.co.sabre.converter.controller;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.sabre.converter.enums.MetricUnit;
import za.co.sabre.converter.service.*;

@RestController
@RequestMapping("/converter-api")
public class ConverterController
{
	private final static Logger log = Logger.getLogger( ConverterController.class.getName() );

	@Autowired
	ConversionService conversionService;

/*	@GetMapping("/temperature/metric/{metricValue}/imperial")
	public Double convertTemperatureMetric(@PathVariable Double metricValue){
		return temperatureConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/temperature/imperial/{metricValue}/metric")
	public Double convertTemperatureImperial(@PathVariable Double metricValue){
		return temperatureConverterService.convertToMetric(metricValue);
	}*/

	@GetMapping("/temperature/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertTemperature(@PathVariable Double unitValue, @PathVariable MetricUnit fromUnit, MetricUnit toUnit){
		return conversionService.convert( fromUnit,toUnit,unitValue );
	}

	/*@GetMapping("/area/metric/{metricValue}/imperial")
	public Double convertAreaMetric(@PathVariable Double metricValue){
		return areaConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/area/imperial/{metricValue}/metric")
	public Double convertAreaImperial(@PathVariable Double metricValue){
		return areaConverterService.convertToMetric( metricValue );
	}*/

	@GetMapping("/area/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertArea(@PathVariable Double unitValue, @PathVariable MetricUnit fromUnit, MetricUnit toUnit){
		return conversionService.convert( fromUnit,toUnit,unitValue );
	}

/*	@GetMapping("/distance/metric/{metricValue}/imperial")
	public Double convertDistanceMetric(@PathVariable Double metricValue){
		return distanceConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/distance/imperial/{metricValue}/metric")
	public Double convertDistanceImperial(@PathVariable Double metricValue){
		return distanceConverterService.convertToMetric(metricValue);
	}*/

	@GetMapping("/distance/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertDistancel(@PathVariable Double unitValue, @PathVariable MetricUnit fromUnit, MetricUnit toUnit){
		return conversionService.convert( fromUnit,toUnit,unitValue );
	}


	/*@GetMapping("/distance2/metric/{metricValue}/imperial")
	public Double convertDistance2Metric(@PathVariable Double metricValue){
		return distanceConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/weight/metric/{metricValue}/imperial")
	public Double convertWeightMetric(@PathVariable Double metricValue){
		return weightConverterService.convertToImperial(metricValue);
	}*/

	@GetMapping("/weight/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertWeightMetric(@PathVariable Double unitValue, @PathVariable MetricUnit fromUnit, MetricUnit toUnit){
		return conversionService.convert( fromUnit,toUnit,unitValue );
	}

/*	@GetMapping("/weight/imperial/{metricValue}/metric")
	public Double convertWeightImperial(@PathVariable Double metricValue){
		return weightConverterService.convertToMetric(metricValue);
	}

	@GetMapping("/volume/metric/{metricValue}/imperial")
	public Double convertVolumeMetric(@PathVariable Double metricValue){
		return volumeConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/volume/imperial/{metricValue}/metric")
	public Double convertVolumeImperial(@PathVariable Double metricValue){
		return volumeConverterService.convertToMetric(metricValue);
	}*/

	@GetMapping("/volume/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertVolume(@PathVariable Double unitValue, @PathVariable MetricUnit fromUnit, MetricUnit toUnit){
		return conversionService.convert( fromUnit,toUnit,unitValue );
	}


}

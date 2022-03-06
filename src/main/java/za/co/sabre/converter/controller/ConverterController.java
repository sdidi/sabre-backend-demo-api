package za.co.sabre.converter.controller;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.co.sabre.converter.service.*;

@RestController
@RequestMapping("/converter-api")
public class ConverterController
{
	private final static Logger log = Logger.getLogger( ConverterController.class.getName() );
	@Autowired
	AreaConverterService areaConverterService;
	@Autowired
	DistanceConverterService distanceConverterService;
	@Autowired
	WeightConverterService weightConverterService;
	@Autowired
	TemperatureConverterService temperatureConverterService;
	@Autowired
	VolumeConverterService volumeConverterService;
	/*@Autowired
	ConverterService converterService;*/

	@GetMapping("/temperature/metric/{metricValue}/imperial")
	public Double convertTemperatureMetric(@PathVariable Double metricValue){
		return temperatureConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/temperature/imperial/{metricValue}/metric")
	public Double convertTemperatureImperial(@PathVariable MetricUnit metricUnit,
			@PathVariable ImperialUnit imperialUnit, @PathVariable Double metricValue){
		return temperatureConverterService.convertToMetric(metricValue);
	}

	@GetMapping("/area/metric/{metricValue}/imperial")
	public Double convertAreaMetric(@PathVariable MetricUnit metricUnit,
			@PathVariable ImperialUnit imperialUnit, @PathVariable Double metricValue){
		return areaConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/area/imperial/{metricValue}/metric")
	public Double convertAreaImperial(@PathVariable Double metricValue){
		return areaConverterService.convertToMetric( metricValue );
	}

	@GetMapping("/distance/metric/{metricValue}/imperial")
	public Double convertDistanceMetric(@PathVariable Double metricValue){
		return distanceConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/distance/imperial/{metricValue}/metric")
	public Double convertDistanceImperial(@PathVariable Double metricValue){
		return distanceConverterService.convertToMetric(metricValue);
	}

	@GetMapping("/weight/metric/{metricValue}/imperial")
	public Double convertWeightMetric(@PathVariable Double metricValue){
		return weightConverterService.convertToImperial(metricValue);
	}

	@GetMapping("/weight/imperial/{metricValue}/metric")
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
	}

		/*@GetMapping("/temperature/imperial/{metricValue}/metric")
	public Double convertTemperatureImperial(@PathVariable MetricUnit metricUnit,
			@PathVariable ImperialUnit imperialUnit, @PathVariable Double metricValue){
		return converter.convert(metricValue, metricUnit, imperialUnit);
	}
*/

}

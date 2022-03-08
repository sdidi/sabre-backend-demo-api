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
	ConverterService converterService;
	@Autowired
	ConversionService temperatureConverter;

	@GetMapping("/temperature/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertTemperature(@PathVariable Double unitValue, @PathVariable String fromUnit, @PathVariable() String toUnit){
		return temperatureConverter.convert(unitValue, MetricUnit.valueOf( fromUnit.toUpperCase()),MetricUnit.valueOf(toUnit.toUpperCase()) );
	}

	@GetMapping("/area/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertArea(@PathVariable Double unitValue, @PathVariable String fromUnit, @PathVariable() String toUnit){
		return converterService.convert(unitValue, MetricUnit.valueOf( fromUnit.toUpperCase()),MetricUnit.valueOf(toUnit.toUpperCase()) );
	}

	@GetMapping("/distance/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertDistance(@PathVariable Double unitValue, @PathVariable String fromUnit, @PathVariable() String toUnit){
		return converterService.convert(unitValue, MetricUnit.valueOf( fromUnit.toUpperCase()),MetricUnit.valueOf(toUnit.toUpperCase()) );
	}

	@GetMapping("/weight/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertWeightMetric(@PathVariable Double unitValue, @PathVariable String fromUnit, @PathVariable() String toUnit){
		return converterService.convert(unitValue, MetricUnit.valueOf( fromUnit.toUpperCase()),MetricUnit.valueOf(toUnit.toUpperCase()) );
	}

	@GetMapping("/volume/{fromUnit}/{unitValue}/{toUnit}")
	public Double convertVolume(@PathVariable Double unitValue, @PathVariable String fromUnit, @PathVariable() String toUnit){
		return converterService.convert(unitValue, MetricUnit.valueOf( fromUnit.toUpperCase()),MetricUnit.valueOf(toUnit.toUpperCase()) );
	}


}

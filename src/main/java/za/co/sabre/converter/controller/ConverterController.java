package za.co.sabre.converter.controller;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
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

	Map<String,Double> resultMap = new HashMap<>();

	@GetMapping("/temperature/{fromUnit}/{unitValue}/{toUnit}")
	public ResponseEntity<Map<String,Double>> convertTemperature(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable() String toUnit){
		Double result = temperatureConverter.convert(unitValue,
				MetricUnit.valueOf( fromUnit.toUpperCase()),
				MetricUnit.valueOf(toUnit.toUpperCase()));
		resultantMap( toUnit, result );
		return new ResponseEntity<>( resultMap, HttpStatus.OK);
	}

	@GetMapping("/area/{fromUnit}/{unitValue}/{toUnit}")
	public ResponseEntity<Map<String,Double>> convertArea(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable() String toUnit){
		return getMapResponseEntity( unitValue, fromUnit, toUnit );
	}

	@GetMapping("/distance/{fromUnit}/{unitValue}/{toUnit}")
	public ResponseEntity<Map<String,Double>> convertDistance(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable() String toUnit){
		return getMapResponseEntity( unitValue, fromUnit, toUnit );
	}

	@GetMapping("/weight/{fromUnit}/{unitValue}/{toUnit}")
	public ResponseEntity<Map<String,Double>> convertWeightMetric(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable() String toUnit){
		return getMapResponseEntity( unitValue, fromUnit, toUnit );
	}

	@GetMapping("/volume/{fromUnit}/{unitValue}/{toUnit}")
	public ResponseEntity<Map<String,Double>> convertVolume(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable() String toUnit){
		return getMapResponseEntity( unitValue, fromUnit, toUnit );
	}

	public ResponseEntity<Map<String, Double>> getMapResponseEntity(
			@PathVariable Double unitValue,
			@PathVariable String fromUnit,
			@PathVariable String toUnit )
	{
		Double result = converterService.convert(unitValue,
				MetricUnit.valueOf( fromUnit.toUpperCase()),
				MetricUnit.valueOf(toUnit.toUpperCase()) );
		resultantMap( toUnit, result );
		return new ResponseEntity<>( resultMap, HttpStatus.OK);
	}

	private void resultantMap( @PathVariable String toUnit, Double result )
	{
		BiConsumer<String, Double> stringDoubleBiConsumer = ( toUnit1, result1 ) -> {
			resultMap.clear();
			resultMap.put( toUnit1, result1 );
		};
		stringDoubleBiConsumer.accept( toUnit, result );
	}
}

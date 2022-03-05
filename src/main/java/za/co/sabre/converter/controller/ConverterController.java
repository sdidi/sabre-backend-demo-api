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
	private IConverter converter;

	@GetMapping("/{fromMetric}/{toMetric}/{metricValue}")
	public Double convertMetric(@PathVariable String fromMetric,
			@PathVariable String toMetric, @PathVariable Double metricValue){
		return converter.convert( fromMetric, toMetric, metricValue );
	}



}

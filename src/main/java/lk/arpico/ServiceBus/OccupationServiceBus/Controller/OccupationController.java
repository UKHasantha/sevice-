package lk.arpico.ServiceBus.OccupationServiceBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationDto;
import lk.arpico.ServiceBus.OccupationServiceBus.Service.OccupationService;

@RestController
@RequestMapping("occupation")
@CrossOrigin("*")
public class OccupationController {

	@Autowired
	private OccupationService occupationService;

	@Autowired
	private WebClient webClient;

	@GetMapping("/all")
	public List<OccupationDto> getAll() {
		return occupationService.getAllOccupation();
	}

	@GetMapping("/search/{type}/{value}")
	public OccupationDto searchBySName(@PathVariable String type, @PathVariable String value) {
		System.out.println("ijse :"+type+": :"+value);
		return occupationService.searchOccupation(type, value);
	}

	@PostMapping("/add")
	public void add(@RequestBody OccupationDto occupationDto) {
		occupationService.add(occupationDto);
	}

	@PutMapping("/update")
	public void update(@RequestBody OccupationDto occupationDto) {

		occupationService.updateOccupation(occupationDto);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable String id) {
		occupationService.deleteOccupation(id);

	}

//	@PostMapping("/saveNew")
//	public void saveNew(@RequestBody OccupationDto occupationDto) {
//		System.out.println(occupationDto);
//		webClient.saveNew(occupationDto);
//	}
//	
}

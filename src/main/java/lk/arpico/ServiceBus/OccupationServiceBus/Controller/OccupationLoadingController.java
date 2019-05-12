package lk.arpico.ServiceBus.OccupationServiceBus.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationLoadingDto;
import lk.arpico.ServiceBus.OccupationServiceBus.Service.OccupationLoadingService;

@RestController
@RequestMapping("occupationLoading")
@CrossOrigin("*")
public class OccupationLoadingController {

	@Autowired
	private OccupationLoadingService occupationLoading;

	@PostMapping("/add")
	public void add(@RequestBody OccupationLoadingDto occupationLoadingDto) {
		occupationLoading.add(occupationLoadingDto);
	}

	@GetMapping("/search/{type}/{value}")
	public List<OccupationLoadingDto> searchBySName(@PathVariable String type, @PathVariable String value) {
		return occupationLoading.searchOccupation(type, value);
	}

	@GetMapping("/all")
	public OccupationLoadingDto[] getAll() {
		return occupationLoading.getAlloccupationLoading();
	}

	@PutMapping("/update")
	public void occupationLoadingUpdate(@RequestBody List<OccupationLoadingDto> occupationLoadingDto) {
		occupationLoading.updateOccupationLoading(occupationLoadingDto);

	}

	@GetMapping("/searchBysName/{type}/{sName}")
	public List<String> search(@PathVariable String type,@PathVariable String sName) {
		System.out.println("Short Name :"+sName);
		return occupationLoading.searchBysName(type,sName);

	}
	
	@GetMapping("/searchByname/{type}/{name}")
	public List<String> searchName(@PathVariable String type,@PathVariable String name) {
		System.out.println("Name :"+type+","+name);
		return occupationLoading.searchByName(type, name);

	}
	
	@GetMapping("/searchBycode/{type}/{code}")
	public List<String> searchcode(@PathVariable String type,@PathVariable String code) {
		System.out.println("Short Name :"+code);
		return occupationLoading.searchById(type,code);

	}

	/*
	 * @GetMapping("/searchById/{id}") public OccupationLoadingDto
	 * search(@PathVariable String id){
	 * 
	 * return webClient.searchById(id);
	 * 
	 * }
	 * 
	 * @GetMapping("/searchByCode/{code}") public OccupationLoadingDto
	 * searchByCode(@PathVariable String code ) { return
	 * webClient.searchByCode(code); }
	 * 
	 * @GetMapping("/searchByName/{name}") public OccupationLoadingDto
	 * searchByName(@PathVariable String name) { return
	 * webClient.searchByName(name);
	 * 
	 * }
	 */

}

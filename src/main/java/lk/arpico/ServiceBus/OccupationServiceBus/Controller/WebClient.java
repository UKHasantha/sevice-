package lk.arpico.ServiceBus.OccupationServiceBus.Controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationLoadingDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.RiderDto;

@Component
public class WebClient {

	public OccupationDto[] getAllOccupation() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/all", OccupationDto[].class);
	}

	public void saveOccupation(OccupationDto occupationDto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8095/occupation/add", occupationDto, OccupationDto.class);

	}

	public void saveOccupationLoading(OccupationLoadingDto occupationLoadingDto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8095/occupation_loading/add", occupationLoadingDto,
				OccupationLoadingDto.class);

	}

	public OccupationLoadingDto[] getAlloccupationLoading() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/all", OccupationLoadingDto[].class);
	}

	public OccupationDto searchBy(String type, String value) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation_loading/findBy+type+" + value,OccupationDto.class);
	}

	public RiderDto[] getAllRiders() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/Rider/all", RiderDto[].class);

	}

	public void saveOccupationLoading(List<OccupationLoadingDto> occupationLoadingDtos) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8095/occupation_loading/add", occupationLoadingDtos,
				OccupationLoadingDto.class);

	}

	public OccupationDto[] getAllOccupations() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/all", OccupationDto[].class);
	}

	public void saveNew(OccupationDto occupationDto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.postForObject("http://localhost:8095/occupation/add", occupationDto, OccupationDto.class);

	}

	public void updateOccupation(OccupationDto occupationDto) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8095/occupation/update", occupationDto, OccupationDto.class);

	}

	public void deleteOccupation(String id) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8095/occupation/delete/" + id);

	}

	public void occupationLoadingUpdate(List<OccupationLoadingDto> occupationLoading) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://644localhost:8095/occupationLoading/update", occupationLoading,
				OccupationLoadingDto[].class);
	}

	public String getIdOfCode(String value) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/searchIdByCode/" + value, String.class);
	}

	public OccupationLoadingDto[] searchOccupationByCode(String idOfCode) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation_loading/getSearchedOccupation/" + idOfCode,
				OccupationLoadingDto[].class);
	}

	public String getIdOfName(String value) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/searchIdByName/" + value, String.class);
	}

	public String getIdOfSName(String value) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject("http://localhost:8095/occupation/searchIdBySName/" + value, String.class);
	}

//		public OccupationLoadingDto searchById(String id) {
//			RestTemplate restTemplate=new RestTemplate();
//			
//			return restTemplate.getForObject("http://localhost:8095/occupation_loading/findById/"+id,OccupationLoadingDto.class);
//		}
//
//		public OccupationLoadingDto searchByCode(String code) {
//			RestTemplate restTemplate=new RestTemplate();
//			return restTemplate.getForObject("http://localhost:8095/occupation_loading/findByCode/"+code, OccupationLoadingDto.class);
//		}
//
//		public OccupationLoadingDto searchByName(String name) {
//			RestTemplate restTemplate=new RestTemplate();
//			return restTemplate.getForObject("http://localhost:8095/occupation_loading/findByCode/"+name, OccupationLoadingDto.class);
//		}
//
//		public OccupationLoadingDto searchBySName(String sName) {
//			RestTemplate restTemplate=new RestTemplate();
//			return restTemplate.getForObject("http://localhost:8095/occupation_loading/findBySName/"+sName, OccupationLoadingDto.class);
//		}
//

}

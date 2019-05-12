package lk.arpico.ServiceBus.OccupationServiceBus.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lk.arpico.ServiceBus.OccupationServiceBus.Controller.WebClient;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationLoadingDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.RiderDto;
import lk.arpico.ServiceBus.OccupationServiceBus.Service.OccupationService;

@Service
public class OccupationServiceImpl implements OccupationService {

	@Autowired
	private WebClient webClient;

	@Override
	public void add(OccupationDto occupation) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();

		OccupationDto occupationDto = new OccupationDto();

		occupationDto.setOccupationId(occupation.getOccupationId());
		occupationDto.setCode(occupation.getCode());
		occupationDto.setCreateBy("Ash");
		occupationDto.setCreateDate(date);
		occupationDto.setIsEnable(1);
//		occupationDto.setModifyBy(occupation.getModifyBy());
//		occupationDto.setModifyDate(occupation.getModifyDate());
		occupationDto.setName(occupation.getName());
		occupationDto.setsName(occupation.getsName());
		System.out.println(occupation.getOccupationId());
		System.out.println("jkddfh" + webClient.getAllRiders());
		webClient.saveOccupation(occupationDto);

		List<RiderDto> allRiders = Arrays.asList(webClient.getAllRiders());

		List<OccupationLoadingDto> occupationLoadingDtos = new ArrayList<OccupationLoadingDto>();

		allRiders.forEach(e -> {

			OccupationLoadingDto occupationLoading = new OccupationLoadingDto();
			occupationLoading.setOccupationLoadingId(UUID.randomUUID().toString());
			occupationLoading.setCreateBy("Ash");
			occupationLoading.setCreateDate(date);
			occupationLoading.setEmRate(0.0);
			occupationLoading.setIsEnable(1);
//			occupationLoading.setModifyBy(occupation.getModifyBy());
//			occupationLoading.setModifyDate(occupation.getModifyDate());
			occupationLoading.setRateMil(0.0);
			occupationLoading.setSubRate(0.0);
			occupationLoading.setValue(0.0);
			System.out.println(e.getId());
			occupationLoading.setRiderId(e.getId());
			System.out.println(occupationDto.getOccupationId());
			occupationLoading.setOccupationId(occupationDto.getOccupationId());
			System.out.println(occupationLoading);
			occupationLoadingDtos.add(occupationLoading);

		});

		webClient.saveOccupationLoading(occupationLoadingDtos);

	}

	@Override
	public List<OccupationDto> getAllOccupation() {

		List<OccupationDto> m = Arrays.asList(webClient.getAllOccupation());
		// return webClient.getAllOccupations();
		return m;
	}

	@Override
	public OccupationDto searchOccupation(String type, String value) {
		System.out.println("occ"+type+""+value);
		return webClient.searchBy(type, value);
	}

	@Override
	public void updateOccupation(OccupationDto occupation) {
		OccupationDto occupationDto = new OccupationDto();
		occupationDto.setOccupationId(occupation.getOccupationId());
		occupationDto.setCode(occupation.getCode());
		occupationDto.setCreateBy(occupation.getCreateBy());
		occupationDto.setCreateDate(occupation.getCreateDate());
		occupationDto.setIsEnable(occupation.getIsEnable());
		occupationDto.setModifyBy(occupation.getModifyBy());
		occupationDto.setModifyDate(occupation.getModifyDate());
		occupationDto.setName(occupation.getName());
		occupationDto.setsName(occupation.getsName());

		webClient.updateOccupation(occupationDto);

	}

	@Override
	public void deleteOccupation(String id) {
		webClient.deleteOccupation(id);

	}

}

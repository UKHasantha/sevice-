package lk.arpico.ServiceBus.OccupationServiceBus.Service.Impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
import lk.arpico.ServiceBus.OccupationServiceBus.Controller.WebClient;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.CommonOccupationDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationLoadingDto;
import lk.arpico.ServiceBus.OccupationServiceBus.Service.OccupationLoadingService;

@Service
public class OccupationLoadingServiceImpl implements OccupationLoadingService {

	@Autowired
	private WebClient webClient;

	@Override
	public void add(OccupationLoadingDto occupationLoading) {
		// TODO Auto-generated method stub
		OccupationLoadingDto occupationLoadingDto = new OccupationLoadingDto();

		occupationLoadingDto.setOccupationLoadingId(occupationLoading.getOccupationLoadingId());
		occupationLoadingDto.setCreateBy(occupationLoading.getCreateBy());
		occupationLoadingDto.setCreateDate(occupationLoading.getCreateDate());
		occupationLoadingDto.setEmRate(occupationLoading.getEmRate());
		occupationLoadingDto.setIsEnable(occupationLoading.getIsEnable());
		occupationLoadingDto.setModifyBy(occupationLoading.getModifyBy());
		occupationLoadingDto.setModifyDate(occupationLoading.getModifyDate());
		occupationLoadingDto.setRateMil(occupationLoading.getRateMil());
		occupationLoadingDto.setSubRate(occupationLoading.getSubRate());
		webClient.saveOccupationLoading(occupationLoadingDto);

	}

	@Override
	public OccupationLoadingDto[] getAlloccupationLoading() {
		return webClient.getAlloccupationLoading();
	}

	@Override
	public void updateOccupationLoading(List<OccupationLoadingDto> occupationLoading) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		webClient.occupationLoadingUpdate(occupationLoading);

	}

	@Override
	public List<OccupationLoadingDto> searchOccupation(String type, String value) {
		System.out.println("TYPE :" + type);
		List<OccupationLoadingDto> list = new ArrayList<>();
		if (type.equalsIgnoreCase("code")) {
			String idOfCode = webClient.getIdOfCode(value);
			System.out.println("Id of Code :" + idOfCode);

			List<OccupationLoadingDto> m = Arrays.asList(webClient.searchOccupationByCode(idOfCode));
			for (OccupationLoadingDto c : m) {
				list.add(new OccupationLoadingDto(c.getOccupationLoadingId(), c.getCreateBy(), c.getCreateDate(),
						c.getEmRate(), c.getIsEnable(), c.getModifyBy(), c.getModifyDate(), c.getRateMil(),
						c.getSubRate(), c.getValue(), c.getRiderId(), c.getOccupationId()));

			}

		} else if (type.equalsIgnoreCase("name")) {
			String idOfCode = webClient.getIdOfName(value);

			List<OccupationLoadingDto> m = Arrays.asList(webClient.searchOccupationByCode(idOfCode));
			for (OccupationLoadingDto c : m) {
				list.add(new OccupationLoadingDto(c.getOccupationLoadingId(), c.getCreateBy(), c.getCreateDate(),
						c.getEmRate(), c.getIsEnable(), c.getModifyBy(), c.getModifyDate(), c.getRateMil(),
						c.getSubRate(), c.getValue(), c.getRiderId(), c.getOccupationId()));

			}

		} else if (type.equalsIgnoreCase("sName")) {
			String idOfCode = webClient.getIdOfSName(value);

			List<OccupationLoadingDto> m = Arrays.asList(webClient.searchOccupationByCode(idOfCode));
			for (OccupationLoadingDto c : m) {
				list.add(new OccupationLoadingDto(c.getOccupationLoadingId(), c.getCreateBy(), c.getCreateDate(),
						c.getEmRate(), c.getIsEnable(), c.getModifyBy(), c.getModifyDate(), c.getRateMil(),
						c.getSubRate(), c.getValue(), c.getRiderId(), c.getOccupationId()));

			}
			System.out.println("sNames: " + list);
		}
		return list;
	}

	@Override
	public List<String> searchById(String type, String code) {

		String y = "Code";

		if (!type.equals(y)) {
			System.out.println("if types :" + type);
			throw new RuntimeException("Invalid Type..." + type);
		} else {

			String x = "";
			x = code;

			if (x.length() != 3) {
				throw new RuntimeException("code Length is not 3...");
			} else {
				List<String> list = Arrays.asList(webClient.getIdOfCode(code));
				System.out.println("List :" + list);
				return list;
			}
		}
	}

	@Override
	public List<String> searchBysName(String type, String sName) {

		String y = "S_name";

		if (!type.equals(y)) {
			System.out.println("if types :" + type);
			throw new RuntimeException("Invalid Type..." + type);
		} else {

			String x = "";
			x = sName;

			if (x.length() != 3 && type.equals("sName")) {
				throw new RuntimeException("sName Length is not 3...");
			} else {
				List<String> list = Arrays.asList(webClient.getIdOfSName(sName));
				System.out.println("List :" + list);
				return list;
			}

		}
	}

	@Override
	public List<String> searchByName(String type, String name) {

		String y = "Name";

		if (!type.equals(y)) {
			System.out.println("if types :" + type);
			throw new RuntimeException("Invalid Type..." + type);
		} else {

			String x = "";
			x = name;

			if (x.length() != 3) {
				throw new RuntimeException("Name Length is not 3...");
			} else {

				List<String> list = Arrays.asList(webClient.getIdOfName(name));
				System.out.println("List :" + list);
				return list;

			}
		}
	}
}

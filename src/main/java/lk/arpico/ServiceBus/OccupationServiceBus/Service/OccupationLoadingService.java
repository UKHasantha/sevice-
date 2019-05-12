package lk.arpico.ServiceBus.OccupationServiceBus.Service;

import java.util.List;

import lk.arpico.ServiceBus.OccupationServiceBus.DTO.CommonOccupationDto;
import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationLoadingDto;

public interface OccupationLoadingService {

	void add(OccupationLoadingDto occupationLoadingDto);

	OccupationLoadingDto[] getAlloccupationLoading();

//	void updateOccupationLoading(OccupationLoadingDto occupationLoadingDto);

	List<OccupationLoadingDto> searchOccupation(String type, String value);
	
	List<String> searchById(String type,String code);

	void updateOccupationLoading(List<OccupationLoadingDto> occupationLoadingDto);
	
	List<String> searchBysName(String type,String sName);
	
	List<String> searchByName(String type,String name);
	                                    
}

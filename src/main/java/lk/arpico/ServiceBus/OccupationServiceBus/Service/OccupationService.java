package lk.arpico.ServiceBus.OccupationServiceBus.Service;

import java.util.List;

import lk.arpico.ServiceBus.OccupationServiceBus.DTO.OccupationDto;

public interface OccupationService {

	void add(OccupationDto occupationDto);

	List<OccupationDto> getAllOccupation();

	OccupationDto searchOccupation(String type, String value);

	void updateOccupation(OccupationDto occupationDto);

	void deleteOccupation(String id);

}

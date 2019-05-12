package lk.arpico.ServiceBus.OccupationServiceBus.DTO;

import java.util.Date;
import java.util.List;

public class CommonOccupationDto {

	private String code;
	private String name;
	private String sName;
	private List<CommonOccupationLoadingDto> occupationLoading;

	public CommonOccupationDto() {
		// TODO Auto-generated constructor stub
	}

	public CommonOccupationDto(String code, String name, String sName,
			List<CommonOccupationLoadingDto> occupationLoading) {
		super();
		this.code = code;
		this.name = name;
		this.sName = sName;
		this.occupationLoading = occupationLoading;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public List<CommonOccupationLoadingDto> getOccupationLoading() {
		return occupationLoading;
	}

	public void setOccupationLoading(List<CommonOccupationLoadingDto> occupationLoading) {
		this.occupationLoading = occupationLoading;
	}

	@Override
	public String toString() {
		return "CommonOccupationDto [code=" + code + ", name=" + name + ", sName=" + sName + ", occupationLoading="
				+ occupationLoading + "]";
	}

}

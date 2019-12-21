package com.mindtree.librarydata.dto;

import java.util.List;

public class LibraryDto {
	private int libraryId;
	private String libraryName;
	private String libraryAddress;
	private List<UserDto> userDtos;

	public LibraryDto() {
		super();
	}

	public LibraryDto(int libraryId, String libraryName, String libraryAddress) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress = libraryAddress;
	}

	public LibraryDto(int libraryId, String libraryName,String libraryAddress, List<UserDto> userDtos) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.libraryAddress=libraryAddress;
		this.userDtos = userDtos;
	}

	public int getLibraryId() {
		return libraryId;
	}

	public void setLibraryId(int libraryId) {
		this.libraryId = libraryId;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}

	public String getLibraryAddress() {
		return libraryAddress;
	}

	public void setLibraryAddress(String libraryAddress) {
		this.libraryAddress = libraryAddress;
	}

	public List<UserDto> getUserDtos() {
		return userDtos;
	}

	public void setUserDtos(List<UserDto> userDtos) {
		this.userDtos = userDtos;
	}

}

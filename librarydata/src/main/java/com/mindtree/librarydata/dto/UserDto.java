package com.mindtree.librarydata.dto;

import java.util.List;

public class UserDto {
	private int userId;

	private String userName;
	private String userAddress;
	private List<LibraryDto> libraries;

	public UserDto() {
		super();
	}

	public UserDto(int userId, String userName, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
	}

	public UserDto(int userId, String userName, String userAddress, List<LibraryDto> libraries) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.libraries = libraries;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public List<LibraryDto> getLibraries() {
		return libraries;
	}

	public void setLibraries(List<LibraryDto> libraries) {
		this.libraries = libraries;
	}

}

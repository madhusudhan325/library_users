package com.mindtree.librarydata.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class Users {
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	@Column(name = "USER_NAME")
	private String userName;
	@Column(name = "USER_ADDRESS")
	private String userAddress;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="library_users",joinColumns = {@JoinColumn(name="userId")},inverseJoinColumns = {@JoinColumn(name="libraryId")})
	private List<Library> librarys;

	public Users() {
		super();
	}

	public Users(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Users(int userId, String userName, String userAddress) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
	}

	public Users(int userId, String userName, String userAddress, List<Library> librarys) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userAddress = userAddress;
		this.librarys = librarys;
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

	public List<Library> getLibrarys() {
		return librarys;
	}

	public void setLibrarys(List<Library> librarys) {
		this.librarys = librarys;
	}

}

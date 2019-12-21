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
@Table(name = "LIBRARY")
public class Library {
	@Id
	@Column(name = "LIBRARY_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int libraryId;
	@Column(name = "LIBRARY_NAME")
	private String libraryName;
	@Column(name = "LIBRARY_ADDRESS")
	private String librayAddress;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "library_users", joinColumns= {@JoinColumn(name="libraryId")},inverseJoinColumns = {@JoinColumn(name="userId")})
	private List<Users> users;

	public Library() {
		super();
	}

	public Library(int libraryId, String libraryName) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
	}

	public Library(int libraryId, String libraryName, String librayAddress) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.librayAddress = librayAddress;
	}

	public Library(int libraryId, String libraryName, String librayAddress, List<Users> users) {
		super();
		this.libraryId = libraryId;
		this.libraryName = libraryName;
		this.librayAddress = librayAddress;
		this.users = users;
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

	public String getLibrayAddress() {
		return librayAddress;
	}

	public void setLibrayAddress(String librayAddress) {
		this.librayAddress = librayAddress;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

}

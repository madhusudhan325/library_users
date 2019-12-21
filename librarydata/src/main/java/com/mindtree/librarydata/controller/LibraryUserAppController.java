package com.mindtree.librarydata.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.librarydata.dto.LibraryDto;
import com.mindtree.librarydata.dto.UserDto;
import com.mindtree.librarydata.exception.ServiceException;
import com.mindtree.librarydata.service.LibraryUserService;

@Component
@RestController
public class LibraryUserAppController {
	@Autowired
	private LibraryUserService libraryUserService;

	@PostMapping("/insertlibrary")
	public ResponseEntity<Map<String, Object>> addLibraryData(@RequestBody LibraryDto libraryDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.registerLibrary(libraryDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	@PostMapping("/insertlibrarydata")
	public ResponseEntity<Map<String, Object>> insertLibraryData(@RequestBody LibraryDto libraryDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.insertOnlyLibrary(libraryDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PostMapping("/insertlibrarydata/{libraryId}")
	public ResponseEntity<Map<String, Object>> insertUsersForLibrary(@PathVariable int libraryId,@RequestBody UserDto userDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.insertUsersForParticularLibrary(libraryId,userDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	@PostMapping("/insertuser")
	public ResponseEntity<Map<String, Object>> addUserDataToLibrariess(@RequestBody UserDto userDto) {
		Map<String, Object> response = new LinkedHashMap<>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.registerUsers(userDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@GetMapping("/getlibrarydata")
	public ResponseEntity<Map<String, Object>> getAllDetails() {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("body", libraryUserService.getAllDataFromDB());
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/getlibrarydatabyusercount")
	public ResponseEntity<Map<String, Object>> getAllDetailsByUserCount() throws ServiceException {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("body", libraryUserService.getAllUsersOfLibraryHavingUsersMorethanThree());
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@PutMapping(value = "updateuseraddress/{libraryId}/{userId}")
	public ResponseEntity<Map<String, Object>> updateUserAddressForParticularUserByUserId(@PathVariable int libraryId,
			@PathVariable int userId, @RequestBody UserDto userDto) throws ServiceException {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.updateUserAddressForParticularLibrary(libraryId, userId, userDto));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deleteuser/{libraryId}/{userId}")
	public ResponseEntity<Map<String, Object>> deleteAUser(@PathVariable int libraryId, @PathVariable int userId) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.deleteUserDataByUserId(libraryId,userId));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/deletelibrary/{libraryId}")
	public ResponseEntity<Map<String, Object>> deleteLibrary(@PathVariable int libraryId) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("header", "library users");
		response.put("Error", false);
		response.put("message", libraryUserService.deleteLibraryDataByLibraryId(libraryId));
		response.put("Httpstatus", HttpStatus.OK);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}

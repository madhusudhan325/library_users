package com.mindtree.librarydata.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mindtree.librarydata.dto.LibraryDto;
import com.mindtree.librarydata.dto.UserDto;
import com.mindtree.librarydata.exception.ServiceException;

@Service
public interface LibraryUserService {
	
	/**
	 * @param libraryDto
	 * @return message if inserted or not
	 */
	public String registerLibrary(LibraryDto libraryDto);
	
	/**
	 * @param libraryDto
	 * @return message if inserted or not
	 */
	public String insertOnlyLibrary(LibraryDto libraryDto);
	
	/**
	 * @param userDto
	 * @return message if inserted or not
	 */
	public String registerUsers(UserDto userDto);
	
	/**
	 * @return all data from database
	 */
	public List<LibraryDto> getAllDataFromDB();
	
	/**
	 * @return data from database if condition satisfies
	 * @throws ServiceException if condition doesn't satisfy shows message
	 */
	public List<LibraryDto> getAllUsersOfLibraryHavingUsersMorethanThree() throws ServiceException;

	/**
	 * @param libraryId
	 * @param userId
	 * @param userDto
	 * @return message if updated
	 * @throws ServiceException  if condition doesn't satisfy shows message
	 */
	public String updateUserAddressForParticularLibrary(int libraryId,int userId,UserDto userDto) throws ServiceException;

	/**
	 * @param libraryId
	 * @param userId
	 * @return message deleted or not
	 */
	public String deleteUserDataByUserId(int libraryId,int userId);

	/**
	 * @param libraryId
	 * @return message deleted or not
	 */
	public String deleteLibraryDataByLibraryId(int libraryId);
	
	/**
	 * @param libraryId
	 * @param userDto
	 * @return  message if inserted or not
	 */
	public String insertUsersForParticularLibrary(int libraryId,UserDto userDto);
}

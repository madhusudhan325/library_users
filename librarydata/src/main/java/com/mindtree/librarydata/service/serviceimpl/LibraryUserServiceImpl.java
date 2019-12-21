package com.mindtree.librarydata.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.librarydata.dto.LibraryDto;
import com.mindtree.librarydata.dto.UserDto;
import com.mindtree.librarydata.entity.Library;
import com.mindtree.librarydata.entity.Users;
import com.mindtree.librarydata.exception.ServiceException;
import com.mindtree.librarydata.exception.util.ErrorConstants;
import com.mindtree.librarydata.repository.LibraryRepository;
import com.mindtree.librarydata.repository.UserRepository;
import com.mindtree.librarydata.service.LibraryUserService;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {
	@Autowired
	private LibraryRepository libraryRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public String registerLibrary(LibraryDto libraryDto) {
		Library library = new Library();
		List<Users> userList = new ArrayList<>();
		library.setLibraryId(libraryDto.getLibraryId());
		library.setLibraryName(libraryDto.getLibraryName());
		library.setLibrayAddress(libraryDto.getLibraryAddress());
		if (libraryDto.getUserDtos() != null) {

			for (UserDto userDto : libraryDto.getUserDtos()) {
				Users users = new Users();
				users.setUserId(userDto.getUserId());
				users.setUserName(userDto.getUserName());
				users.setUserAddress(userDto.getUserAddress());
				userList.add(users);
			}
		}
		library.setUsers(userList);
		libraryRepository.save(library);
		return "inserted";
	}

	@Override
	public String registerUsers(UserDto userDto) {
		Users users = new Users();
		users.setUserId(userDto.getUserId());
		users.setUserName(userDto.getUserName());
		users.setUserAddress(userDto.getUserAddress());
		List<Library> libraries = new ArrayList<>();
		if (userDto.getLibraries() != null) {
			for (LibraryDto libraryDto : userDto.getLibraries()) {
				Library library = new Library();
				library.setLibraryId(libraryDto.getLibraryId());
				library.setLibraryName(libraryDto.getLibraryName());
				library.setLibrayAddress(libraryDto.getLibraryAddress());
				libraries.add(library);
			}
		}
		users.setLibrarys(libraries);
		userRepository.save(users);
		return "inserted";
	}

	@Override
	public List<LibraryDto> getAllDataFromDB() {
		List<LibraryDto> result = new ArrayList<>();
		for (Library library : libraryRepository.findAll()) {
			List<UserDto> userDtos = new ArrayList<>();
			for (Users users : library.getUsers()) {
				UserDto userDto = new UserDto(users.getUserId(), users.getUserName(), users.getUserAddress());
				userDtos.add(userDto);
			}
			LibraryDto libraryDto = new LibraryDto(library.getLibraryId(), library.getLibraryName(),
					library.getLibraryName(), userDtos);
			result.add(libraryDto);
		}
		return result;
	}

	@Override
	public List<LibraryDto> getAllUsersOfLibraryHavingUsersMorethanThree() throws ServiceException {
		int count = 0;
		List<LibraryDto> result = new ArrayList<>();
		for (Library library : libraryRepository.findAll()) {
			if (library.getUsers().size() > 3) {
				LibraryDto libraryDto = new LibraryDto(library.getLibraryId(), library.getLibraryName(),
						library.getLibraryName());
				result.add(libraryDto);
				count++;
			}
		}

		if (count == 0) {
			throw new ServiceException(ErrorConstants.NoLibraryFound);
		}

		return result;
	}

	@Override
	public String updateUserAddressForParticularLibrary(int libraryId, int userId, UserDto userDto)
			throws ServiceException {
		int count = 0;
		List<Library> libraries = libraryRepository.findAll();
		for (Library library : libraries) {
			if (libraryId == library.getLibraryId()) {
				count++;
				for (Users user : library.getUsers()) {
					if (userId == user.getUserId()) {
						user.setUserAddress(userDto.getUserAddress());
						userRepository.save(user);
						count++;
					}
				}
			}
		}
		if (count == 0) {
			throw new ServiceException(ErrorConstants.NoLibraryFound);
		}
		if (count == 1) {
			throw new ServiceException(ErrorConstants.NoUserFound);
		}
		return "updated";
	}

	@Override
	public String deleteUserDataByUserId(int libraryId, int userId) {
		Library library = libraryRepository.findById(libraryId).get();
		Users users = userRepository.findById(userId).get();
		for (int i = 0; i < library.getUsers().size(); i++) {
			if (library.getUsers().get(i).getUserId() == users.getUserId()) {
				library.getUsers().set(i, null);
			}
		}
		libraryRepository.saveAndFlush(library);
		userRepository.saveAndFlush(users);
		return "deleted";
	}

	@Override
	public String deleteLibraryDataByLibraryId(int libraryId) {

		libraryRepository.deleteById(libraryId);

		return "deleted";
	}

	@Override
	public String insertUsersForParticularLibrary(int libraryId, UserDto userDto) {
		List<Users> userList = new ArrayList<>();
		for (Library library : libraryRepository.findAll()) {
			if (libraryId == library.getLibraryId()) {
				Users users = new Users();
				users.setUserId(userDto.getUserId());
				users.setUserName(userDto.getUserName());
				users.setUserAddress(userDto.getUserAddress());
				userList.add(users);
			}

			library.setUsers(userList);
			libraryRepository.save(library);
		}

		return "inserted";

	}

	@Override
	public String insertOnlyLibrary(LibraryDto libraryDto) {

		Library library = new Library();
		library.setLibraryId(libraryDto.getLibraryId());
		library.setLibraryName(libraryDto.getLibraryName());
		library.setLibrayAddress(libraryDto.getLibraryAddress());
		libraryRepository.save(library);

		return "inserted";
	}

}
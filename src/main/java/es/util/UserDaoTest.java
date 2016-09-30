package es.util;

import java.util.List;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.util.User.City;

public class UserDaoTest {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException,
			InvocationTargetException, IOException, NoSuchMethodException {

		UserDao userDao = new UserDao();

		
		//Create a new User
		User.City city = new User.City("Jersey City", "12345");
		User.Address address = new User.Address("2 apple court");
		address.setCity(city);
		String id = "" + System.currentTimeMillis();
		User newUser = new User(id, "Mary " + id.substring(1, 10), "coder", address);

		System.out.println("Store user: " + newUser);

		 
		userDao.save(newUser);

		//find by id
		User user = userDao.findUserById(id);
		System.out.println("user: " + user);
		
		//Convert es User to a partial UserView
		ObjectMapper objectMapper = new ObjectMapper();
		//UserView userView = objectMapper.convertValue(user, UserView.class);
		//System.out.println("userView: " + userView);
		
		ExtendableUserView extendableUserView = objectMapper.convertValue(user, ExtendableUserView.class);
		System.out.println("extendableUserView: " + extendableUserView);
		
		//List<UserView> userViews = userDao.findUserViewByName("Mary");
		//System.out.println("Found user name Mary: " + userViews.size());

	 
	}

}

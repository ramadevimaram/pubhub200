package examples.pubhub.dao;

import java.util.List;

import examples.pubhub.model.User;

public interface UserDAO {
	
	public List<User> getListOfUsers();
	public User getUserByUserName(String userName);
	
	public boolean register(User user);
	public boolean isUserExists(User user);
	public boolean authenticateUser(String userName, String password);

}

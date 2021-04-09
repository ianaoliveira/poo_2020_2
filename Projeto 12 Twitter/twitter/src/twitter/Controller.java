package twitter;

import java.util.Map;
import java.util.TreeMap;

public class Controller {
	private Map<String, User> users = new TreeMap<String, User>();
	private Map<Integer, Tweet> tweets = new TreeMap<Integer, Tweet>();
	private int nextTwId = 0;
	
	public void sendTweet (String username, String msg) {
		Tweet tweet = new Tweet(nextTwId, username, msg);
		
		tweets.put(nextTwId, tweet);
		
		User u = getUser(username);
		u.sendTweet(tweet);
		
		nextTwId++;
	}
	
	public void addUser (String username) {
		User u = users.get(username);
		
		if (u == null) {
			User user = new User(username);
		
			users.put(username, user);
		} else {
			throw new RuntimeException("FAIL: Usuário @" + username + " já existe!");
		}
	}
	
	public User getUser (String username) {
		User u = users.get(username);
		
		if (u == null) {
			throw new RuntimeException("FAIL: Usuário não encontrado!");
		}
		
		return u;
	}
	
	public String toString () {
		String ordem = "Lista de usuários: \n\n";

		for (User u : users.values()) {
			ordem += u + "\n";
		}
		
		return ordem;
	}
	
	
}

package twitter;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class User {
	private String username;
	private Map<String, User> followers = new TreeMap<String, User>();
	private Map<String, User> following = new TreeMap<String, User>();
	private ArrayList<Tweet> timeline = new ArrayList<Tweet>();
	
	public int unreadCount = 0;

	public User (String username) {
		setUsername(username);
	}
	
	public void follow (User user) {
		if (!following.containsKey(user.username)) {
			following.put(user.username, user);
			user.followers.put(username, this);
		} else {
			throw new RuntimeException("FAIL: Você já segue @" + user.username + "!");
		}
	}
	
	public void unfollow (String username) {
		if (following.containsKey(username)) {
			User u = following.get(username);

			following.remove(username);
			u.followers.remove(this.username);
		} else {
			throw new RuntimeException("FAIL: Você não segue @" + username + "!");
		}
	}
	
	public Tweet getTweet (int idTw) {
		for (Tweet tweet : timeline) {
			return tweet;
		}
		
		throw new RuntimeException("FAIL: Esse tweet não existe!");
	}
	
	public void sendTweet (Tweet tweet) {
		for (User u : following.values()) {
			u.unreadCount++;
			u.timeline.add(tweet);
		}
		
		timeline.add(tweet);
	}
	
	public String getUnread () {
		String unreaded = "";
		int tlSize = timeline.size();
		int qtd = tlSize - unreadCount;
		
		for (int i = qtd; i < tlSize; i++) {
			unreaded += timeline.get(i) + "\n";
		}
		
		unreadCount = 0;
		
		return unreaded;
	}
	
	public String getTimeline () {
		String tl = "";
		
		for (Tweet tweet : timeline) {
			tl += tweet + "\n";
		}
		
		unreadCount = 0;
		
		return tl;
	}
	
	public void setUsername (String username) {
		this.username = username;
	}
	
	public String getUsername () {
		return this.username;
	}
	
	public String toString () {
		int seguindoSize = following.size();
		int seguidoresSize = followers.size();
		
		String seguindo = seguindoSize + " seguindo:   [ ";
		String seguidores = "\n" + seguidoresSize + " seguidores: [ ";
		
		for (User u : following.values()) {
			seguindo += "@" + u.username + " ";
		}
		
		for (User u : followers.values()) {
			seguidores += "@" + u.username + " ";
		}
		
		return "@" + username + "\n" + seguindo + "]" + seguidores + "]\n";
	}
}

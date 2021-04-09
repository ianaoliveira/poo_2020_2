package twitter;

import java.util.TreeSet;

public class Tweet {
	private int idTw;
	private String username;
	private String msg;
	private TreeSet<String> likes = new TreeSet<String>();

	public Tweet(int id, String username, String msg) {
		this.idTw = id;
		this.username = username;
		this.msg = msg;
	}

	public void like (String username) {
		for (String u : likes) {
			if (u.equals(username)) {
				throw new RuntimeException("FAIL: Você já curtiu essa postagem");
			}
		}
		
		likes.add(username);
	}

	public int getIdTw() {
		return idTw;
	}

	public void setIdTw(int idTw) {
		this.idTw = idTw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String toString () {
		String like = "";
		
		for (String u : likes) {
			like += u + " ";
		}
		
		return getIdTw() + ": @" + getUsername() + " ( " + getMsg() + ") " + " [ " + like + "]";
	}
}

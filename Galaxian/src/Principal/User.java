package Principal;

public class User {
	
	private String username;
	private int score;
	
	public User(String username, int score) {
		this.username = username;
		this.score = score;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getUsername() {
		return username;
	}
	
	public int getScore() {
		return score;
	}
}

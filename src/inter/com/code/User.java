package inter.com.code;

/**
 * Created by Thiago Amanajás on 21/06/16.
 *
 * This class contains all the necessary information
 * about the user.
 */
public class User {
	
	private int user_id;
	private String name;
	private double latitude;
	private double longitude;
	
	public User (int id, String name, double latitude, double longitude) {
		
		this.user_id = id;
		this.name = name;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public String toString() {
		
		return  "ID: " + this.user_id + ", Name: " + this.name;
	}

}

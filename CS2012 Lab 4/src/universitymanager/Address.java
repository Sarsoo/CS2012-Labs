package universitymanager;

public class Address {
	private int streetNumber;
	private String streetName;
	private String cityName;
	private String stateName;
	private String countryName;
	
	
	public Address(int streetNumber, String streetName, String cityName, String stateName, String countryName) {
		this.streetNumber = streetNumber;
		this.streetName = streetName;
		this.cityName = cityName;
		this.stateName = stateName;
		this.countryName = countryName;
	}
	
	public String toString() {
		return streetNumber + " " + streetName + "\n" + cityName + "\n" + stateName + "\n" + countryName;
	}
	
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}
	public String getStreetName() {
		return streetName;
	}
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}

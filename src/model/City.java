package model;

public class City {
	
	private String title;
	private float areaKm2;
	private String postCode;
	private Country country;
	
	//TODO uztaisīt pāŗbaudes set funkcijās
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getAreaKm2() {
		return areaKm2;
	}
	public void setAreaKm2(float areaKm2) {
		this.areaKm2 = areaKm2;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	public City() {}
	public City(String title, float areaKm2, String postCode, Country country) {
		setTitle(title);
		setAreaKm2(areaKm2);
		setPostCode(postCode);
		setCountry(country);
	}
	public String toString() {
		return title + " (" + country+ "), " + areaKm2 + " km^2 "+
				"[" + postCode + "]";
	}

}

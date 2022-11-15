package br.com.gbguii.athlete;

public class AthleteObj {
	private String name;
	private String country;
	private Double throwDistance;
	
	public AthleteObj() {
		
	}
	
	public AthleteObj(String name, String countryString, Double throwDistance) {
		this.name = name;
		this.country = countryString;
		this.throwDistance = throwDistance;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public Double getThrowDistance() {
		return throwDistance;
	}
	
	public void setThrowDistance(Double throwDistance) {
		this.throwDistance = throwDistance;
	}
	
	public String toString() {
		return this.name + " - " +
				"País: "+ this.country+ " - " + 
				"Arremesou: "+ this.throwDistance;
	}
	
}

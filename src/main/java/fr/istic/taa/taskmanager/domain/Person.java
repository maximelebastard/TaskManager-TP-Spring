package fr.istic.taa.taskmanager.domain;

public class Person extends BaseEntity {

	
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	String firstName;
}

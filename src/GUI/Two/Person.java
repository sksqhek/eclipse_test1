package GUI.Two;

import java.io.Serializable;

public abstract class Person implements Serializable {

	private static final long serialVersionUID = 2L;
	
	private String name;
	private String address;
	
	public Person() {
		super();
	}

	public Person(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public abstract void setID(String id);
	public abstract String getID();	
	
	
	public String getInfo() {
		String info="\nName : "+name+"\nAddress :"+address;
		return info;
	}
	
	public void printAll() {
		System.out.println(this.getInfo());
	}
	
	public String toString() {
		return name;
	}
	
	
	
	

}

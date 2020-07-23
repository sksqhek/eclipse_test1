package GUI.Two;

public class Student extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String className;
	
	public Student() {}

	public Student(String className) {
		super();
		this.className = className;
	}

	@Override
	public void setID(String id) {
		this.ID=id;
	}

	@Override
	public String getID() {
		return null;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}	

	@Override
	public String getInfo() {
		 String info = super.getInfo()+"\nGrade : "+ID+"\nClass : "+className;
		 
		 return info;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}
	
	

}

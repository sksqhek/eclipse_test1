package GUI.Two;

public class Teacher extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String subject;

	public Teacher() {
		super();
	}

	@Override
	public void setID(String id) {
		this.ID=id;
	}

	@Override
	public String getID() {
		return null;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String getInfo() {
		String info = super.getInfo()+"\n[T]Grade : "+ID+"\nSubject : "+subject;
		
		return info;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}
	
	

}

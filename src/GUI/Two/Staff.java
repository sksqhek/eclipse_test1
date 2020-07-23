package GUI.Two;

public class Staff extends Person{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;
	private String ID;
	private String dept;

	public Staff() {
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
	
	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String getInfo() {
		String info = super.getInfo()+"\n[STF]Grade : "+ID+"\nDept : "+dept;
		
		return info;
	}

	@Override
	public void printAll() {
		System.out.println(this.getInfo());
	}
}

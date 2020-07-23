package GUI.Two;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main
{

	public static void main(String[] args)
	{
		ArrayList<Person> people = new ArrayList<>();
		
		try
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.txt", true));
						
			Staff s = new Staff();
			s.setAddress("����");
			s.setName("ȫ�浿");
			s.setID("20201234");
			s.setDept("ü����");
			people.add(s);
			
			Student stu = new Student();
			stu.setAddress("����");
			stu.setName("�Ѹ�");
			stu.setID("20205782");
			stu.setClassName("���� ���к�");
			people.add(stu);			
			
			Teacher t = new Teacher();
			t.setAddress("����");
			t.setName("�����");
			t.setID("20208989");
			t.setSubject("õ��");
			people.add(t);
			
			oos.writeObject(people);
			
			oos.close();
		}
		catch(Exception ex)
		{
			
		}
		
		
		ArrayList<Person> read_peaple = new ArrayList<>();//���Ͽ��� �ٽ� �б� ����
		try
		{	
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.txt"));
			
			read_peaple = (ArrayList<Person>)ois.readObject();
			
			ois.close();
			
			for(Person p:read_peaple)
			{
				p.printAll();
			}
			
		}
		catch(Exception ex)
		{
			
		}
	}

}

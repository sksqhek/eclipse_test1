import java.util.*;

class regrigerator {
	String name;
	Cooker c = new Cooker();

	public void setname(int str) {
		switch (str) {
		case 1:
			name = "���";
			c.cooking_method(name);
		case 2:
			name = "�������";
			c.cooking_method(name);
		case 3:
			name = "�Ұ��";
			c.cooking_method(name);
		case 4:
			name = "�丶��";
			c.cooking_method(name);
		}
	}
}

interface Method
{
	
}

class Cooker implements Method {

	Scanner sc = new Scanner(System.in);

	public void cooking_method(String name) {

		switch (name) {
		case "���":
			cooking_method2();
			break;
		case "�������":
			cooking_method2();
			break;
		case "�Ұ��":
			cooking_method2();
			break;
		case "�丶��":
			cooking_method2();
			break;
		}
	}

	public void cooking_method2() {

		System.out.println("�丮�� ����");
		System.out.println("1.����  2.��  3.Ƣ�� 4.����");
		int select = sc.nextInt();
		switch (select) {
		case 1:
			uncook();
			break;
		case 2:
			steamed();
			break;
		case 3:
			fry();
			break;
		case 4:
			grill();
			break;
		}
	}

	public void uncook() {
		System.out.println("�� ������ ����");
	}; // ����

	public void steamed() {
		System.out.println(" ������ ����");
	}; // ��

	public void fry() {
		System.out.println(" Ƣ������ ����");
	};// Ƣ��

	public void grill() {
		System.out.println(" ����� ����");
	};

}

public class grillcooker extends Cooker {

	@Override
	public void grill() {
		System.out.println("1.raw 2.medium 3.well-done ���ڸ� �����ϼ���");
		int ch = sc.nextInt();
		switch (ch) {
		case 1:
			System.out.println("��");
		case 2:
			System.out.println("�߰�");
		case 3:
			System.out.println("����");
		}
	}

	public static void main(String[] args) {
		regrigerator r = new regrigerator();
		Scanner sc = new Scanner(System.in);
		System.out.println("������ ��Ḧ �������ּ���");
		System.out.println("1.��� 2.�������  3.�Ұ��, 4��.�丶�� (���ڸ� �����Ͻÿ�)");
		int select;
		select = sc.nextInt();
		r.setname(select);
	}

}
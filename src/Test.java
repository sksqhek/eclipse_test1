import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Test
{

	static public void main(String args[])
	{
		try {
			BufferedReader fr = new BufferedReader(new FileReader("test.txt"));

			Date date = new Date();

			// �������� ���� �ð��� ǥ�����ְ�
			System.out.println("���� �ð�:" + date);
			String s = fr.readLine();//���Ͽ��� ���� �б�
			System.out.println("���� ����:" + s);

			fr.close();
		} catch (IOException e) {
			// �������� �ʴ� ������ ������ ���������ʴ´ٴ� ����ǥ��
			System.out.println("���� ����");
		}

	}
}

import java.io.*;

import java.util.Scanner;

import java.io.IOException;

public class File02
{

	public static void main(String[] args) throws IOException
	{
// TODO Auto-generated method stub
		File f = new File("menulist.txt");
		Scanner in = new Scanner(new File("menulist.txt"));
		if (f.exists() == false) {
//���� �ۼ�
			try ( // ��ü�� �����ϸ� try���� �� �ڵ����� closeó��
					FileWriter fw = new FileWriter("menulist.txt", true);
					BufferedWriter bw = new BufferedWriter(fw);) {
				bw.write("4");
				bw.newLine();
				bw.write("1 �Ƹ޸�ī�� 1500"); // ���ۿ� ������ �Է�
				bw.newLine(); // ���ۿ� ���� ����
				bw.write("2 ī��� 2000");
				bw.newLine();
				bw.write("3 �ݶ� 1500");
				bw.newLine();
				bw.write("4 ���� 1000");
				bw.newLine();
				bw.flush(); // ������ ������ ���Ͽ� ����
			} catch (IOException e) {
				System.out.println(e);
			}
		} else			
		{
			// File f = new File("menulist.txt");
			// ���� ���� ���� �Ǵ�
			// if (f.isFile()) {
			// System.out.println("menulist.txt ������ �ֽ��ϴ�.");
			// }

			// ���� �о� �迭ȭ
			int numItems = in.nextInt();

			int money;

			int change = 0;

			int min_price;

			int[] menu_num = new int[numItems];
			String[] menu_title = new String[numItems];
			int[] menu_price = new int[numItems];
			int i;

			for (i = 0; i < numItems; i++) {
				menu_num[i] = in.nextInt();
				menu_title[i] = in.next();
				menu_price[i] = in.nextInt();

			}

			min_price = menu_price[0];

			for (i = 0; i < menu_price.length; i++)

			{

				if (min_price > menu_price[i])

				{

					min_price = menu_price[i];

				}

			}

			System.out.println("�������.");

			System.out.println("���Ǳ� �Դϴ�.");

			do
			{

				System.out.printf("���� �Է��ϼ���: ");

				money = in.nextInt();

				change = change + money;

			} while (change < min_price);
			do

			{

				System.out.println("========================");

				System.out.println("          ��   �� ");

				System.out.println("========================");

				for (i = 0; i < numItems; i++) {
					System.out.printf("%d %s %d\n", menu_num[i], menu_title[i], menu_price[i]);

				}

				System.out.println("========================");

				System.out.printf("�Է��� ���� %d�� �Դϴ�.\n", change);

				System.out.println("========================");

				System.out.printf("�޴��� ������: ");

				switch (i)

				{

				case 1:

					System.out.printf("%d�� �Ƹ޸�ī�븦 ���̽��ϴ�.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 2:

					System.out.printf("%d�� ī��󶼸� ���̽��ϴ�.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 3:

					System.out.printf("%d�� �ݶ� ���̽��ϴ�.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				case 4:

					System.out.printf("%d�� ������ ���̽��ϴ�.\n", menu_num[i]);

					change = change - menu_price[i];

					break;

				default:

					System.out.printf("�޴� ��ȣ�� �� �� �����̽��ϴ�.\n");

					break;

				}

				System.out.printf("�ܵ��� %d�� �Դϴ�.\n", change);

				System.out.printf("�� ���ðڽ��ϱ�? [y/n]  ");

				int c;

				c = in.next().charAt(0);
				if (c == 'y' || c == 'Y')

				{

					System.out.printf("�޴��� �������ּ���\n");

				}

				else if (c == 'n' || c == 'N')

				{

					System.out.printf("���Ǳ⸦ �����մϴ�\n");

					break;

				}
			} while (change >= min_price);

			in.close();
		}
	}
}
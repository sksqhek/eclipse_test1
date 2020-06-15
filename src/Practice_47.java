import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Practice_47 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<BankAccount> account = new ArrayList<BankAccount>();
		// BankAccount account[] = new BankAccount[3];

		int i;
		String name;
		int money;
		int accountNum;
		int action;
		String fname;
		int idx;

		while (true) {

			System.out.print("���Ͻô� �۾��� �����ϼ���(0-����/1-����/2-����/3-���¾���):");
			action = scan.nextInt();

			switch (action) {
			case 1:
				System.out.print("���� �̸��� �Է��ϼ���:");
				fname = scan.next();
				load(fname, account);
				break;
			case 2:
				System.out.print("���� �̸��� �Է��ϼ���:");
				fname = scan.next();
				save(fname, account);
				break;
			case 3:
				while (true) {
					System.out.print("���ϴ� �۾��� �����ϼ��� (0-���� �޴�/1-�Ա� /2-���/3-���»���/4-��ü�������) : ");
					action = scan.nextInt();
					if (action == 0)
						break;

					switch (action) {
					case 1:
						idx = getAccountIndex(account);

						System.out.print("�Աݾ��� �Է��ϼ��� : ");
						money = scan.nextInt();
						System.out.println("�Ա��� �Ϸ�Ǿ����ϴ�.");
						account.get(idx).deposit(money);
						break;
					case 2:
						idx = getAccountIndex(account);

						System.out.print("��ݾ��� �Է��ϼ��� : ");
						money = scan.nextInt();
						System.out.println("����� �Ϸ�Ǿ����ϴ�.");
						account.get(idx).withdraw(money);
						break;
					case 3:
						System.out.print("���˹�ȣ�� �Է��ϼ��� : ");
						accountNum = scan.nextInt();
						System.out.print("������ �̸��� �Է��ϼ��� : ");
						name = scan.next();
						System.out.print("�ܰ� �Է��ϼ��� : ");
						money = scan.nextInt();

						BankAccount acc = new BankAccount(name, money, accountNum);
						account.add(acc);
						break;
					case 4:
						printAccount(account);
						break;
					}
				}
				break;
			case 0:
				scan.close();
				System.out.print("���α׷��� �����մϴ�.");
				return;
			}

		}
	}

	public static void printAccount(ArrayList<BankAccount> list) {
		System.out.println("���� �ܰ� ��Ȳ�Դϴ�.");
		System.out.println("���¹�ȣ\t ������\t �ܰ�");
		for (int i = 0; i < list.size(); i++)
			System.out.println(list.get(i));
	}

	public static int getAccountIndex(ArrayList<BankAccount> list) {
		int accountNum;
		int i;
		Scanner scan = new Scanner(System.in);

		System.out.print("������Ʈ�� ���¹�ȣ�� �Է��ϼ��� : ");
		accountNum = scan.nextInt();

		for (i = 0; i < list.size(); i++) {
			if (list.get(i).getAccountNum() == accountNum)
				break;
		}

		if (i == list.size())
			return -1;// ���� ��ȣ ��ã���� ���

		return i;
	}

	public static void save(String fname, ArrayList<BankAccount> list) {
		try {
			PrintWriter pw = new PrintWriter(new File(fname));

			for (int i = 0; i < list.size(); i++) {
				pw.print(list.get(i).getAccountNum() +  "\t" + list.get(i).getOwner() +  "\t" + 
						list.get(i).balance() +  "\n");
			}

			pw.close();
		} catch (Exception ex) {

		}
	}

	public static void load(String fname, ArrayList<BankAccount> list) {
		String name;
		int money;
		int accountNum;
		
		list.clear();
		
		try {
			Scanner scan = new Scanner(new File(fname));

			while (scan.hasNext()) {
				accountNum = scan.nextInt();
				name = scan.next();
				money = scan.nextInt();
				
				BankAccount b = new BankAccount(name, money, accountNum);
				list.add(b);
			}

			scan.close();
			
			printAccount(list);
		} catch (Exception ex) {

		}
	}
}

class BankAccount {
	private String owner;
	private int accountNum;
	private int balance;

	public void setOwner(String o) {
		owner = o;
	}

	public void setBalance(int b) {
		balance = b;
	}

	public String getOwner() {
		return owner;
	}

	public int balance() {
		return balance;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

	public String toString() {
		return accountNum + "\t" + owner +"\t" + balance;
	}

	public BankAccount() {
		this("��", 0, 0);
	}

	public BankAccount(String owner, int balance, int accountNum) {
		this.owner = owner;
		this.balance = balance;
		this.accountNum = accountNum;
	}

	void deposit(int amount) {
		balance += amount;
	}

	void withdraw(int amount) {
		balance -= amount;
	}
}
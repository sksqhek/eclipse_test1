package net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.*;

public class EchoClientTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		EchoClient echo = new EchoClient();
		echo.start(); // �����κ��� ������ �б����� ������ ����
		try {
			while (true) {
				System.out.println("������ ���� �޽����� �Է��ϼ���.(����:exit)");
				String msg = s.next(); // ����ڷκ��� ���� �޽����� �Է¹���
				echo.sendMsg(msg); // �޽��� ����
				if (msg.equals("exit")) { // ����
					System.out.println("������ �����մϴ�.");
					echo.closeAll(); // ���� ����
					if (echo != null)
						echo = null; // ������ ����
					break;
				}
			}
		} catch (Exception e) {
		}
	}
}

class EchoClient extends Thread {
	Socket mySocket = null;
	DataInputStream dis = null;
	DataOutputStream dos = null;

	/**
	 * Ŭ���̾�Ʈ ó�� ������ ������
	 * 
	 * @param socket
	 */
	public EchoClient() {
		try {
			mySocket = new Socket("127.0.0.1", 10000); // ������ ����
			System.out.println("������ �����߽��ϴ�.");
			dis = new DataInputStream(mySocket.getInputStream());
			dos = new DataOutputStream(mySocket.getOutputStream());
		} catch (Exception e) {
			System.out.println("������ ������ �� �����ϴ�.");
			System.exit(0);
		}
	}

	/**
	 * ������ ������ �޽����� �����ϴ� ����� �����Ѵ�.
	 */
	public void run() {
		byte[] readdata = null;
		try {
			while (true) {
				int length = dis.read();
				readdata = new byte[length];
				int readlen = dis.read(readdata);
				System.out.println(new String(readdata));
			}
		} catch (Exception e) {
		}
	}

	/**
	 * �������� �޽����� ������.
	 * 
	 * @param str
	 */
	public void sendMsg(String msg) {
		try {
			dos.write((byte) msg.getBytes().length);
			dos.write(msg.getBytes());
			dos.flush();
		} catch (Exception e) {
		}
	}

	public void closeAll() {
		try {
			mySocket = null;
			dis = null;
			dos = null;
		} catch (Exception e) {
		}
	}
}

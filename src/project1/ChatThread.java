package project1;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatThread extends Thread {
	ChatServer myServer; // ChatServer ��ü
	Socket mySocket; // Ŭ���̾�Ʈ ����
	PrintWriter out; // ����� ��Ʈ��
	BufferedReader in;

	public ChatThread(ChatServer server, Socket socket) // ������
	{
		super("ChatThread");
		myServer = server;
		mySocket = socket;
		out = null;
		in = null;
	}

	public void sendMessage(String msg) throws IOException // �޽����� ����
	{
		out.println(msg);
		out.flush();
	}

	public void disconnect() // ������ ����
	{
		try {
			out.flush();
			in.close();
			out.close();
			mySocket.close();
			myServer.removeClient(this);
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}

	public void run() // ������ ����
	{
		try {
			// ������ �̿��Ͽ� ����� ����� ��Ʈ���� ����
			out = new PrintWriter(new OutputStreamWriter(mySocket.getOutputStream()));
			in = new BufferedReader(new InputStreamReader(mySocket.getInputStream()));
			while (true) { // Ŭ���̾�Ʈ ���� �޽����� ó���ϱ� ���� ��ٸ�

				String inLine = in.readLine(); // ��ٸ��� �ִٰ� Ŭ���̾�Ʈ�� ���� �޽����� �ִ� ��� �о����
				if (!inLine.equals("") && !inLine.equals(null)) {
					messageProcess(inLine); // Ŭ���̾�Ʈ�� ���� �޽����� Ȯ���Ͽ� ���� ������ ��� Ŭ���̾�Ʈ���� ��ε�ĳ��Ʈ
				}
			}
		} catch (Exception e) {
			disconnect();
		}
	}

// Ŭ���̾�Ʈ�� ���� �޽����� Ȯ���� �� ó�� 
	public void messageProcess(String msg) {
		System.out.println(msg); // ȭ�鿡 ���
		StringTokenizer st = new StringTokenizer(msg, "|"); // ��Ģ�� ���� ���� �޽����� �и��Ͽ� Ȯ��
		String command = st.nextToken(); // �޽����� ��� command �κ�
		String talk = st.nextToken(); // �޽����� ��ȭ talk �κ�
		if (command.equals("LOGIN")) { // ���� �޽����� LOGIN �̸� ó�� ���� �޽����̱� ������ ���� ó��
			System.out.println("[����] " + mySocket);
			try { // ���ο� Ŭ���̾�Ʈ�� �����Ͽ� �߰��� Ŭ���̾�Ʈ ���� ��ε�ĳ��Ʈ
				myServer.broadcast("[���� �����ڼ�] " + myServer.clientNum + "��");
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		} else if (command.equals("LOGOUT")) { // ���� �޽����� LOGOUT �̸� ���� �޽����̹Ƿ� ���ŵ� Ŭ���̾�Ʈ�� ����
			try { // ��ε�ĳ��Ʈ
				myServer.clientNum--;
				myServer.broadcast("[���� ����] " + talk);
				myServer.broadcast("[���� �����ڼ�] " + myServer.clientNum + "��");
			} catch (IOException e) {
				System.out.println(e.toString());
			}
			disconnect(); // ���� ����
		} else {
			try { // LOGIN, LOGOUT �̿��� ���� �Ϲ� �޽����� ��� Ŭ���̾�Ʈ���� ���� �޽��� ����
				myServer.broadcast(talk);
			} catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}
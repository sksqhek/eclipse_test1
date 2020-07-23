package project1;

import java.net.*;
import java.io.*;
import java.util.*;

public class ChatServer {
	Vector clientVector = new Vector(); // ���� ����� Ŭ���̾�Ʈ ������ �����ϰ� �ִ� ������
	int clientNum = 0; // ���ӵ� Ŭ���̾�Ʈ�� ��
	// ���ӵ� ��� Ŭ���̾�Ʈ���� �޽��� msg �� ����

	public void broadcast(String msg) throws IOException {
		synchronized (clientVector) {
			for (int i = 0; i < clientVector.size(); i++) {
				ChatThread client = (ChatThread) clientVector.elementAt(i);
				synchronized (client) {
					client.sendMessage(msg);
				}
			}
		}
	}

// ����� clientVector�� ����Ǿ� �ִ� Ŭ���̾�Ʈ ������ ���� 
	public void removeClient(ChatThread client) {
		synchronized (clientVector) {
			clientVector.removeElement(client);
			client = null;
			System.gc();
		}
	}

// ó�� ����Ǿ��� �� clientVector�� �ش� Ŭ���̾�Ʈ�� ������ �߰� 
	public void addClient(ChatThread client) {
		synchronized (clientVector) {
			clientVector.addElement(client);
		}
	}

// ������ ���� ���� �޼ҵ� 
	public static void main(String[] args) {
		// ���� ����
		ServerSocket myServerSocket = null;
		// ChatServer ��ü ����
		ChatServer myServer = new ChatServer();
		try {
			// ���� ��Ʈ 10129�� ������ ���� ���� ����
			myServerSocket = new ServerSocket(10129);
		} catch (IOException e) {
			System.out.println(e.toString());
			System.exit(-1);
		}

		System.out.println("[���� ��� ����] " + myServerSocket);
		try {
			// �ټ��� Ŭ���̾�Ʈ ������ ó���ϱ� ���� �ݺ������� ����
			while (true) {
				// Ŭ���̾�Ʈ�� ���ӵǾ��� ��� �� Ŭ���̾�Ʈ�� ó���ϱ� ���� ChatThread ��ü ����
				ChatThread client = new ChatThread(myServer, myServerSocket.accept());

				// Ŭ���̾�Ʈ���� ���񽺸� �����ϱ� ���� ������ ����
				client.start();
				// clientVector �� Ŭ���̾�Ʈ ��ü �߰�
				myServer.addClient(client);
				// ������ Ŭ���̾�Ʈ�� �� ����
				myServer.clientNum++;
				System.out.println("[���� �����ڼ�] " + myServer.clientNum + "��");
			}
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
package chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.Arrays;

import javax.swing.*;

public class TCPChatClient extends JFrame
{
	JTextField jtf;
	JTextArea jta;
	BufferedImage img;
	InputStream is;
	OutputStream os;
	FileOutputStream fos;
	Socket sk;
	JFileChooser jfc;
	String ip;
	boolean isNew;
	File file;

	public TCPChatClient(String ip)
	{
		this.ip = ip;
		jtf = new JTextField(50);
		jta = new JTextArea();
		jfc = new JFileChooser();
		JScrollPane jsp = new JScrollPane(jta);//
		jta.setEditable(false);// JTextArea�� ���� �Է� �Ұ���(�����Ұ���)�ϰ� ����
		JButton btn = new JButton("����");
		JButton btn_close = new JButton("����");
		JButton btn_file = new JButton("����");
		JPanel p = new JPanel();
		DataOutputStream dos;
		DataInputStream dis;
		p.add(jtf);
		p.add(btn);
		p.add(btn_close);
		p.add(btn_file);
		add(jsp, BorderLayout.CENTER);
		add(p, BorderLayout.SOUTH);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		try {
			sk = new Socket(ip, 9123);
			jta.append(ip + "���� ����ƽ��ϴ�" + "\n");
			is = sk.getInputStream();
			os = sk.getOutputStream();
		} catch (Exception e) {
			System.out.println("���ܹ߻�  : " + e.getMessage());
		}
		btn_close.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				// TODO Auto-generated method stub
				try {
					jta.append(ip + "���� �����Ͽ����ϴ�" + "\n");
					System.exit(0);
					sk.close();
				} catch (Exception e1) {
					System.out.println("���ܹ߻� : " + e1.getMessage());
				}
			}
		});
		
		btn_file.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				openFile();
				send(); // ���� ���۹��??
			}
		});
		jtf.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String msg = jtf.getText();
				send();
				jtf.setText("");
			}
		});
		btn.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String msg = jtf.getText();
				send();
				jtf.setText("");
			}
		});
		class ClientThread extends Thread
		{
			public void run()
			{
				byte[] data = new byte[100];
				while (true) {
					try {
						is.read(data);
						String msg = new String(data);
						jta.append(msg + "\n");
						jsp.getVerticalScrollBar().setValue(jsp.getVerticalScrollBar().getMaximum());
						// �ڹ��� ��ũ���� ������ �ڵ�����
						Arrays.fill(data, (byte) 0);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}// �̳� Ŭ������ ��
		ClientThread ct = new ClientThread();
		ct.start();
	}// �������� ��

	public void exit()
	{
		System.exit(0);
	}// ���� ��ư�� "����"���

	protected void send()
	{
		String msg = jtf.getText();
		byte[] data = msg.getBytes();
		try {
			os.write(data);
		} catch (Exception e) {
			System.out.println("���ܹ߻�  :" + e.getMessage());
		}
	}

	protected void openFile()
	{
		jfc.showOpenDialog(this);
		file = jfc.getSelectedFile();
	}

	public static void main(String[] args)
	{
		//new TCPChatClient(args[0]);
		new TCPChatClient("127.0.0.1");
	}
}
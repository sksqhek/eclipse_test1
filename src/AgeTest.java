import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class AgeTest extends JFrame
{
	private JButton button1, button2, button3;
	private JLabel label;
	int count = 100;
	int counta = 0;
	String a;
	MyPanel mypanel;

	public AgeTest()
	{
		this.setSize(480, 200);
		this.setTitle("�Ƿε� �׽�Ʈ");
		JPanel panel = new JPanel();
		JPanel panel1 = new JPanel();
		
		label = new JLabel(a);
		
		button1 = new JButton("����");
		button2 = new JButton("��");
		button3 = new JButton("�ƴϿ�");
		add(panel);
		panel.add(button1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mypanel = new MyPanel();// ####��ü ����

		button1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				button1.setVisible(false);
				add(mypanel, BorderLayout.CENTER);// ####������ ��ü ȭ�鿡 �߰�
				panel1.add(label);
				panel1.add(button2);
				panel1.add(button3);
				add(panel1, BorderLayout.SOUTH);
			}
		});

		button2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				count = count - 20;
				mypanel.repaint();				
				
				setLabel();
				
				counta = counta + 1;
			}
		});
		button3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				counta = counta + 1;
				
				setLabel();
				
				counta = counta + 1;
			}
		});
	}
	
	void setLabel()
	{
		if (counta==0) {
			a="������ ������ �ʹٴ� ������ �����Ͻʴϱ�";
			}
			else if(counta==1){
			a="����� ���� �Ŀ��� �����ϱ�";
			}
			else if(counta==2) {
			a="���ΰ��迡 ������� �����ϱ�";
			}
			else if(counta==3) {
			a="���� �Ҹ����� ���� ���� �ֽ��ϱ�";
			}
			else if(counta==4) {
			a="�ð����� ��� �Ͻʴϱ�";
			}
		label.setText(a);

	}

	class MyPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.GREEN);
			g.drawLine(80, 30, 90, 100);// ����(����)
			g.drawLine(200, 30, 190, 100);// ����(������)
			g.drawLine(90, 100, 190, 100);// ����(�Ʒ�)
			g.drawLine(80, 30, 200, 30);// ����(��)
			if (count == 80) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
			} else if (count == 60) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
			} else if (count == 40) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
			} else if (count == 20) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
				g.setColor(Color.black);
				g.fillOval(90, 70, 25, 25);
			} else if (count == 0) {
				g.setColor(Color.black);
				g.fillOval(90, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 30, 25, 25);
				g.setColor(Color.black);
				g.fillOval(120, 55, 25, 25);
				g.setColor(Color.black);
				g.fillOval(90, 70, 25, 25);
				g.setColor(Color.black);
				g.fillOval(150, 70, 25, 25);
			}
		}

	}

	public static void main(String[] args)
	{
// TODO Auto-generated method stub

		AgeTest f = new AgeTest();
	}

}
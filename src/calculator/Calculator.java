package calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener {
	private JPanel panel1;
	private JPanel panel2;
	private JTextField tfield;
	private JButton[] button1;
	private JButton[] button2;
	private String[] labels1 = { "Backspae", "CE", "C" };
	private String[] labels2 = { "7", "8", "9", "/", "squrt", "4", "5", "6", "*", "%", "1", "2", "3", "-", "1/x", "0",
			"+/-", ".", "+", "=" };

	int value;
	String prev_oper="";
	boolean isnumstart = true;
	
	public Calculator() {
		setTitle("MyCalculator");
		tfield = new JTextField(35);
		tfield.setText("");
		// tfield.setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel1.setLayout(new GridLayout(1, 3, 7, 7));
		panel2.setLayout(new GridLayout(4, 5, 7, 7));
		button1 = new JButton[3];
		int index = 0;
		for (int rows = 0; rows < 1; rows++) {
			for (int cols = 0; cols < 3; cols++) {
				button1[index] = new JButton(labels1[index]);
				button1[index].setForeground(Color.RED);
				button1[index].addActionListener(this);
				panel1.add(button1[index]);
				index++;
			}
		}
		button2 = new JButton[20];
		int index2 = 0;
		for (int rows = 0; rows < 4; rows++) {
			for (int cols = 0; cols < 5; cols++) {
				button2[index2] = new JButton(labels2[index2]);
				button2[index2].addActionListener(this);
				if (index2 == 3 || index2 == 8 || index2 == 13 || index2 == 18) {
					button2[index2].setForeground(Color.RED);
				}
				panel2.add(button2[index2]);
				index2++;
			}
		}
		add(tfield, BorderLayout.NORTH);
		add(panel1, BorderLayout.CENTER);
		add(panel2, BorderLayout.SOUTH);
		setVisible(true);
		pack();
	}
	
	public void calc()
	{
		if(prev_oper.equals(""))//ó�� ���� �Է��̸�
			value = Integer.parseInt(tfield.getText());
		else if(prev_oper.equals("+"))
		{
			value += Integer.parseInt(tfield.getText());
		}
		else if(prev_oper.equals("-"))
		{
			value -= Integer.parseInt(tfield.getText());
		}
		else if(prev_oper.equals("*"))
		{
			value *= Integer.parseInt(tfield.getText());
		}
		else if(prev_oper.equals("/"))
		{
			value /= Integer.parseInt(tfield.getText());
		}
		
		isnumstart = true;//������ �Է��� ù���� ���ڸ� ������ �ؽ�Ʈ �ʵ� ���� ����� ����		
		
		tfield.setText(""+value);//������ �ؽ�Ʈ �ʵ忡 ��� 
	}

	@Override
	public void actionPerformed(ActionEvent e) {		
		
		if(e.getActionCommand().equals("Backspae"))
		{
			if(tfield.getText().length() > 0)
				tfield.setText(tfield.getText().substring(0, tfield.getText().length()-1));//�ǵ� ���� �Ѱ� ������ ����
			return;
		}else if(e.getActionCommand().equals("CE"))
		{
			tfield.setText("");//��� �����
			return;
		}else if(e.getActionCommand().equals("C"))
		{
			value = 0;
			prev_oper = "";
			tfield.setText("");//��� �����
			return;
		}else if(e.getActionCommand().equals("+"))
		{		
			calc();
			prev_oper = "+";//���� ������ ����(�������� ������ ���)
			return;
		}else if(e.getActionCommand().equals("-"))
		{
			calc();
			prev_oper = "-";
			return;
		}else if(e.getActionCommand().equals("*"))
		{
			calc();
			prev_oper = "*";
			return;
		}else if(e.getActionCommand().equals("/"))
		{
			calc();
			prev_oper = "/";
			return;
		}else if(e.getActionCommand().equals("="))
		{
			calc();
			prev_oper = "";
			return;
		}
		
		if(isnumstart)//������ ���� ù ���� �Է��̸�
		{
			tfield.setText("");
			isnumstart = false;
		}
		
		for(int i=0;i < button2.length;i++)
		{
			if(e.getSource() == button2[i])//���� ��ȣ�� ã����
			{
				tfield.setText(tfield.getText() + button2[i].getText());//���� ���ڿ��� �߰�
				return;
			}
		}
	}

	public static void main(String[] args) {
		Calculator c = new Calculator();
	}
}
package com.jcohy.study.gui;

import javax.swing.*;
import java.awt.*;

public class QQLogin extends JFrame
{

	JLabel bq1;
	JPanel mb1;  JButton an1,an2,an3;
	JTabbedPane xxk;
	JPanel mb2,mb3,mb4;
	JLabel bq2,bq3,bq4,bq5;
	JTextField wbk;
	JPasswordField mmk;
	JLabel bq6;
	JCheckBox fxk1,fxk2;
	public static void main(String[] args)
	{
		QQLogin a=new QQLogin();
	} 
	public QQLogin()
	{
		bq1=new JLabel("��ӭ����",JLabel.CENTER);//����

		bq2=new JLabel("QQ����",JLabel.CENTER);//�в�
		wbk=new JTextField();
		bq3=new JLabel("�������",JLabel.CENTER);
		bq4=new JLabel("QQ����",JLabel.CENTER);
		bq5=new JLabel("��������",JLabel.CENTER);
		mmk=new JPasswordField();
		bq6=new JLabel("<html><a href='www.qq.com'>�������뱣��</a>");
		bq6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		fxk1=new JCheckBox("�����¼");
		fxk2=new JCheckBox("��ס����");

		mb1=new JPanel();      //�ϲ�
		an1=new JButton("��¼");
		an2=new JButton("���");
		an3=new JButton("�ر�");

		xxk=new JTabbedPane();
		mb2=new JPanel();
		mb3=new JPanel();
		mb3.setBackground(Color.gray);
		mb4=new JPanel();
		
		ImageIcon tp1=new ImageIcon("com.gui.images\\163logo.gif");
		
		
		mb4.setBackground(Color.GREEN);

		xxk.add("��ͨ�û�",mb2);  	xxk.add("��Ա��¼",mb3); 		xxk.add("����Ա",mb4);
		mb2.setLayout(new GridLayout(3,3));
		mb1.add(an1);				mb1.add(an2);				mb1.add(an3);
		mb2.add(bq2);				mb2.add(wbk);				mb2.add(bq3);
		mb2.add(bq4);				mb2.add(mmk);				mb2.add(bq5);
		mb2.add(fxk1);				mb2.add(fxk2);				mb2.add(bq6);



		this.add(mb1,BorderLayout.SOUTH);
		this.add(bq1,BorderLayout.NORTH);
		this.add(xxk,BorderLayout.CENTER);

		//ImageIcon tp1=new ImageIcon("images\\163logo.gif");
		this.setIconImage(tp1.getImage());
		this.setTitle("�û���¼");
		this.setSize(340,270);
		this.setLocation(300,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
	}
}

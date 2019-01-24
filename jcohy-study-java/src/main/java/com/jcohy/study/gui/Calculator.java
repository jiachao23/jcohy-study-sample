package com.jcohy.study.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calculator extends JFrame{

	//�������
	private String remindOp;//�������
	private boolean start;//�ж��Ƿ������ֵĿ�ʼ
	private Container container; 
	private GridBagLayout layout; //���岼�ַ�ʽΪ���������
	private GridBagConstraints constraints; 
	private JTextField wbk;//��ʾ�ĵط�
	private double result;
	Calculator(){
		//�����������ʼ��
		start=true;
		remindOp="=";
		result=0;
		container=getContentPane();
		layout =new GridBagLayout();
		container.setLayout(layout); 
		constraints=new GridBagConstraints();
		//�����ı������Ĳ���
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridheight=1;
		constraints.gridwidth=4;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=100;
		constraints.weighty=100;
		//�ı�����ʾ��ʽ������ı����
		wbk=new JTextField(20);
		wbk.setHorizontalAlignment(JTextField.RIGHT);
		wbk.setBackground(Color.black);
		wbk.setForeground(Color.white);
		layout.setConstraints(wbk,constraints);
		container.add(wbk);
		//��������������
		ActionListener btn = new btnAction();
		ActionListener command = new commandAction();
		//��Ӱ�ť
		addButton("AC",0,1,1,1,btn);
		addButton("+/-",1,1,1,1,btn);
		addButton("%",2,1,1,1,btn); 
		addButton("7",0,2,1,1,btn); 
		addButton("8",1,2,1,1,btn); 
		addButton("9",2,2,1,1,btn); 
		addButton("/",3,1,1,1,command); 
		addButton("4",0,3,1,1,btn); 
		addButton("5",1,3,1,1,btn); 
		addButton("6",2,3,1,1,btn); 
		addButton("*",3,2,1,1,command); 
		addButton("1",0,4,1,1,btn); 
		addButton("2",1,4,1,1,btn); 
		addButton("3",2,4,1,1,btn); 
		addButton("-",3,3,1,1,command); 
		addButton("0",0,5,2,1,btn); 
		addButton(".",2,5,1,1,btn); 
		addButton("+",3,4,1,1,command);
		addButton("=",3,5,1,1,command); 
	}

	private void addButton(String op, int row, int column, int weight, int height,ActionListener listener) {
		// TODO Auto-generated method stub
		JButton button=new JButton(op); 
		constraints.gridx=row; 
		constraints.gridy=column; 
		constraints.gridwidth=weight; 
		constraints.gridheight=height; 
		constraints.fill=GridBagConstraints.BOTH; 
		button.addActionListener(listener); 
		layout.setConstraints(button,constraints); 
		container.add(button); 
		constraints.insets=new Insets(0,0,0,0);//���ð�ť��ļ��
		button.setBorderPainted(true);
		button.setContentAreaFilled(true);
		button.setBounds(2,2,2,2);
		button.contains(5,5);
		button.setBackground(Color.decode("#CCCCCC"));
		if(op=="+"||op=="-"||op=="*"||op=="/"||op=="="){
			button.setBackground(Color.decode("#FF9900"));
			button.setForeground(Color.white);
		}
		if(op=="AC"||op=="+/-"||op=="%"){
			button.setBackground(Color.decode("#999999"));
			button.setForeground(Color.black);
		}
	}
	//ʵ��btnAction ����
	public class btnAction implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String input =e.getActionCommand();
			if(start){
				wbk.setText("");//�ı����������Ϊ��
				start=false;
				if(input.equals("+/-"))
					wbk.setText(wbk.getText()+"-");
			}
			if(!input.equals("+/-")){
				if(input.equals("AC")){
					wbk.setText("0");
					start=true;
				}else if(input.equals("%")){
					double b=Double.parseDouble(wbk.getText());
					wbk.setText(String.valueOf(b*0.01));//��doubleת�����ַ���
				}	else if(input.equals(".")){
					if(wbk.getText().trim().indexOf(".")!=-1){

					}else{
						wbk.setText(wbk.getText()+input);
					}
				}
				else
					wbk.setText(wbk.getText()+input);
			}
		}
	}
	//ʵ��commandAction����
	public class commandAction implements ActionListener{

		public void actionPerformed(ActionEvent a) {
			// TODO Auto-generated method stub
			String command=a.getActionCommand();
			if(start) { 
				remindOp=command; 
			}else { 
				calculate(Double.parseDouble(wbk.getText()));
				remindOp=command;
				start=true; //��������Ĳ�������
			}
		}
	}
	private void calculate(double x) {
		// TODO Auto-generated method stub
		if(remindOp.equals("+"))result+=x;
		else if(remindOp.equals("-")) result-=x;
		else if(remindOp.equals("*")) result*=x;
		else if(remindOp.equals("/")) result/=x;
		else if(remindOp.equals("=")) result=x;   //ʵ�ּ��㹦�ܡ�
		wbk.setText(""+ result); //��ʾ����Ľ��
	}


	public static void main(String[] args){
		Calculator a=new Calculator();
		//���ô���
		a.setTitle("javaģ��ƻ��������");
		a.setSize(400,650);
		a.setVisible(true);
		a.setLocation(400, 30);
		a.setResizable(false);
		a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

package com.jcohy.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FlowLayoutText extends JFrame implements ActionListener{
	Button b=new Button("添加");	
	int i;
	FlowLayoutText(){
		this.setTitle("布局管理器");
		this.setLayout(new FlowLayout());
		this.add(b);
		b.addActionListener(this);
		this.setBounds(100,100,250,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args){
		new FlowLayoutText();
		
	}
	public void actionPerformed(ActionEvent e) {
		i++;
		Button bi=new Button("按钮"+i);
		this.add(bi);
		this.show(true);
		// TODO Auto-generated method stub
		
	}

}

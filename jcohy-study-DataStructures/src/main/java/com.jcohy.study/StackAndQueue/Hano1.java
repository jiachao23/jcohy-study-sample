package com.jcohy.study.StackAndQueue;

import java.util.Stack;

/**
 * �ǵݹ鷽������ջ��ģ��
 * ���У��ң�����Ϊ����ջls��ms��rs������Ķ���ls��
 * ֻ���ĸ����������У��������ң�����
 * ���Ҫ�߳���С������������ѭ������������
 * ��������Сѹ������ڲ����档���fromջ������Ԫ��num�����ѹ��to�У���ônum��ֵ����
 * С��toջ��ջ��Ԫ��
 * ���к�����Ϊ�����
 * 1����Ϸ�ĵ�һ������Ϊ�����
 * ���߳���С���������е��κ�ʱ�̣��ĸ�����ֻ��һ��������Υ��Сѹ������ڲ�����ԭ������
 * ���������෴
 * @author jiachao
 *
 */
public class Hano1 {
	public enum Action{
		No,LToM,MToL,MToR,RToM
	}
	public int hanoi2(int num,String left,String mid,String right){
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();
		ls.push(Integer.MAX_VALUE);
		ms.push(Integer.MAX_VALUE);
		rs.push(Integer.MAX_VALUE);
		for(int i=num;i>0;i--){
			ls.push(i);
		}
		Action[] record = {Action.No};
		int step =0;
		while(rs.size()!=num+1){
			step+=fStackToStack(record,Action.MToL,Action.LToM,ls,ms,left,mid);
			step+=fStackToStack(record,Action.LToM,Action.MToL,ms,ls,mid,left);
			step+=fStackToStack(record,Action.RToM,Action.MToR,rs,ms,right,mid);
			step+=fStackToStack(record,Action.MToR,Action.RToM,ms,rs,mid,right);
		}
		return step;
	}
	public int fStackToStack(Action[] record, Action preNoAct, Action nowAct,
			Stack<Integer> fstack, Stack<Integer> tstack, String from, String to) {
			if(record[0]!=preNoAct&&(fstack.peek()<tstack.peek())){
				tstack.push(fstack.pop());
				System.out.println("�� "+tstack.peek()+" �� "+from+" �Ƶ� "+to);
				record[0]=nowAct;
				return 1;
			}
		return 0;
	}
	public static void main(String[] args) {
		Hano1 h1 = new Hano1();
		int result =h1.hanoi2(10, "��","��","��");
		System.out.println(result);
	}
}

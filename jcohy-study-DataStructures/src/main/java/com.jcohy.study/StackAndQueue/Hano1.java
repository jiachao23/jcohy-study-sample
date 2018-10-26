package com.jcohy.study.StackAndQueue;

import java.util.Stack;

/**
 * 非递归方法，用栈来模拟
 * 左，中，右，抽象为三个栈ls，ms，rs，最初的都在ls上
 * 只有四个动作。左中，中左，中右，右中
 * 如果要走出最小步数，必须遵循下面两个规则
 * 两个规则，小压大和相邻不可逆。如果from栈弹出的元素num如果想压入to中，那么num的值必须
 * 小于to栈的栈顶元素
 * 左中和中左互为逆过程
 * 1，游戏的第一个动作为左道中
 * 在走出最小步数过程中的任何时刻，四个动作只有一个动作不违反小压大河相邻不可逆原则，另外
 * 三个动作相反
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
				System.out.println("将 "+tstack.peek()+" 从 "+from+" 移到 "+to);
				record[0]=nowAct;
				return 1;
			}
		return 0;
	}
	public static void main(String[] args) {
		Hano1 h1 = new Hano1();
		int result =h1.hanoi2(10, "左","中","右");
		System.out.println(result);
	}
}

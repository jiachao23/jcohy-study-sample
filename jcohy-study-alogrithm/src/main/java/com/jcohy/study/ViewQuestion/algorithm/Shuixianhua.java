package com.jcohy.study.ViewQuestion.algorithm;
/**
 * ：打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位
 * 数字立方和等于该数本身。例如：153是一个 "水仙花数 "，
 * 因为153=1的三次方＋5的三次方＋3的三次方。
 * @author jiachao
 *
 */
public class Shuixianhua {

	public static void main(String[] args) {
		int i=0;
		Shuixianhua mymath = new Shuixianhua();
		       for(i=100;i<=999;i++)
		           if(mymath.shuixianhua(i)==true)
		           System.out.println(i);
	}

	private boolean shuixianhua(int x) {
		int i=0,j=0,k=0;
		i=x/100;
		j=(x%100)/10;
		k=x%10;
		if(x==(i*i*i+j*j*j+k*k*k))
			return true;
		else
			return false;
	}

}

package com.jcohy.study.StackAndQueue;

/**
 * �����淨
 * @author jiachao
 *
 */
public class HanoGenernal {
static int step = 0;  
    
    public static void main(String[] args) {  
        hanioSort(2, "A", "B", "C");  
    }  
       
    public static void hanioSort(int num ,String a ,String b ,String c){  
        if(num == 1){  
            move(num,a,c);  
        } else{  
            hanioSort(num-1, a, c, b);  
            move(num,a,c);  
            hanioSort(num-1, b, a, c);  
        }  
    }  
    public static void move(int num ,String a,String b){  
        step ++ ;  
        System.out.println("��"+step+"��������"+num+"��"+a+"���Ƶ�"+b+"��/n");  
    }  
}

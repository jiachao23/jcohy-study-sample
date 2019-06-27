package com.jcohy.study.SimpleQuestion;

import java.util.Scanner;

/**
 * 学生分数
 */
public class Test_1050 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Student s[]=new Student[n];
        for(int i=0;i<s.length;i++)
        {
            String id=sc.next();
            String name=sc.next();
            int a1=sc.nextInt();
            int a2=sc.nextInt();
            int a3=sc.nextInt();
            s[i]=new Student(id,name,a1,a2,a3);
        }
        Student.aver(s);
        Student.sort(s);
         
 
    }
 
}

class Student
{
    private String id;
    private String name;
    private int a1;
    private int a2;
    private int a3;
     
    public Student(String id,String name,int a1,int a2,int a3)
    {
        this.id=id;
        this.name=name;
        this.a1=a1;
        this.a2=a2;
        this.a3=a3;
         
    }
     
    public static void aver(Student []s)
    {
        int a=0,b=0,c=0;
        for(int i=0;i<s.length;i++)
        {
            a+=s[i].a1;
            b+=s[i].a2;
            c+=s[i].a3;
        }
        a=a/s.length;
        b=b/s.length;
        c=c/s.length;
        System.out.println(a+" "+b+" "+c);
         
    }
    public static void sort(Student []s)
    {
        int Index=0;
        for(int i=0;i<s.length-1;i++)
        {
            if((s[i].a1+s[i].a2+s[i].a3)<(s[i+1].a1+s[i+1].a2+s[i+1].a3))
            {
                Index=i+1;
            }
        }
         
         System.out.println(s[Index].id+" "+s[Index].name+" "+s[Index].a1+" "
                 +s[Index].a2+" "+s[Index].a3);
    }
}
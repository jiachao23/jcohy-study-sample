package com.jcohy.study.builder;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class Test {
    public static void main(String[] args){
        if(args.length<1){
            usage();
            System.exit(0);
        }
        if(args[0].equals("plain")){
            Director director = new Director(new TextBuilder());
            String result= (String) director.construct();
            System.out.println(result);
        }else if(args[0].equals("html")){
            Director director = new Director(new HtmlBuilder());
            String fileName= (String) director.construct();
            System.out.println("以产生"+fileName);
        }else{
            usage();
            System.exit(0);
        }

    }
    public static void usage(){
        System.out.println("Usage java Main Plain 产生一般文件格式的文件");
        System.out.println("Usage java Main Plain 产生一般HTML文件格式的文件");
    }
}

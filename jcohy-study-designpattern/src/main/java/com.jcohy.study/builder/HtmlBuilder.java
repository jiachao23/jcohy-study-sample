package com.jcohy.study.builder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Copyright  : 2017- www.jcohy.com
 * Created by jiac on 23:48 2018/8/7
 * Email: jia_chao23@126.com
 * Description:
 **/
public class HtmlBuilder extends Builder{
    /**
     * 将文本建立成HTML格式
     */
    private String fileName;
    private PrintWriter printWriter;

    @Override
    public void makeTitle(String title) {
        fileName = "title"+".html";
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        printWriter.write("<html><header><title>"+title+"</title></head><body>");
        printWriter.write("<h1>"+title+"</h1>");
    }

    @Override
    public void makeString(String str) {
        printWriter.write("<p>"+str+"</p>");
    }

    @Override
    public void makeItems(String[] items) {
        printWriter.write("<ul>");
        for (int i=0;i<items.length;i++){
            printWriter.write("<li>"+items[i]+"</li>");
        }
        printWriter.write("</ul>");
    }

    @Override
    public Object getResult() {
        printWriter.write("</body></html>");
        printWriter.close();
        return fileName;//返回文件名
    }
}

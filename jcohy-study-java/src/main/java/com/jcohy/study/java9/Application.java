package com.jcohy.study.java9;

/**
 * Created by songhongkang on 2017/12/28 0028.
 */
public class Application {

   public static void testMultiJar(){
      Generator gen = new Generator();
      System.out.println("Generated strings: " + gen.createStrings());
   }
}

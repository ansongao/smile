package com.baidu.study;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
* @author: anson
* @CreateDate: 2017年8月25日 下午4:36:46
* @version: V 1.0
* 
*/
public class ExceptionTest extends RuntimeException {
    public static void main(String[] args) {
        String file = "D:\\styles.css";
        FileReader reader;
        try {
            reader = new FileReader(file);
            Scanner in = new Scanner(reader);  
            String string = in.next();  
            System.out.println(string + "不知道我有幸能够执行到不.....");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("对不起,你执行不到...");
        }  
        finally{
            System.out.println("finally 在执行...");
        }
    }
}

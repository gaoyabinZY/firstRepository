package com.gyb.jse2test.test01.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesTest {
    public static void main(String[] args) {
        //获取test.properties文件中的value值
        InputStream is = null;
        try {
            //1.实例化Properties类的对象
            //另一种理解，撞见一个Properties类型的 双列空集合
            Properties properties = new Properties();
            //2.通过加载器，获取输入流，读取test.properties的文件内容
            is = PropertiesTest.class.getResourceAsStream("test.properties");
            //3.载入该数据流（将读取的文件内容，载入到properties集合中）
            properties.load(is);
            //4.根据key获取value值
            System.out.println("name=" + properties.getProperty("name") + ",password=" + properties.getProperty("password"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

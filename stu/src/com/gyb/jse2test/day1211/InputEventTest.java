package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputEventTest {
    public static void main(String[] args) {
        MyFrame01 frame = new MyFrame01();
    }
}

class MyFrame01 extends Frame {
    public MyFrame01(){
        setBounds(200,200,500,500);
        TextField textField = new TextField();
        this.add(textField);

        //自定义监听器，监听文本框输入的文字
        MyActionListener01 myActionListener = new MyActionListener01();
        textField.addActionListener(myActionListener);

        setVisible(true);
    }

}

//自定义监听器
class MyActionListener01 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取触发事件的文本域对象
         TextField textField = (TextField) e.getSource();
         //获取输入的文字
        String text = textField.getText();
        System.out.println(text);
        //清空文本域对象
        textField.setText("");
    }
}

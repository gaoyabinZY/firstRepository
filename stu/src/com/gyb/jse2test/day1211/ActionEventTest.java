package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventTest {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBounds(100,100,400,400);
        Button button = new Button();
        button.setName("listener button");
        frame.add(button);

        //构造一个ActionListener满足addActionListener监听事件的需求
        //2、实例化自定义监听器对象
        MyActionListener actionListener = new MyActionListener();
        //3、将该对象作为addActionListener的参数
        button.addActionListener(actionListener);
        frame.pack();
        frame.setVisible(true);
    }
}


class MyActionListener implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("ActionListener run");
    }
}
package com.gyb.jse2test.day1212;

import javax.swing.*;
import java.awt.*;

public class JFrameTest {
    public static void main(String[] args) {
        MyJFrame jFrame = new MyJFrame();
        jFrame.init();
    }
}

//自定义Jframe窗口
class MyJFrame extends JFrame{
    public void init(){
        setBounds(100,200,300,400);
        setBackground(Color.GREEN);

        JLabel label = new JLabel("hello swing");
        //设置水平居中setHorzontalAlignment
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //获得一个container容器
        Container container = this.getContentPane();
        container.setBackground(Color.RED);
        this.add(label);


        setVisible(true);
    }
}

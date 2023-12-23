package com.gyb.jse2test.day1211;

import javax.swing.border.Border;
import java.awt.*;

public class FlowLayoutTest {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(200,200,600,600,new Color(57, 13, 13));

        //组件-按钮
        Button button1 = new Button("submit");
        Button button2 = new Button("reset");
        Button button3 = new Button("back");

        //设置流式布局 setLayout（流式布局对象）
        //作用效果等同于浮动，new FlowLayout(FlowLayout.LEFT)
//        frame.setLayout(new FlowLayout(FlowLayout.LEFT));

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        Button button4 = new Button("EAST");
        Button button5 = new Button("WEST");
        Button button6 = new Button("SOUTH");
        Button button7 = new Button("NORTH");
        Button button8 = new Button("CENTER");

        //环绕布局，东西南北中，通过BorderLayout
        frame.add(button4, BorderLayout.EAST);
        frame.add(button5, BorderLayout.WEST);
        frame.add(button6, BorderLayout.SOUTH);
        frame.add(button7, BorderLayout.NORTH);
        frame.add(button8, BorderLayout.CENTER);

        frame.setVisible(true);

    }

}

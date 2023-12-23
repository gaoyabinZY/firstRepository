package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MoveTest {
    public static void main(String[] args) {
        int x = 200;
        int y = 200;
        int w = 1000;
        int h = 1000;
        int snake_scale = 20/1000;
        Color snakeColor = new Color(116, 12, 12);

        MyFrame03 frame = new MyFrame03(x,y,w,h);
        frame.setLayout(new GridLayout(100,100));
//        frame.setLayout(new GridLayout());

        Panel panel1 = new Panel(new GridLayout(1,1));
        panel1.setName("snake");
        panel1.setSize(w * snake_scale,h * snake_scale);
        panel1.setBackground(snakeColor);
        Panel panel2 = new Panel();
        panel2.setName("snake");
        panel2.setSize(w * snake_scale,h * snake_scale);
        panel2.setBackground(Color.BLACK);

        frame.add(panel1);
        frame.add(panel2);

        frame.setVisible(true);
    }
}


class MyFrame03 extends Frame {
    public MyFrame03(int x, int y, int w, int h){
        this.setBounds(x,y,w,h);

        //添加窗口监听关闭和激活
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("游戏gai束");
                System.exit(0);

            }

            @Override
            public void windowActivated(WindowEvent e) {
                System.out.println("回到游戏");
            }
        });
    }
}
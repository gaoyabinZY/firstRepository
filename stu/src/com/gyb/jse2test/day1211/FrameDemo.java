package com.gyb.jse2test.day1211;

import java.awt.*;

public class FrameDemo {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame(200,200,600,600,new Color(255,255,255));
        Panel wastPanel = new Panel();
        Panel eastPanel = new Panel();
        Panel centerPanel = new Panel();

        frame.setLayout(new GridLayout(2,1));

        Panel panel_1 = new Panel();
        panel_1.setLayout(new GridLayout(1,3));
        Panel panel_1_1 = new Panel();
        panel_1_1.setBackground(new Color(147, 228, 28));
        panel_1_1.setSize(100,100);
        Panel panel_1_2 = new Panel();
        panel_1_2.setLayout(new GridLayout(2,1));
        panel_1_2.setSize(100,100);
        Panel panel_1_3 = new Panel();
        panel_1_3.setLayout(new GridLayout(1,3));
        panel_1_3.setBackground(new Color(100, 43, 76));
        Panel panel_1_2_1 = new Panel();
        panel_1_2_1.setBackground(new Color(62, 147, 66));
        panel_1_2_1.setSize(200,100);
        Panel panel_1_2_2 = new Panel();
        panel_1_2_2.setBackground(new Color(105, 7, 116));
        panel_1_2_2.setSize(200,100);
        panel_1_2.add(panel_1_2_1);
        panel_1_2.add(panel_1_2_2);
        panel_1.add(panel_1_1);
        panel_1.add(panel_1_2);
        panel_1.add(panel_1_3);

        Panel panel_2 = new Panel();
        panel_2.setLayout(new GridLayout(1,3));
        Panel panel_2_1 = new Panel();
        panel_2_1.setBackground(new Color(177, 28, 28));
        panel_2_1.setSize(100,100);
        Panel panel_2_2 = new Panel();
        panel_2_2.setLayout(new GridLayout(2,2));
        panel_2_2.setSize(100,100);
        Panel panel_2_3 = new Panel();
        panel_2_3.setLayout(new GridLayout(1,3));
        panel_2_3.setBackground(new Color(7, 43, 76));
        Panel panel_2_2_1 = new Panel();
        panel_2_2_1.setBackground(new Color(62, 147, 66));
        panel_2_2_1.setSize(200,100);
        Panel panel_2_2_2 = new Panel();
        panel_2_2_2.setBackground(new Color(10, 7, 116));
        panel_2_2_2.setSize(200,100);
        Panel panel_2_2_3 = new Panel();
        panel_2_2_3.setBackground(new Color(12, 19, 12));
        panel_2_2_3.setSize(200,100);
        Panel panel_2_2_4 = new Panel();
        panel_2_2_4.setBackground(new Color(231, 231, 12, 161));
        panel_2_2_4.setSize(200,100);
        panel_2_2.add(panel_2_2_1);
        panel_2_2.add(panel_2_2_2);
        panel_2_2.add(panel_2_2_3);
        panel_2_2.add(panel_2_2_4);
        panel_2.add(panel_2_1);
        panel_2.add(panel_2_2);
        panel_2.add(panel_2_3);

        frame.add(panel_1);

        frame.add(panel_2);

        frame.setVisible(true);

    }
}

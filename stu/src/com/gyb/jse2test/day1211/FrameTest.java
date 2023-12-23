package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {
    public static void main(String[] args) {
        //创建图形对象
        Frame frame = new Frame();

        //设置可见性
        frame.setVisible(true);

        //设置窗口大小
        frame.setSize(1000,1000);

        //设置窗口弹出起始位置
        frame.setLocation(200,100);

        //设置背景颜色
        frame.setBackground(new Color(7, 58, 69));

        //设置窗口大小固定
        frame.setResizable(false);

        //创建面板
        Panel panel = new Panel();

        //设置面板
        panel.setSize(200,200);
        panel.setLocation(200,100);
        panel.setBackground(new Color(80, 21, 21));

        //设置布局，为null清空布局
        frame.setLayout(null);

        //添加面板到窗口
        frame.add(panel);

        //设置可见性
        frame.setVisible(true);

        //添加监听事件，监听的是窗口关闭事件（通过点击X关闭窗口）
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
//                super.windowClosing(e);
                //关闭窗口
                System.exit(0);
            }
        });

    }
}

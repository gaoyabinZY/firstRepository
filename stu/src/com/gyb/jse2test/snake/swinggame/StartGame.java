package com.gyb.jse2test.snake.swinggame;

import javax.swing.*;

public class StartGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setBounds(10,10,900,720);
        frame.setTitle("贪吃蛇");

//        frame.add(游戏本体panel);
        GamePanel gamePanel = new GamePanel();
        frame.add(gamePanel);

        frame.setVisible(true);
        //固定页面大小
        frame.setResizable(false);
        //关闭界面的同时关闭后台
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

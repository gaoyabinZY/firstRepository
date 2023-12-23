package com.gyb.jse2test.snake.swinggame;

import javax.swing.*;
import java.net.URL;

public class GameData {
    //图片公共路径
    public static final String PREV="com/gyb/jse2test/snake/resource/image/";

    //获取资源URL
    public static URL headerURL = GameData.class.getResource("/" + PREV + "header.png");
    public static URL bodyURL = GameData.class.getResource("/" + PREV + "body.png");
    public static URL foodURL = GameData.class.getResource("/" + PREV + "food.png");
    public static URL upURL = GameData.class.getResource("/" + PREV + "up.png");
    public static URL downURL = GameData.class.getResource("/" + PREV + "down.png");
    public static URL leftURL = GameData.class.getResource("/" + PREV + "left.png");
    public static URL rightURL = GameData.class.getResource("/" + PREV + "right.png");

    //使用ImageIcon对象将URL对应资源引入
    public static ImageIcon header = new ImageIcon(headerURL);
    public static ImageIcon body = new ImageIcon(bodyURL);
    public static ImageIcon food = new ImageIcon(foodURL);
    public static ImageIcon up = new ImageIcon(upURL);
    public static ImageIcon down = new ImageIcon(downURL);
    public static ImageIcon left = new ImageIcon(leftURL);
    public static ImageIcon right = new ImageIcon(rightURL);
}

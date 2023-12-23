package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MouseEventTest {
    public static void main(String[] args) {
        MyFrame04 frame = new MyFrame04("画点");

        frame.setVisible(true);
    }
}

class MyFrame04 extends Frame {

    List<Point> points;

    public MyFrame04(String name){
        super(name);
        setBounds(200,200,800,800);

        //创建List存放鼠标点击过的位置
        points = new ArrayList<>();

        this.addMouseListener(new MyMouseListener());

    }

    @Override
    public void paint(Graphics g) {
        //遍历容器，画所有点
        Iterator<Point> iterator = this.points.iterator();
        while(iterator.hasNext()){
             Point point = iterator.next();
             g.setColor(Color.RED);
             g.fillOval(point.x,point.y,5,5);
        }
    }

    public void addPoint(Point point){
        this.points.add(point);
    }

}

//自定义鼠标监听器
class MyMouseListener extends MouseAdapter{

    @Override
    public void mousePressed(MouseEvent e) {
        MyFrame04 frame = (MyFrame04) e.getSource();

        //画点，获取当前point位置，添加到点的集合中
        frame.addPoint(new Point(e.getX(),e.getY()));
        System.out.println("X: " + e.getX() + ",Y: " + e.getY());
        //重画所有点
        frame.repaint();
    }
}
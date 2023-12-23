package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardEventTest {
    public static void main(String[] args) {
        MyFrame02 frame = new MyFrame02();

    }

}

class MyFrame02 extends Frame {

    public MyFrame02(){
        this.setBounds(200,200,500,500);
        this.setVisible(true);

        //创建键盘事件监听器实例
        this.addKeyListener(new KeyAdapter() {

            //监听键盘按下事件
            @Override
            public void keyPressed(KeyEvent e) {
                //获取当前按下的是哪个键
                int keyCode = e.getKeyCode();
                System.out.println("keyCode：" + keyCode);

                if(keyCode == KeyEvent.VK_UP){
                    System.out.println("上方向键");
                }


//                KeyAdapter key = (KeyAdapter) e.getSource();


            }
        });
    }

}

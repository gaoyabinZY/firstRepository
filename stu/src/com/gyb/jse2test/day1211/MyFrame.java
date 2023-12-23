    package com.gyb.jse2test.day1211;

    import java.awt.*;
    import java.awt.event.WindowAdapter;
    import java.awt.event.WindowEvent;

    public class MyFrame extends Frame {
        static int id = 0;

        public MyFrame(int x, int y, int w, int h, Color color){
            //自增的窗口编号
            super("MyFrame" + ++id);
            setVisible(true);
            setBounds(x,y,w,h);
            setBackground(color);

            //监听激活
            this.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("windowClosing" + id);
                    System.exit(0);
                }

                @Override
                public void windowActivated(WindowEvent e) {
                    MyFrame source = (MyFrame)e.getSource();
                    System.out.println("windowActivated" + id);
                }
            });
        }

    }

    class A{
        public static void main(String[] args) {
            for (int i = 0; i < 6; i++) {
                MyFrame frame = new MyFrame((i%3)*300,(i/3)*400,300,400,new Color(5, 13, 62));
            }
        }
    }
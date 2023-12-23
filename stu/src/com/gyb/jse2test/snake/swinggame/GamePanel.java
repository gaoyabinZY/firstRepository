package com.gyb.jse2test.snake.swinggame;


import com.sun.javaws.progress.PreloaderPostEventListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

/**
 * 游戏面板
 * 是游戏本体，使用JPanel
 * 需要使用自定义的键盘监听事件
 */
public class GamePanel extends JPanel implements
        KeyListener, ActionListener {
    private final static Random random = new Random();

    int length; //长度
    int[] snakeX = new int[600];//X坐标
    int[] snakeY = new int[600];//Y坐标
    String fx;  //初始时蛇头方向

    //食物（点）
    int foodX;//X坐标
    int foodY;//Y坐标

    //虚拟属性
    //当前游戏状态
    boolean isStart = false;    //是否正在运行
    boolean isFail = false; //是否失败

    //成绩
    int score;

    //时间间隔器(定时器 Timer)
    Timer timer = new Timer(100,this);

    //使用默认无参构造 封装游戏进行所需要的函数
    public  GamePanel(){

        //游戏初始化函数   init()
        init();
        //自定义事件监听 获得焦点事件
        this.setFocusable(true);
        //加载监听事件1、焦点 2、键盘
        this.addKeyListener(this);


        //启动游戏 由定时器对象调用start()
        timer.start();

    }

    /**
     * 游戏初始化(数值)
     */
    public void init(){
        //初始化蛇
        length = 4;
        snakeX[0] = 150;//头的坐标
        snakeX[1] = 125;
        snakeX[2] = 100;
        snakeX[3] = 75;
        fx="R";//方向向右

        snakeY[0] = 150;
        snakeY[1] = 150;
        snakeY[2] = 150;
        snakeY[3] = 150;

        //初始化食物点
        foodX = 25*random.nextInt(850/25 );
        foodY = 25*random.nextInt(600/25 );
        //初始化成绩score=0
        score = 0;


    }

    //绘图

    @Override
    public void paintComponent(Graphics g) {
        //清屏
        super.paintComponent(g);

        //绘制静态面板
        setBackground(new Color(70,70,70));

        //设置header
        GameData.header.paintIcon(this,g,25,10);
        //画成绩
        g.setColor(Color.white);
        g.setFont(new Font("楷体",Font.BOLD,30));
        g.drawString("长度：" + length, 450,50);
        g.drawString("分数：" + length, 600, 50);

        //游戏主体界面
        g.setColor(Color.GRAY);
        //绘制填充矩形,左上角的位置，以及宽高
        g.fillRect(25,75,850,600);

        //绘制蛇
        if("R".equals(fx)){
            GameData.right.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("U".equals(fx)){
            GameData.up.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("L".equals(fx)){
            GameData.left.paintIcon(this,g,snakeX[0],snakeY[0]);
        }else if("D".equals(fx)){
            GameData.down.paintIcon(this,g,snakeX[0],snakeY[0]);
        }
        for(int i = 1; i < length; i++){
            GameData.body.paintIcon(this,g,snakeX[i],snakeY[i]);
        }

        //绘制食物
        GameData.food.paintIcon(this,g,foodX,foodY);

        //游戏状态不同，中间显示文字不同
        if(!isStart){
            //游戏还未开始
            g.setColor(Color.WHITE);
            g.setFont(new Font("楷体",Font.BOLD,30));
            g.drawString("按下空格开始游戏",300,300);
        }

        if(isFail){
            g.setColor(Color.RED);
            g.setFont(new Font("楷体",Font.BOLD,30));
            g.drawString("游戏失败，按下空格重新开始游戏",300,300);

        }

    }


    //键盘事件监听


    /**
     * 自定义事件监听，事物，边缘碰撞
     */


    @Override
    public void actionPerformed(ActionEvent e) {
        //不是失败状态，是运行状态
        if(isStart && !isFail){
            //吃食物
            if(snakeX[0] == foodX&& snakeY[1] == foodY){
                length++;
                score += 10;
                //再次绘制重置坐标
                foodX = 25*random.nextInt(850/25 + 1);
                foodY = 25*random.nextInt(600/25 + 1);
            }

            //蛇的移动
            //身体移动
            for (int i = length; i>=1; i--){
                snakeX[i] = snakeX[i-1];
                snakeY[i] = snakeY[i-1];
            }
            //头移动
            if("R".equals(fx)){
                snakeX[0] += 25;
                if(snakeX[0] > 850){
                    snakeX[0] = 25;
                }
            }if("L".equals(fx)){
                snakeX[0] -= 25;
                if(snakeX[0] < 25){
                    snakeX[0] = 825;
                }
            }if("U".equals(fx)){
                snakeY[0] -= 25;
                if(snakeY[0] < 25){
                    snakeY[0] = 650;
                }
            }if("D".equals(fx)){
                snakeY[0] += 25;
                if(snakeY[0] > 650){
                    snakeY[0] = 25;
                }
            }

            //失败的判定，撞到自己
            for(int i = 1; i < length; i++){
                if(snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0] ){
                    isFail = true;
                }
            }

            //使用事件间隔器，让以上代码每100毫秒执行一次
            repaint();
        }

        timer.start();
    }


    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //空格开始游戏
        if(keyCode == KeyEvent.VK_SPACE){
            //如果是失败重来
            if(isFail){
                isFail = false;
                init();
            }else{
                //第一次开始
                isStart = !isStart;
            }
            repaint();
        }

        //控制蛇头方向
        if(keyCode == KeyEvent.VK_UP){
            fx="U";
        }else if(keyCode == KeyEvent.VK_DOWN){
            fx="D";
        }else if(keyCode == KeyEvent.VK_LEFT){
            fx="L";
        }else if(keyCode == KeyEvent.VK_RIGHT){
            fx="R";
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}

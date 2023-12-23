package com.gyb.jse2test.day1211;

import java.awt.*;
import java.awt.event.*;
import java.nio.charset.StandardCharsets;
import java.security.spec.ECField;
import java.util.*;
import java.util.List;

public class CalculatorTest {
    public static void main(String[] args) {
        MyFrame05 calculator = new MyFrame05();

//      按钮集合
        //没用按键集合
        List<Button> unUsedBtnList = new ArrayList<>();
        unUsedBtnList.add(new Button("%"));//求余
        unUsedBtnList.add(new Button("CE"));//CE
        unUsedBtnList.add(new Button("C"));//C
        unUsedBtnList.add(new Button("<=×="));//退格
        unUsedBtnList.add(new Button("1/x"));//倒数
        unUsedBtnList.add(new Button("x²"));//平方
        unUsedBtnList.add(new Button("√x"));//倒数
        unUsedBtnList.add(new Button("00"));//00

        //数字集合
        Button button_0 = new Button("0");
        List<Button> numberBtnList = new ArrayList<>();

        //布局
        calculator.setLayout(new GridLayout(2,1,10,5));

        Panel panel_1 = new Panel(new GridLayout(2,1));
        calculator.add(panel_1);

        //添加文本域
        TextField field = new TextField();
        panel_1.add(field);
        field.setBounds(0,0,500,200);

        //特殊按键
        Panel panel_1_2 = new Panel(new GridLayout(2,4));
        panel_1.add(panel_1_2);

        Iterator<Button> iterator = unUsedBtnList.iterator();
        while(iterator.hasNext()){
            panel_1_2.add(iterator.next());
        }

        //按键
        Panel panel_2 = new Panel(new GridLayout(1,2));

        //键盘左
        Panel panel_2_1 = new Panel(new GridLayout(3,3));
        panel_2.add(panel_2_1);
        for(int i = 9; i > 0; i--){
            Button button = new Button(i+"");
            button.setName(i+"");
            //添加监听
            button.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    field.setText(field.getText() + button.getName());
                }
            });
            numberBtnList.add(button);
            panel_2_1.add(button);
        }

        //运算和功能键
        Button button_EC = new Button("EC");
        Button button_add = new Button("+");
        Button button_minus = new Button("-");
        Button button_multiply = new Button("×");
        Button button_divide = new Button("÷");
        Button button_equalTo = new Button("=");

        //键盘右
        Panel panel_2_2 = new Panel(new GridLayout(4,1));
        panel_2.add(panel_2_2);
        Panel panel_EC = new Panel(new GridLayout(1,1));
        panel_EC.add(button_EC);
        Panel panel_2_2_2 = new Panel(new GridLayout(1,2));
        panel_2_2_2.add(button_add);
        panel_2_2_2.add(button_minus);

        Panel panel_2_2_3 = new Panel(new GridLayout(1,2));
        panel_2_2_3.add(button_multiply);
        panel_2_2_3.add(button_divide);

        Panel panel_2_2_4 = new Panel(new GridLayout(1,2));
        panel_2_2_4.add(button_0);
        panel_2_2_4.add(button_equalTo);

        panel_2_2.add(panel_EC);
        panel_2_2.add(panel_2_2_2);
        panel_2_2.add(panel_2_2_3);
        panel_2_2.add(panel_2_2_4);

        //把数字放在一个数组
        numberBtnList.add(button_0);

        //运算符按钮在一个map集合
        Map<Character, Button> map = new HashMap<>();
        map.put('+',button_add);
        map.put('-',button_minus);
        map.put('*',button_multiply);
        map.put('/',button_divide);
        Set<Map.Entry<Character, Button>> entries = map.entrySet();
        entries.forEach(entry -> {
            int key = entry.getKey();
            Button button = entry.getValue();
            button.addMouseListener(new MouseAdapter(){
                @Override
                public void mousePressed(MouseEvent e) {
                    field.setText(field.getText() + (char)key);
                }
            });

        });
//        map.put(,button_equalTo);
//        给”=“加事件调用计算方法
        button_equalTo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                String result = Calculate.calculate(field.getText());
                field.setText(result);
            }
        });

        //EC添加清除事件
        button_EC.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                field.setText("");
            }
        });



        //添加按键
        calculator.add(panel_2);

        calculator.setVisible(true);
    }
}


class MyFrame05 extends Frame {
    public MyFrame05(){
        this.setBounds(200,200,500,725);
        this.setResizable(false);
    }
}

//字符串表达式计算工具类
class Calculate{
    private static int number(char[] arr,int start,int end){
        StringBuilder buffer = new StringBuilder();
        for(int i=start;i<=end;i++){
            buffer.append(arr[i]);
        }
        return Integer.parseInt(buffer.toString());
    }
    // 待实现函数，在此函数中填入答题代码
    private static int comp(String op){
        if(op.equals("+") || op.equals("-")) {
            return 1;
        }
        if(op.equals("*") || op.equals("/")) {
            return 2;
        }
        return 0;
    }
    private static String compute(Integer a,Integer b,String op){
        Integer res;
        if(op.equals("+")) {
            res = a + b;
            return res.toString();
        }
        if (op.equals("-")) {
            res=a-b;
            return res.toString();
        }
        if (op.equals("*")) {
            res = a * b;
            return res.toString();
        }
        if (op.equals("/") && b!=0) {
            res=a/b;
            return res.toString();
        }else{
            return "error";
        }
    }
    public static String calculate(String source) {
        Stack<Integer> numbers=new Stack<>();
        Stack<String> operator=new Stack<>();
        operator.push(".");
        char[] exps=source.toCharArray();
        int start=0;
        if(exps[0]=='-') {
            numbers.push(0);
        }
        for(int j=0;j<exps.length;j++){
            if(exps[j]=='+' || exps[j]=='*' || exps[j]=='/' || exps[j]=='-'){
                if (start <= j - 1) {
                    numbers.push(number(exps,start,j-1));
                }
                start=j+1;
                while (comp(operator.peek())>=comp(String.valueOf(exps[j]))){
                    Integer two=numbers.peek();numbers.pop();
                    Integer one=numbers.peek();numbers.pop();
                    String result=compute(one,two,operator.peek());operator.pop();
                    if (result.equals("error")) {
                        return result;
                    }
                    numbers.push(Integer.parseInt(result));
                }
                operator.push(String.valueOf(exps[j]));
            }
        }
        numbers.push(number(exps,start,exps.length-1));
        while (operator.size()>1){
            Integer two=numbers.peek();numbers.pop();
            Integer one =numbers.peek();numbers.pop();
            String op=operator.peek();operator.pop();
            String value = compute(one, two, op);
            if (value.equals("error")) {
                return value;
            }
            numbers.push(Integer.parseInt(value));
        }
        return numbers.peek().toString();
    }
}

package Myapp1;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class myapp {
    public static void main(String args[]) {
   /*     JLabel label1;
        JTextField field;
        JButton JB1;
        JButton JB2;
        JLabel lanbelset[] = new JLabel[0];
        JTextField fieldset[] = new JTextField[0];
        Panel panel1;
        Panel panel2;
        JB1=new JButton("提交题数");
        JB2=new JButton("提交题目");
        JFrame frame = new JFrame("分数运算器");
        frame.setResizable(false);
        frame.setSize(400, 600);
        frame.setVisible(true);
        label1=new JLabel("输入生成的题目");
        field=new JTextField();
        field.isEnabled();


            int count = 0;                   //表示答对的题数

      for(int i=0;i<10;i++){
          lanbelset[i]=new JLabel();
      }
        for(int i=0;i<10;i++){
            fieldset[i]=new JTextField();
        }
        panel1=new Panel();
        panel2=new Panel();

         frame.add(panel1);
         frame.add(panel2);*/
/*
 本来想写界面但是有点麻烦
 */
        System.out.println("请输入要生成的题目数：");
        Scanner reader1 = new Scanner(System.in);
        int y = reader1.nextInt();     //输入生成的题目
        System.out.println("请输入要生成题目的计算范围：");
        Scanner reader2 = new Scanner(System.in);
        int range = reader1.nextInt();     //输入题目的范围
        try {
            String name1 = file.createfile("练习题");
            String name2 = file.createfile("答案");
            PrintWriter pw1 = new PrintWriter(name1);
            PrintWriter pw2 = new PrintWriter(name2);
            for (int i = 1; i <= y; i++) {
                String Question = "";
                String Answer = " ";
                Random random1 = new Random();   //生成随机数
                int w = random1.nextInt(2) + 1;   //生成1到2之间的随机数w，表示是否要用分数
                //系统随机生成的表达式Question
                String timu = "题目：" + i;
                pw1.write(timu + "\r\n ");
                pw1.flush();
                Random random = new Random();   //生成随机数
                int a = random.nextInt(3) + 1;   //生成1-3个运算符号
                if (w % 2 == 0) {         //为偶数，不生成分数
                    for (int j = 1; j <= a + 1; j++) {
                        int b = random.nextInt(range)+1;   //生成范围
                        if (j <= a) {
                            Symbol S = new Symbol();  //声明类Symbol的对象k
                            char q = S.Symbol();   //产生一个运算符q

                            Question = Question + b + q;  //随机数和随机符号存入Question中
                        } else {
                            Question = Question + b;    //随机数存入Question中
                        }
                    }

                } else if (w % 2 == 1) {        //奇数，生成分数
                    for (int j = 1; j <= a + 1; j++) {
                        transform t = new transform();   //声明Rational的对象r
                        t.Numberator(random.nextInt(20) + 1);//设置分子是1到20之间的随机数
                        t.denominator(random.nextInt(20) + 2);   //设置分母是2到20之间的随机数
                        int z = t.getNumerator();   //将r的分子赋值给zi
                        int m = t.getDenominator();   //将r的分母赋值给mu
                        if (j <= a) {
                            Symbol k = new Symbol();  //声明类transform的对象k
                            char q = k.Symbol();   //产生一个运算符q
                            Question = Question + z + '/' + m + " " + q + " ";  //随机数和随机符号存入Question中
                        } else {
                            Question = Question + z + '/' + m;    //随机数存入Question1中
                        }
                    }
                }
                Question = Question + "=";
                pw1.write(Question + "\r\n");
                pw1.flush();
                pw2.write("答案" + i + "\r\t");
                pw2.flush();
                if (w % 2 == 0) {   //当不生成分数时
                    operation t = new operation();  //声明类operation的对象t
                    int answer = (int)t.calrp(t.getrp(Question));  //计算正确答案answer
                    pw2.write(String.valueOf(answer)+"\r\n");
                    pw2.flush();
                } else if (w % 2 == 1) {    //当生成分数时
                    Stack evaluator = new Stack();    //声明的对象Stack;
                    operation l = new operation();  //声明类operation的对象l
                    String Question1 = l.fenshurp(Question);   //将Question1由中缀式改成后缀式
                    String answer = "";   //代表正确答案answer
                    answer = answer + evaluator.evaluate(Question1);
                    pw2.write(answer+"\r\n");
                    pw2.flush();
                }
            }
            pw1.close();
            pw2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




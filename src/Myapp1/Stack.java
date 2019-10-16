package Myapp1;

import java.util.*;

public class Stack {
    private final char MUL = '*';
    private final char DIV = '÷';
    private final char ADD = '+';
    private final char SUB = '-';
   

    private java.util.Stack<String> stack;//存放符号数的栈
    private transform  operation1, operation2;   

    public Stack()   {
        stack = new java.util.Stack<String>();
    }

    public String evaluate (String expr)
    {
        String r1, r2, result = null;
        String token;
        StringTokenizer tokenizer = new StringTokenizer (expr);  //划分表达式
        while (tokenizer.hasMoreTokens())
        {
            token = tokenizer.nextToken();//将算数表达式分解

            if (isOperator(token))
            {
                r2 = stack.pop();
               operation2=tranIntotransform(r2);
                r1 = stack.pop();
               operation1=tranIntotransform(r1);
                result = evalSingleOp (token.charAt(0),operation1,operation2);
                result= stack.push (result);//将计算结果压栈
            }
            else {
                stack.push (token);//操作数入栈
            }

        }

        return result;//输出结果
    }

    private boolean isOperator (String token)//判断是否为运算符
    {
        return ( token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("÷") );
    }

    private String evalSingleOp (char operation, transform operation1, transform operation2)   //分数运算
    {
        transform result=new transform();
        result.Numberator(0);
        result.denominator(1);
        switch (operation)
        {
            case ADD:
                result = operation1.add(operation2);
                break;
            case SUB:
                result = operation1.sub(operation2);
                break;
            case MUL:
                result = operation1.muti(operation2);
                break;
            case DIV:
                result = operation1.div(operation2);
                break;
            default:
                System.out.println("Error!");
        }
        return result.toString();
    }


    public transform tranIntotransform (String s){   //将String类型转换成transform类型
        transform r = new transform();
        String token1, token2;
        StringTokenizer tokenizer1 = new StringTokenizer(s, "/");//把操作数以"/"为标记分割开来
        token1 = tokenizer1.nextToken();    //分子
        if (tokenizer1.hasMoreTokens()) {//如果有第二个元素就把token1放在分子的位置，token2放在分母的位置
            token2 = tokenizer1.nextToken();    //分母

            r.Numberator(Integer.parseInt(token1));   //设置分子
            r.denominator(Integer.parseInt(token2));   //设置分母
        }
        else {//如果没有第二个元素就把token1放在分子的位置，分母固定为1
            r.Numberator(Integer.parseInt(token1));
            r.denominator(1);
        }
        return r;
    }
}

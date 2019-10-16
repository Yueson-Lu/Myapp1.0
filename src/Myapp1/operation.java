package Myapp1;

import java.util.Stack;

public class operation {
    static java.util.Stack<Character> op = new java.util.Stack<>();           //后缀式的值
    public static float calrp(String hs){
        java.util.Stack<Float> v = new Stack<>();
        char[] arr = hs.toCharArray();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            Character character = arr[i];     // 如果是操作数，放到堆栈
            if(character >= '0' && character <= '9')
                v.push(Float.valueOf(character - '0'));
            else v.push(get(character, v.pop(), v.pop()));
        }
        return v.pop();       //返回值return：表达式结果
    }

    //将中缀式转换为后缀式

    public static String getrp(String zs){//参数s：中缀形式的字符串
        char[] arr = zs.toCharArray();
        int len = arr.length;
        String out = "";

        for(int i = 0; i < len; i++){   //从左到右扫描中缀式
            char ch = arr[i];
            if(ch == ' ') continue;
            if(ch >= '0' && ch <= '9') {// 如果是操作数，则直接输出
                out+=ch;
                continue;
            }

            if(ch == '+' || ch == '-'){//如果遇到“+”或“-”，则从堆栈中弹出运算符，直到遇到“（”，然后输出，并进栈。
                while(!op.empty() && (op.peek() != '('))
                    out+=op.pop();
                op.push(ch);
                continue;
            }


            if(ch == '*' || ch == '÷'){//如果是“*”或“÷”，则退栈并输出，直到优先级较低或“（”将运算符进栈
                while(!op.empty() && (op.peek() == '*' || op.peek() == '÷'))
                    out+=op.pop();
                op.push(ch);
                continue;
            }

            if(ch == '(') op.push(ch);//如果遇到“（”，则直接进栈



            if(ch == ')'){ //如果遇到“）”一直退栈输出，直到退到“（”，弹出“（”
                while(!op.empty() && op.peek() != '(')
                    out += op.pop();
                op.pop();
                continue;
            }
        }
        while(!op.empty()) out += op.pop();
        return out;//返回值return：后缀形式的字符串
    }




    public static Float get(char op, Float f1, Float f2){
        if(op == '+') {

            return f2 + f1;
        }
        else if(op == '-') return f2 - f1;
        else if(op  == '*') return f2 * f1;
        else if(op == '÷') return f2 / f1;
        else return Float.valueOf(-0);
    }



    //将含有分数的中缀式转换为后缀式

    public static String fenshurp(String s){//参数s：中缀形式的字符串
        char[] arr = s.toCharArray();
        int len = arr.length;
        String out = "";

        for(int i = 0; i < len-2; i++){   //从左到右扫描中缀式
            char ch = arr[i];
            char ch1= arr[i+1];
            char ch2=arr[i+2];
            if(ch == ' ') continue;
            if(ch >= '0' && ch <= '9' && ch1 == '/'&&ch2>='0'&&ch2<='9') {// 如果是分数，则直接输出
                out+=ch;
                out+=ch1;
                out+=ch2;
                out+=" ";
                continue;
            }

            if(ch == '+' || ch == '-'){//如果遇到“+”或“-”，则从堆栈中弹出运算符，直到遇到“（”，然后输出，并进栈。
                while(!op.empty() && (op.peek() != '('))
                    out+=op.pop()+" ";
                op.push(ch);
                continue;
            }


            if(ch == '*' || ch == '÷'){//如果是“*”或“÷”，则退栈并输出，直到优先级较低或“（”将运算符进栈
                while(!op.empty() && (op.peek() == '*' || op.peek() == '÷'))
                    out+=op.pop()+" ";
                op.push(ch);
                continue;
            }

            if(ch == '(') op.push(ch);//如果遇到“（”，则直接进栈



            if(ch == ')'){ //如果遇到“）”一直退栈输出，直到退到“（”，弹出“（”
                while(!op.empty() && op.peek() != '(')
                    out += op.pop();
                op.pop();
                continue;
            }
        }
        while(!op.empty()) out += op.pop();
        return out;//返回值return：后缀形式的字符串
    }

}

package Myapp1;

import java.util.Random;

public class Symbol {//生成运算符号
    char S=' ';
    char Symbol() {
        Random random = new Random();
        int symbol = random.nextInt(4) + 1;//生成1到4的数字，平均分到四个运算符
switch (symbol) {
    case 1:
        S = '+';
        break;
    case 2:
        S = '-';
        break;
    case 3:
        S = '*';
        break;
    case 4:
        S = '÷';
        break;
    default:
        System.out.println("Symbol类，符号设置出错");
        break;
}
        return S;
    }
}

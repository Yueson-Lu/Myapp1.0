package Myapp1;

public class transform {
    int numerator=1;//分子初始化
    int denominator=1;//分母初始化
    void Numberator(int a){//分子处理
        int c = gcd(Math.abs(a), denominator);//计算最大公约数
        numerator = a / c;
        denominator = denominator / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    void denominator(int b) {//分母处理
        int c = gcd(numerator, Math.abs(b));//计算最大公约数
        numerator = numerator / c;
        denominator = b / c;
        if (numerator < 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        } else if (numerator > 0 && denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
    }
    int gcd(int a, int b) {
        //求a,b的最大公约数，辗转相除法
        if (a == 0) {
            return 1;//如果a=0,整个分数为0，设置分母为1
        }
        if (a < b) {//如果分子小于分母,交换
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b;
        while (r != 0) {
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
    int getNumerator() {   //传递分子
        return numerator;
    }

    int getDenominator() {    //传递分母
        return denominator;
    }
    transform add(transform r) {//加法运算
        int a = r.getNumerator();//分子
        int b = r.getDenominator();//分母
        int newNumerator = numerator * b + denominator * a;//计算出新分子
        int newDenominator = denominator * b;//计算出新分母
        transform result = new transform();
        result.Numberator(newNumerator);
        result.denominator(newDenominator);
        return result;
    }

    transform sub(transform r) {//减法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * b - denominator * a;
        int newDenominator = denominator * b;
        transform result = new transform();
        result.Numberator(newNumerator);
        result.denominator(newDenominator);
        return result;
    }

    transform muti(transform r) {//乘法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        int newNumerator = numerator * a;
        int newDenominator = denominator * b;
        transform result = new transform();
        result.Numberator(newNumerator);
        result.denominator(newDenominator);
        return result;
    }

    transform div(transform r) {//除法运算
        int a = r.getNumerator();
        int b = r.getDenominator();
        transform result = new transform();
        if (a == 0) {
            System.out.println("分母不能为0");
            result.Numberator(0);
            System.exit(0);
        } else {
            int newNumerator = numerator * b;
            int newDenominator = denominator * a;
            result.Numberator(newNumerator);
            result.denominator(newDenominator);
        }
        return result;
    }

    public String toString ()    //输出计算结果
    {
        String result;

        if (numerator == 0) {
            result = "0";
        }
        else {
            if (denominator == 1)
                result = numerator + "";
            else
                result = numerator + "/" + denominator;
        }
        return result;
    }


}

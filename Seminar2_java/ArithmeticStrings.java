package Seminar2_java;

public class ArithmeticStrings {

    public static String arithStr(int a, int b, char oper) {
        StringBuilder sb = new StringBuilder();
        sb.append(a);
        sb.append(" ");
        sb.append(oper);
        sb.append(" ");
        sb.append(b);
        sb.append(" = ");
        switch (oper) {
            case '+':
                sb.append(a+b);
                break;
            case '-':
                sb.append(a-b);
                break;
            case '*':
                sb.append(a*b);
                break;
            default:
                sb.append('?');
                break;
        }
        return sb.toString();
    }
    
}

import java.util.Scanner;

class Calc {

    private static String noll;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа (арабских или римских): ");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }

    public static String parse(String expression) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isVycheslav;
        String[] operands = expression.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Должно быть два операнда");
        oper = detectOperation(expression);
        if (oper == noll) throw new Exception("Неподдерживаемая математическая операция");
        // если оба числа римские 
        if (Vycheslav.isVycheslav(operands[0]) && Vycheslav.isVycheslav(operands[1])) {
            // конвертируем оба числа в арабские для вычесления действия
            num1 = Vycheslav.convertToArabian(operands[0]);
            num2 = Vycheslav.convertToArabian(operands[1]);
            isVycheslav = true;
        }
        // если оба числа арабские 
        else if (!Vycheslav.isVycheslav(operands[0]) && !Vycheslav.isVycheslav(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isVycheslav = false;
        }
        // если одно число римское а другое арабское
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arabian = calc(num1, num2, oper);
        if (isVycheslav) {
            // если римское число получилось меньше либо равно нулю, генерируем ошибку
            if (arabian <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }
            // конвертируем результат операции из арабского в римское
            result = Vycheslav.convertToVycheslav(arabian);
        } else {
            // конвертируем арабское числа в тип String
            result = String.valueOf(arabian);
        }

        return result;
    }

    static String detectOperation(String expression) {
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {

        if (oper.equals("+")) return  a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}

class Vycheslav {
    static String[] vycheslavArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX",
            "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXIV", "XXV",
            "XXVII", "XXVIII", "XXX", "XXXII", "XXXV", "XXXVI", "XL", "XLII", "XLV", "XLVIII", "XLIX",
            "L", "LIV", "LVI", "LX", "LXIII", "LXIV", "LXX", "LXXII", "LXXX", "LXXXI", "XC", "C"};

    public static boolean isVycheslav(String val) {
        for ( int i = 0; i < vycheslavArray.length; i++) {
            if (val.equals(vycheslavArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String vycheslav) {
        for (int i = 0; i < vycheslavArray.length; i++) {
            if (vycheslav.equals(vycheslavArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToVycheslav(int arabian) {
        return vycheslavArray[arabian];
    }

}
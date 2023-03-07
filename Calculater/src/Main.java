import java.util.Scanner;
public class Main {


    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите два числа (арабских(-10--10) или римских(I--X) для выполнения" + " арифметических операций типа (+, -, *, /) ");
        String input = scanner.nextLine();
        System.out.print(calc(input));
    }

    public static String calc(String input) throws Exception {
       int x;
       int y;
       int exc1 = 1;
       int exc2 = 1;
       String oper;
       String result;
       boolean methRoman;
       input= input.replace(" ", "");

        String[] operands = input.split("[+\\-*/]");

        for(int i =0; i < Checking.checkArray.length; i++){

            if (operands.length != 2) {

                throw new Exception("Введено больше (меньше) 2-ух операндов и (или) операция не поддерживается программой");


            }else if (operands[0].equals(Checking.checkArray[i])) {

                exc1=1 + 1;

            }
        }
        for(int i =0; i < Checking.checkArray.length; i++){
            if (operands[1].equals(Checking.checkArray[i])) {

                exc2 = 1 + 1;


                break;
            }
        }
        if(exc1 == 1){
            throw new Exception("Недопустимая операция или значения чисел превышают допустимые");
        }

        if(exc2 == 1){
            throw new Exception("Недопустимая операция или значения чисел превышают допустимые");
        }

        oper = Operations.detectOperation(input);
        if (oper == null) throw new Exception("Неподдерживаемая математическая операция");
        //если оба числа римские
        if (Roman.methRoman(operands[0]) && Roman.methRoman(operands[1])) {
            //конвертируем оба числа в арабские для вычесления действия
             x= Roman.convertInArabic(operands[0]);
             y = Roman.convertInArabic(operands[1]);
             methRoman = true;
        } else if (!Roman.methRoman(operands[0]) && !Roman.methRoman(operands[1])) {
             x = Integer.parseInt(operands[0]);
             y = Integer.parseInt(operands[1]);
            methRoman = false;
        } else {
            throw new Exception("Числа должны быть в одной системе счисления");
        }
        if (x > 10 || y > 10) {
            throw new Exception("Числа должны быть от 1 до 10");

        }
        int arab = Operations.calc(x, y, oper);
        if (methRoman){
            if(arab <= 0){
                throw new Exception("Введите римское число, больше 0");
            }

            result = Roman.convertInRoman(arab) ;
        } else{
            result = String.valueOf(arab);
        }
        return result;

    }
static class Operations {
    static String detectOperation(String input) {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }

    static int calc(int a, int b, String oper) {
        return switch (oper) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> a / b;
        };
    }
   }
    static class Roman{
        static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI",
                "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
                "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
                "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI",
                "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII",
                "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII",
                "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI",
                "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCII", "XCVIII", "ХCIХ", "C"
                };

        public static boolean methRoman(String value) {
            for (String s : romanArray) {
                if (value.equals(s)) {
                    return true;
                }
            }
            return false;
        }
                public static int convertInArabic(String  roman){
                    for(int i = 0; i<romanArray.length; i++){
                        if (roman.equals(romanArray[i])){
                            return i;
                        }
                    }
                    return -1;
                }

        public static String convertInRoman(int arab) {
            return romanArray[arab];
        }
    }

}
class Checking{
    static String[] checkArray = new String[] {"-10", "-9", "-8", "-7", "-6", "-5", "-4", "-3", "-2",
            "-1", "0","1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "I", "II", "III", "IV",
            "V", "VI", "VII", "VIII", "IX", "X"};
}
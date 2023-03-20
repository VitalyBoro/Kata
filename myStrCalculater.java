import java.util.Scanner;
import java.lang.String;
 class myStrCalculater {
     public static void main(String[] args) throws Exception {
         Scanner scan = new Scanner(System.in);
         String exp = scan.nextLine();
         char sign;
         String[] data;

             if (exp.contains(" + ")) {
             data = exp.split(" \\+ ");
             checkingFirstStr.firstStr(data);
             sign = '+';
         } else if (exp.contains(" - ")) {
             data = exp.split(" - ");
             checkingFirstStr.firstStr(data);
             sign = '-';
         } else if (exp.contains(" * ")) {
             data = exp.split(" \\* ");
             checkingFirstStr.firstStr(data);
             sign = '*';
         } else if (exp.contains(" / ")) {
             data = exp.split(" / ");
             checkingFirstStr.firstStr(data);
             sign = '/';
         }else{
             throw new Exception("Некорректный знак действия");
         }
         if (sign == '*' || sign == '/') {
             if (data[1].contains("\"")) {
                 throw new Exception("Строчку можно делить или умножать только на число");
             }else if(!data[1].contains("\"")){
                 int ten = Integer.parseInt(data[1]);
                 if(ten > 10 || ten < 1){
                     throw new Exception("Допустимое значение множителя от 1 - 10.");
                 }
             }
         }
         for (int i = 0; i < data.length; i++) {
             data[i] = data[i].replace("\"", "");
         }

         if (sign == '+') {
             quotes.printInQuotes(data[0] + data[1]);
         } else if (sign == '*') {
             int multiplier = Integer.parseInt(data[1]);
             String result = "";
             for (int i = 0; i < multiplier; i++) {
                 result+=data[0];
             }if(result.length() > 40){
                 quotes.printInQuotes(result.substring(0,40) + "...");
             } else quotes.printInQuotes(result);
         } else if (sign == '-') {
             int index = data[0].indexOf(data[1]);
             if(index == -1){
                 quotes.printInQuotes(data[0]);
             }else{
                 String result = data[0].substring(0, index);
                 result+=data[0].substring(index+data[1].length());
                 quotes.printInQuotes(result);
             }
         }else{
             int newLen = data[0].length()/Integer.parseInt(data[1]);
             String result = data[0].substring(0,newLen);
             quotes.printInQuotes(result);
         }


     }

 }

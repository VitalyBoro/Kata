public class checkingFirstStr {
    static String[] firstStr (String[] data) throws Exception {
        if (!data[0].contains("\"")){
        throw new Exception("Первый операнд должен быть строкой, поместите его в двойные кавычки.");
        }else if(data[0].length() > 12){
           throw new Exception("Длина строки не может превшать 10 символов");
        }
        return data;
    }
}

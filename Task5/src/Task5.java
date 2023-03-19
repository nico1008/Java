import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.*;

public class Task5 {

    public static void main(String[] args) throws ParseException {
        System.out.println("Первый номер   : "+ sameLetterPattern("ABCBA","BCDCB"));
        System.out.println("Второй номер   : "+ spiderVsFly("H3", "E2"));
        System.out.println("Третий номер   : "+ digitsCount(2365434));
        System.out.println("Четвертый номер: "+ totalPoints(new String[]{"cat","sat","create"},"caster"));
        System.out.println("Пятый номер    : "+ longestRun(new int[] {5,9,45,6,2,7,34,8,6,90,5,243}));
        System.out.println("Шестой номер   : "+ takeDownAvarage(new String[] {"95%","78%","45%","55%","91%","78%","75%"}));
        System.out.println("Седьмой номер  : "+ rearrange("is2 Th1is T4est 3a"));
        System.out.println("Восьмой номер  : "+ maxPossible(4111571,947));
        System.out.println("Девятый номер  : "+ timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra"));
        System.out.println("Десятый номер  : "+ isNew(76542));
        

    }


    public static boolean sameLetterPattern(String perv,String vtor) {
        if (perv.length() != vtor.length()){ // если длина слов не одинакова->ложно
            return false;
        }
        if (perv.length() == 1){              // если длина равна 1   ->правда
            return true;
        }
        for (int i = 1; i < perv.length(); i++) {
            if (perv.charAt(i) - perv.charAt(i - 1) != vtor.charAt(i) - vtor.charAt(i - 1)){ //если разица между символами ascii равна
                return false;
            }
        }
        return true;
    }
    public static int Get(String spi)
    {
        return spi.charAt(0) - 65 ;
    }
    public static String spiderVsFly(String spider, String fly) {
	    
        int sRad = spider.charAt(0) - 65;   // буква радиала паука      A-0 B-1 C-2 D-3 E-4 F-5 G-6 H-7
        int sRing = spider.charAt(1) - 48;  // номер кольца  паука      от 0 до 4 соотв


        int fRad = fly.charAt(0) - 65;      // буква радиала мухи
        int fRing = fly.charAt(1) - 48;     // номер кольца  мухи


        double path1 = sRing + fRing;

        double path2 = fRing * 0.765 *Math.abs( fRing - sRing) + ((sRad + fRad) % 8) ; // где 0.765 это путь от одного рад до другого по кольцу

        String otv = "";

        if (path1 <= path2) {                   // если путь до середины меньше
            for (int i = 0; i < sRing; i++) {   // продвигаемя по кольцам к центру
                otv += spider.charAt(0);
                otv += sRing - i;
                otv += '-';
            }
            otv += "A0-";                        // дошли до центра паутины

            for (int i = 0; i < fRing; i++) {  // продвигамеся по кольцам к мухе и записываем результаут
                otv += fly.charAt(0);
                otv += i + 1;
                otv += '-';
            }
        }
        else {                                                          // если продвижение по кольцам короче
            for (int i = 0; i < Math.abs(sRing - fRing); i++) {
                otv += spider.charAt(0);
                if (sRing > fRing) {
                    otv += sRing - i;          // продвижение к ближайшему кольцу по радиану
                }
                else {
                    otv += sRing + i;          // учитывая положения колец
                }
                otv += '-';
            }
            for (int i = 0; i <= (sRad + fRad) % 8; i++) {
                otv += (char)(65 + (sRad + i) % 8);   //продвижение к мухе по кольцу
                otv += fly.charAt(1);
                otv += '-';
            }
        }

        return otv;
    }

    static int count=1;                                              //счетчик
    public static int digitsCount(int number){
        if (Math.abs(number)<10){                                    //если правда, то конец рекурчии
            return count;
        }
        count++;
        return digitsCount(number/10);

    }


    public static int totalPoints(String[] words,String base){
        int points = 0;
        for (String word: words){   //для каждого элемента массива
            boolean isCorrect = true;
            String prover = base;  //словарь букв
            for (int i=0; i < word.length(); i++){
                String ch = Character.toString(word.charAt(i));//посимвольно проверяем если в алфавите есть этот символ
                if (prover.contains(ch)){
                    prover = prover.replace(ch, "");  //убираем использованный символ
                }
                else{
                    isCorrect = false;
                    break;
                }
            }
            if (isCorrect){
                points += word.length() - 2;  //подсчет очков по условию
                if (word.length() == 6){      // слово рассшифровано
                    points += 50;
                }
            }
        }
        return points;
    }
    public static int longestRun(int[] chilsa){
        if ( chilsa.length == 1){
            return 1;
        }

        int max = 1;
        int inc = 1; //для увел посл
        int dec = 1; //для уменьш посл

        for (int i = 1; i <  chilsa.length; i++){
            if (( chilsa[i] -  chilsa[i - 1]) == 1){
                inc++;
            }else
            {
                inc = 1;           //обнуление
            }
            if(( chilsa[i] -  chilsa[i - 1]) == -1){
                dec++;
            }
            else
            {
                dec = 1;            //обнуление
            }
            if (inc > max){         // cравнение увел и уменьш послед
                max = inc;
            }
            if (dec > max){
                max = dec;
            }
        }
        return max;
    }
    public static String takeDownAvarage(String[] perc){
        double sum = 0;
        double n= 0;
        double ave1;
        double ave2;
        for(String s : perc){
            s = s.replace("%", "");
            sum += Integer.parseInt(s);
            n++;
        }
        ave1 = sum / n;
        ave2 = sum / (n + 1);
        return Math.round(((0.95 *ave1) - ave2) * (n + 1)) + "%"; // просто по формуле находим процент
    }
    public static String rearrange(String str){
        String[] words = str.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.isDigit(word.charAt(i)))      //избавляемся от цифр и заполняем массив result
                {
                    result[word.charAt(i) - 49] = word.substring(0, i) + word.substring(i+1);
                    break;
                }
            }
        }
        return String.join(" ", result); // элементы массива в строку + пробел между каждым
    }
    public static String maxPossible(int a,int b ){
        int[] arr1= ToArr(a);
        int[] arr2= ToArr(b);

        for (int i = 0; i < arr2.length-1; i++){ // сорировка массива пузырьком
            for (int j = 0; j < arr2.length-i-1; j++){
                if (arr2[j] < arr2[j+1]){
                    int t=arr2[j];
                    arr2[j]=arr2[j+1];
                    arr2[j+1]=t;
                }
            }
        }
        for (int i = 0; i < arr1.length/2; i++) {  //меняю местами первый массив
            int t  = arr1[i];
            arr1[i]= arr1[arr1.length-1-i];
            arr1[arr1.length-1-i]=t;
        }
        int  j=0;
        for (int i=0;i<arr1.length && j< arr2.length;i++){  //пока есть в 2 массиве цифры больше чем в первом идет замена
            if(arr1[i]<arr2[j]){
                arr1[i]=arr2[j];
                j++;
            }
        }
        return Arrays.toString(arr1);
    }
    public static int[] ToArr(int num){                              //для создания массива цифр 8 задания
        int[] arr = new int[Integer.toString(num).length()];
        int i = 0;
        while (num > 0){
            arr[i] = num % 10;
            num /= 10;
            i++;
        }
        return arr;
    }
    static class cityTime{ // класс для создания объектов с временем  и назв города

        private String name;
        private double GMT;

        public cityTime(String name, double GMT) {
            this.GMT = GMT;
            this.name = name;
        }

        public double getGMT() {
            return GMT;
        }

        public String getName() {
            return name;
        }

    }

    public static String timeDifference(String city, String data, String newCity) throws ParseException {
        cityTime[] arr = new cityTime[11];
        data = data.replaceFirst(",", ""); // избавл от запятой
        arr[0] = new cityTime("Los Angeles", -8); // создания объектов в массиве
        arr[1] = new cityTime("New York", -5);
        arr[2] = new cityTime("Caracas", -4.5);
        arr[3] = new cityTime("Buenos Aires", -3);
        arr[4] = new cityTime("London", 0);
        arr[5] = new cityTime("Rome", 1);
        arr[6] = new cityTime("Moscow", 3);
        arr[7] = new cityTime("Tehran", 3.5);
        arr[8] = new cityTime("New Delhi", 5.5);
        arr[9] = new cityTime("Beijing", 8);
        arr[10] = new cityTime("Canberra", 10);

        double offset;
        double time1 = 0;
        double time2 = 0;
        for (int i = 0; i <= 10; i++) {
            if (arr[i].getName().equals(city)) {
                time1 = arr[i].getGMT();
            }
            if (arr[i].getName().equals(newCity)) {
                time2 = arr[i].getGMT();
            }
        }
        offset = (time2 - time1) * 3600000; // получение разницы во времени
        SimpleDateFormat parser = new SimpleDateFormat("MMMM dd yyyy HH:mm", Locale.US); // использование шаблонов для вывода времени
        Date newDate = parser.parse(data);
        newDate.setTime(newDate.getTime() + (int) offset);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-d HH:mm");   // форматирование даты по шаблону
        return formatter.format(newDate);
    }

    public static boolean isNew ( int numb){
        int tempNum = -1;                         //просто проверяем если предыдущая цифра меньше след
        while (numb > 0) {
            if (numb % 10 < tempNum) {
                return false;
            }
            tempNum = numb % 10;
            numb = numb / 10;
        }
        return true;
    }

}


import java.util.Arrays;

public class Task4 {

    public static void main(String[] args) {
            System.out.println("Первый номер   : " + sevenBoom(new int[] {5,9,45,6,2,7,34,8,6,90,5,243}));
            System.out.println("Второй номер   : " + cons(new int[] {4,6,3,5,1,2}));
            System.out.println("Третий номер   : " + unmix("hTsii  s aimex dpus rtni.g"));
            System.out.println("Четвертый номер: " + noYelling("no!! Yelling please!!! Hello???????????"));
            System.out.println("Пятый номер    :  "+ xPronounce("Inside a box was x a xylophonex xona"));
            System.out.println("Шестой номер   : " + largestGap(new int[] {5,9,45,6,2,7,34,8,6,90,5,243}));
            System.out.println("Седьмой номер  : " + myMethod(832));
            System.out.println("Восьмой номер  : " + commonLastVowel("very confusing exercise to complete"));
            System.out.println("Девятый номер  : " + memeSum(122,81));
            System.out.println("Десятый номер  : " + unrepeated("tttttiiigrrrr!!?"));
    }


        public static String sevenBoom(int[] arr) {
            boolean contains = false;
            for (int i : arr) {
                if (i == 7) {
                    contains = true;
                    break;
                }
            }
            if (contains) {
                return "Boom!";
            } else {
                return "There is no seven in the array";
            }
        }
        public static boolean cons(int[] array){
        boolean onemore = true;
        Arrays.sort(array);
            for (int i = 1; i < array.length; i++) {
                if (array[i] != array[i - 1] + 1) {
                    onemore = false;
                    break;
                }
            }
            return onemore;
        }

        public static String unmix(String sen ){
        String[] ar = sen.split("");
        String temp;
            for (int i = 1; i < ar.length; i+=2) {
                temp=ar[i-1];
                ar[i-1]=ar[i];
                ar[i]=temp;

            }
           return Arrays.toString(ar);
        }

        public static String noYelling(String sentence){
            char sym;
            if (sentence.charAt(sentence.length()-1) == '?' || sentence.charAt(sentence.length()-1) == '!'){
                sym = sentence.charAt(sentence.length()-1);
            }
            else {
                return sentence;
            }
            while(sentence.charAt(sentence.length() - 2) == sym){
                sentence = sentence.substring(0, sentence.length() - 1);
            }
            return sentence;
        }
        public static String xPronounce(String rev){
                rev = rev.replaceAll(" x ", " ecks ");
                rev = rev.replaceAll(" x", " z");
                rev = rev.replaceAll("x", "cks");
            return rev;
        }
        public static int largestGap(int[] chilsa){
        int diff=-1;
        Arrays.sort(chilsa);
            for (int i = 1; i < chilsa.length; i++) {
                if(Math.abs(Math.abs(chilsa[i])-Math.abs(chilsa[i-1]))>diff){
                    diff=Math.abs(Math.abs(chilsa[i])-Math.abs(chilsa[i-1]));
                }
            }
        return diff;
        }
        public static int myMethod(int num){
        int n = 0;
        String str = Integer.toString(num);
        int[] arr = new int[str.length()];
            for (int i = 0; i < str.length(); i++){
                arr[i] = Character.getNumericValue(str.charAt(i));
            }
        Arrays.sort(arr);
        int tens = 1;
            for (int i = arr.length - 1; i >= 0; i--){
                n = n + tens * arr[i];
                tens *= 10;
            }
        return num - n;
        }
        public static char commonLastVowel(String stroka){
            stroka = stroka.toLowerCase();
            String[] words = stroka.split(" ");
            int[] ar = new int[6];
            for(String word : words){
                char symbol = word.charAt(word.length() - 1);
                switch (symbol){
                    case'a':
                        ar[0]++;
                        break;
                    case'e':
                        ar[1]++;
                        break;
                    case'i':
                        ar[2]++;
                        break;
                    case'o':
                        ar[3]++;
                        break;
                    case'u':
                        ar[4]++;
                        break;
                    case'y':
                        ar[5]++;
                        break;
                }
            }
            int max =-1 ;
            int in = 0;
            for (int i=0;i< ar.length;i++) {
                if (ar[i]>max){
                    max=ar[i];
                    in=i;
                }
            }
            switch(in){
                case 0:
                    return 'a';
                case 1:
                    return 'e';
                case 2:
                    return 'i';
                case 3:
                    return 'o';
                case 4:
                    return 'u';
                case 5:
                    return 'y';
            }
            return '-';
        }
        public static int memeSum(int a,int b ){
        int len=Integer.toString(Math.max(a, b)).length();
        int[] array = new int[len];
        int c = 0;
        StringBuilder otvet = new StringBuilder();
        while (a > 0 || b > 0){
            array[c] = a%10 + b%10;
            b /= 10;
            a /= 10;

            c++;
        }
        for (int i = array.length - 1; i >= 0; i--){
            otvet.append(array[i]);
        }
        return Integer.parseInt(otvet.toString());
        }


        public static String unrepeated(String sent){
        sent=sent.replaceAll("((.)\\1{0})\\2+","$1");
        return sent;
        }

}

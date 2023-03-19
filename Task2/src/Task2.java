


public class Task2 {


        public static void main(String[] args) {
            System.out.println("Первый номер: " + oppositeHouse(5,46));
            System.out.println("Второй номер: " + nameShuffle("Donald Trump"));
            System.out.println("Третий номер: " + discount(999, 17));
            System.out.println("Четвертый номер: " + differenceMaxMin(new int[] {23,45,-64,46,57,100}));
            System.out.println("Пятый номер:  " + equal(0,4,4));
            System.out.println("Шестой номер: " + reverse("Hello world"));
            System.out.println("Седьмой номер: " + programmers(16,23,255));
            System.out.println("Восьмой номер: " + getXO("get XoxxoxOO paper"));
            System.out.println("Девятый номер: " + bomb("there is no boMb!"));
            System.out.println("Десятый номер: " + sameAscii("AA","B@"));
        }
    public static int oppositeHouse(int num, int n){
        return 2*n+1-num;
    }
    public static String nameShuffle(String name){
            String[] spl=name.split(" ");
        return spl[1]+" "+spl[0];
    }
    public static double discount(double price , double dis){
        return price - price*(dis/100);
    }

    public static int differenceMaxMin(int[] arr){
            int min=arr[0];
            int max=arr[0];
        for (int i=0 ;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return Math.abs(max-min);
    }
    public static int equal(int perv , int vtor,int tret){
        if (perv==vtor && perv==tret){
            return 3;
        }
        if (perv==vtor || perv==tret|| vtor==tret){
            return 2;
        }
        else return 0;
    }
    public static String reverse(String stroka){
            String rev="";
        for (int i=stroka.length()-1;i>=0;i--){
            rev+= stroka.charAt(i);
        }
        return rev;
    }
    public static int programmers(int a,int b ,int c){
            int max=a;
            int min=a;
        if (a>b && a>c) {
             max = a;
        }
        if (b>a && b>c){
             max = b;
        }
        if (c>a && c>b){
             max =c;
        }
        if (a<b && a<c) {
             min = a;
        }
        if (b<a && b<c){
             min = b;
        }
        if(c<a && c<b) {
             min =c;
        }
        return max-min;
    }
    public static boolean getXO(String str){
            int CountX=0;
            int CountO=0;
        for (int i=0; i<=str.length()-1;i++) {
            if (str.charAt(i)=='x'||str.charAt(i)=='X')
            CountX+=1;
        }
        for (int i=0; i<=str.length()-1;i++) {
            if (str.charAt(i)=='o'||str.charAt(i)=='O')
                CountO+=1;
        }
        return CountO==CountX;
    }
    public static String bomb(String stro){
        stro=stro.toLowerCase();
        if( stro.contains("bomb")){
            return "DUCK!";
        }
        else return "Relax, there is no bomb.";
    }
    public static boolean sameAscii(String s,String ss){
           return s.chars().sum()==ss.chars().sum();
    }

}

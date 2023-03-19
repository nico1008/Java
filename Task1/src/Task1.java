public class Task1 {

    public static void main(String[] args) {
        System.out.println("Первый номер: "+ convert(13));                                      //1
        System.out.println("Второй номер: "+points(17,6));                               //2
        System.out.println("Третий номер: "+soccerPoints(4,1,13));                //3
        System.out.println("Четвертый номер: "+divisibleByFive(25));                        //4
        System.out.println("Пятый номер:  "+ and(true,false));                         //5
        System.out.println("Шестой номер: "+howManyWalls(255,6,4));                    //6
        System.out.println("Седьмой номер: "+squared(16));                                  //7
        System.out.println("Восьмой номер: "+profit(0.2,50,9));                  //8
        System.out.println("Девятый номер: "+frames(10,25));                         //9
        System.out.println("Десятый номер: "+mod(218,-5));                                 //10

    }


    public static int convert(int con){
        return con*60;
    }
    public static int points(int b,int c){
        return b*2+c*3;
    }
    public static int soccerPoints(int win , int tie, int lose){
        return win*3+ tie +lose*0;
    }
    public static boolean divisibleByFive(int r){
        return r % 5 == 0;
    }
    public static boolean and(boolean perv , boolean vtor){
        return perv&&vtor;
    }
    public static int howManyWalls(int n, int w, int h){
        return n/(w*h);
    }
    public static int squared(int a){
        return a*a;
    }
    public static boolean profit(double prob,double prize, double pay){
        return prob*prize-pay>0;
    }
    public static int frames(int numb,int min){
        return numb*min*60;
    }
    public static int mod(int x,int m){
        x=Math.abs(x);
        m=Math.abs(m);
        while (x>= m) {
           x=x-m;
        }
        return x;
    }
}

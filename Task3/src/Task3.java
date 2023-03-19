import java.util.Arrays;

 class City{
    private String city;
    private int population;

    public City(String city, int population) {
        this.city = city;
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public int getPopulation() {
        return population;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
public class Task3 {

        public static void main(String[] args) {
            System.out.println("Первый номер   : " );
            num1();
            System.out.println("Второй номер   : " + Arrays.toString(otherSides(12.974)));
            System.out.println("Третий номер   : " + rps("scissors","paper"));
            System.out.println("Четвертый номер: " + warOfNumbers(new int[] {5,9,45,6,2,7,34,8,6,90,5,243}));
            System.out.println("Пятый номер    :  " + reverseCase("Happy New Year"));
            System.out.println("Шестой номер   : " + inatorInator("penguin"));
            System.out.println("Седьмой номер  : " + doesBrickFit(1,2,1,1,1));
            System.out.println("Восьмой номер  : " + totalDistance(36.1,8.6,3,true));
            System.out.println("Девятый номер  : " + mean(new int[] {2,3,2,3,2,3}));
            System.out.println("Десятый номер  : " + parityAnalysis(243));
        }

        public static void num1(){
            City[] cityArr = millionsRounding(new City[]{new City("Nice", 942208), new City("Abu Dhabi", 1482816), new City("Naples", 2186853), new City("Vatican City", 572)});
            for (City cities : cityArr   ) {
                System.out.println(cities.getCity() + " " + cities.getPopulation());
            }
        }
         public static City[] millionsRounding(City[] arr){
            for (City cities : arr) {
                cities.setPopulation(((int) (Math.round(((double) cities.getPopulation()) / 1000000))) * 1000000);
            }
        return arr;
        }
        public static double[] otherSides(double side){
            double[] other= {0.0,0.0};
            other[0]=Math.round(side*2 * 100.0) / 100.0;
            other[1]=Math.round(side* Math.pow(side,1.0/3.0)*100.0)/100.0;
            return other;
        }
        public static String rps(String fir , String sec){
            if (fir.equals("rock") && sec.equals("rock") || fir.equals("paper") && sec.equals("paper") || fir.equals("scissors") && sec.equals("scissors")) {
                return "TIE";
            }
            if (fir.equals("rock") && sec.equals("scissors") || fir.equals("paper") && sec.equals("rock") || fir.equals("scissors") && sec.equals("paper")){
                return "Player 1 wins";
            }
            else return "Player 2 wins";
        }

        public static int warOfNumbers(int[] arr){
            int maxEven=0;
            int maxOdd=0;
            for (int j : arr) {
                if (j % 2 == 0) {
                    maxEven += j;
                } else {
                    maxOdd += j;
                }
            }
            return Math.abs(maxEven-maxOdd);
        }
        public static String reverseCase(String rev){
            char[] revChar=rev.toCharArray();
            for( int i =0;i<revChar.length;i++)
            if ( Character.isLowerCase( revChar[i])){
                revChar[i]= Character.toUpperCase(revChar[i]);
            }
            else {
                revChar[i]= Character.toLowerCase(revChar[i]);
            }
            return String.valueOf(revChar);
        }
        public static String inatorInator(String stroka){
            int len =stroka.length();
            switch (stroka.charAt(stroka.length()-1)){
                case 'a':
                case 'i':
                case 'e':
                case 'o':
                case 'u': stroka=stroka.concat("-inator");
                break;
                default:  stroka=stroka.concat("inator");
            }
            return stroka.concat(" " +len+"000");
        }
        public static boolean doesBrickFit(int a,int b ,int c,int width,int hight){
            
                return a<=width && b<=hight || b<=width && a<=hight || b<=width && c <=hight || c<=width && b<=hight || a<=width && c<=hight || c<=width && a<=hight;
           
        }
        public static double totalDistance(double capacity, double usage, int people, boolean fan){
            int cooler=0;
            if (fan){
                cooler=1;
            }
            return capacity/((usage+usage*people*0.05)*(1+cooler*0.1))*100;
        }
        public static double mean(int[] numbers){
            double sum=0;
            for (int i : numbers) {
                sum+=numbers[i];
            }
            return sum/numbers.length;
        }
        public static boolean parityAnalysis(int num){
            int sum =0;
            int numH=num;
            while(num>0){
                sum+=num %10;
                num=num/10;
            }
                return (numH-sum)%2==0;
            }

}

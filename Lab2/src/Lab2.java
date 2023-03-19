public class Lab2 {
    public static void main(String[] args) {

        args= new String[]{"7.1","1.2","3.1","1.4","7.5","3.0","1.2","2.6","7.7"};

        Point3d point1 = new Point3d();  // создание трех объектов
        Point3d point2 = new Point3d();
        Point3d point3 = new Point3d();

        point1.setX(Double.parseDouble(args[0]));    // преобразовываем строковые переменные в веществыенные
        point1.setY(Double.parseDouble(args[1]));
        point1.setZ(Double.parseDouble(args[2]));    // для первой точки

        point2.setX(Double.parseDouble(args[3]));    // для второй точки
        point2.setY(Double.parseDouble(args[4]));
        point2.setZ(Double.parseDouble(args[5]));

        point3.setX(Double.parseDouble(args[6]));    //для третей точки
        point3.setY(Double.parseDouble(args[7]));
        point3.setZ(Double.parseDouble(args[8]));

        System.out.println(point2.getY());           // получение любой координаты
        System.out.println(point1.getZ());
        System.out.print("Площадь треугольника: ");
        System.out.println(computeArea(point1,point2,point3)); // нахождение площади

    }
    public static double computeArea(Point3d p1, Point3d p2, Point3d p3){

        if (p1.ravno(p2) || p2.ravno(p3)||p3.ravno(p1)) {
            System.err.println("координаты точек равны");  // вывод сообщения о ошибке
            System.exit(1);                         // конец работы программы , если координаты точек равны
        }
        double a = p1.distanceTo(p2);                     //нахождение расстояния от 1 до 2
        double b = p2.distanceTo(p3);                     //нахождение расстояния от 2 до 3
        double c = p1.distanceTo(p3);                     //нахождение расстояния от 1 до 3
        double PoluPer = (a + b + c)/2;                   //нахождение полупериметра
        return Math.sqrt(PoluPer*(PoluPer-a)*(PoluPer-b)*(PoluPer-c)); // использование теоремы Герона
    }
}

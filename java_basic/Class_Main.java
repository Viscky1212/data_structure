package java_basic;

public class Class_Main {

   static  {
        System.out.println("Vikrant Saini");
    }

     {
        System.out.println("Vikrant Saini  from object");
    }


    public static void main(int[] arr ) {
        for(int a : arr){
            System.out.println(a);
        }

    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        Class_Main cm =new Class_Main();
        main(arr);
        System.out.println("from string main");
    }



}

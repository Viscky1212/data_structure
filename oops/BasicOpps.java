package oops;

public class BasicOpps {
    int add(int a , int b){
       int c = a + b;
       return c;
    }


    public static void main(String[] args) {
        BasicOpps bo = new BasicOpps();
        int add = bo.add(1, 2);
        System.out.println(add);


    }
}

package oops.collection_dsa.list;

import java.util.ArrayList;

public class ArrayAllForm {

    public int   arrayListForm2(){
        ArrayList al2 = new ArrayList();
        //number array
        al2.add(1);
        al2.add(2);
        al2.add(3);
        al2.add(4);
        al2.add(5);
        al2.add(6);
        al2.add(7);
        al2.add(8);
        al2.add(9);
        al2.add(10);
        System.out.println(al2);
        return 0;
    }

    public String arrayListForm(){
        ArrayList al = new ArrayList();

        System.out.println(al.add("Hello"));
        System.out.println(al.add("World"));
        System.out.println(al);



        //occurance of duplicate
        //occurance of Character
        //acsending order
        //decending order
        //Remove duplicate
        //Reverse the array
        //Find the largest and smallest element in the array
        //Find the second largest and second smallest element in the array
        //swap from kth position
        //Find the common elements in two arrays
        //Find the union and intersection of two arrays
        //Find the missing number in an array of 1 to n
        //Find the pair of elements in an array whose sum is equal to a given number
        //Find the subarray with the given sum
        //Find the longest subarray with the given sum

        return "";
    }

        public static void main(String[] args) {
            ArrayAllForm aaf = new ArrayAllForm();
            aaf.arrayListForm();
            aaf.arrayListForm2();
        }
}

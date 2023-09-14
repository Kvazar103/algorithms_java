package Algorithm_to_find_minimum_element_in_array;

public class Main {
    public static void main(String[] args) {
        int[] array=new int[] {64,12,14,29,80,20,57,19,10,105,78};

        int minElement=array[0];
        int minIndex=0;

        for (int i = 1; i <array.length ; i++) {
            if(array[i]<minElement){
                minElement=array[i];
                minIndex=i;
            }
        }
        System.out.println("Min value: "+minElement);
        System.out.println("Index of min value: "+minIndex);

    }
}

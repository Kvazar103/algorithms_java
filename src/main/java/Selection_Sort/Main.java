package Selection_Sort;

import java.util.Arrays;

//slection sort(Сортування вибором)- Спочатку знаходимо мінімальний елемент в масиві а тоді міняємо його місцями
// з першим елементом
public class Main {
    public static void main(String[] args) {
        int[] array=new int[] {64,12,14,29,80,20,57,19,10,105,78};

        for(int step=0;step<array.length;step++){
            int index=min(array,step);
            System.out.println(Arrays.toString(array));

            int temp=array[step];
            array[step]=array[index];
            array[index]=temp;
        }
    }
    public static int min(int[] array,int startIndex){
        int minIndex=startIndex;
        int minElement=array[startIndex];

        for(int i=startIndex+1;i<array.length;i++){
            if(minElement>array[i]){
                minElement=array[i];
                minIndex=i;
            }
        }
        return minIndex;
    }

//    public static String arrayToString(int[] array){
//        StringBuilder stringArray=new StringBuilder();
//
//        stringArray.append("[");
//
//        for(int i=0;i<array.length;i++){
//            stringArray.append(array[i]);
//            if(i+1==array.length){
//                stringArray.append("]");
//            }else{
//                stringArray.append(",");
//            }
//        }
//        return stringArray.toString();
//    }


}

package Quick_Sort;

import java.util.Arrays;
//Quick Sort - набагато швидша й ефективніша ніж, наприклад Bubble Sort, але якщо у нас вже є відсортований масив
// тоді Bubble Sort буде швидшем оскільки він вже не буде перебирати, а Quick Sort все одно буде розділяти і.т.д
//Допустим якщо у нас є масив який вже майже відсортований то кращим варіантом буде використанням Bubble Sort
//Тому слід думати який краще алгоритм застосувати
public class Main {
    public static void main(String[] args) {
        int[] array=new int[] {64,12,14,29,80,20,57,19,10,105,78};

        quickSort(array,0,array.length-1);//при запуску сортування це весь масив(від першого до останнього елемента)
//        System.out.println(Arrays.toString(array));
    }
    private static void quickSort(int[] arr,int from,int to){//приймає масив і границі його де буде йти сорутвання
        if(from<to){//перевіряє чи є що сортувати інакше виходить що в масиві лише один елемент і сортувати його не треба
            int divideIndex=partition(arr,from,to);//тут йде розділення, вибирається опорний елемент, всі елементи які менші його
           //в правій частині переміщаються в ліву чатсину а із лівої частини всі елементи які більші опорного переміщаються в праву частину масива
            //метод partition повертає індекс елемента по якому йде розділення (розділяє праві і ліву частину)
            printSortStep(arr,from,to,divideIndex);

            quickSort(arr,from,divideIndex-1);//функція сортування рекурсивно викликає сама себе для отриманих підмасивів
            quickSort(arr,divideIndex,to);

        }
    }
    private static int partition(int[] arr,int from, int to){ // розділення масива на два підмасива
        int rightIndex=to;// ця ставиться на кінець масива
        int leftIndex=from;//ця ставиться на початок масива

        int pivot=arr[from+(to-from)/2];//вибираємо опорний елемент(в нашому випадку це середній елемент) (можна вибрати любий але перший краще не вибирати)
        while(leftIndex<=rightIndex){
            while(arr[leftIndex]<pivot){
                leftIndex++;//починаємо рух масиву від початку до кінця
                //до тих пір поки не найдемо в лівій частині масиву елемент який буде більше опорного
            }
            while(arr[rightIndex]>pivot){//тоді починає рухатися правий індекс з кінця масиву до початку,
                // шукається елемент який буде менший опорного
                rightIndex--;
            }
            //після того як знайшли елемент в лівій частині який більший опорного а другий в правій і менше опорного
            // тоді вони синхронно міняються місцями
            if(leftIndex<=rightIndex){
                swap(arr,rightIndex,leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }
    private static void swap(int[] array,int index1,int index2){ //метод для обміну двох елементів масиву місцями
        int temp=array[index1];
        array[index1]=array[index2];
        array[index2]=temp;
    }
    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(Arrays.toString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + Arrays.toString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + Arrays.toString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
}

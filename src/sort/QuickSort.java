package sort;

import java.util.Random;

public class QuickSort {

    /**
     * 快排的关键是通过partition(分段），找到一个枢纽，
     * 通过一系列交换的操作，比如将枢纽放在头或尾部，
     * 将这段变为枢纽左都比枢纽小，反之亦然。然后返回枢纽，
     * 之所以随即找枢纽，是为了避免这是一个已经排序好的数，
     * 造成速度最慢，每次分段只会减1.
     * 然后会不停地将数组分段，也就是quickSort中，定义高低指针，
     * 指导数组长度为1为止。当所有数组都被这样排序过，快速排序完成，速度为O（nLogn)
     * @param args
     */

    public static void main(String[] args) {
        // 定义一个待排序的数组
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        // 对数组进行快速排序
        quickSort(arr, 0, n-1);
        // 打印排序后的数组
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        // 如果 low 小于 high，则表明子数组至少有两个元素，到数组里只有一个元素未知
        if(high>low){
            //在数组中随机获得一个中枢，获取它的索引
            int pivotIndex = partition(arr,low,high);
            //分别对枢纽作测和右侧进行快排，不用带上枢纽
            quickSort(arr,low,pivotIndex-1);
            quickSort(arr,pivotIndex+1,high);
        }
    }

    //每个段落分组
    public static int partition(int[] arr, int low, int high){
        //在high和low之间生成一个随机数
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high-low)+low;

        //将pivot移动到末尾
        swap(arr,pivotIndex,high);

        //然后从low到high遍历
        int i = low;
        for(int j = low; j < high; j++){
            //如果当前元素小于等于枢轴元素
            if(arr[j]<arr[high]){
                //则将当前i元素和i交换，然后i++
                swap(arr,i,j);
                i++;
            }
        }
        //可不能少了这一步，这样才可以让这段中，pivot左侧都比它小，右侧都比它大
        swap(arr,i,high);
        return i;
    }

    //交换数组
    public static void swap(int[] arr, int i, int j){
        //交换arr[i]和arr[j]
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

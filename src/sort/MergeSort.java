package sort;

public class MergeSort {

    /**
     * 递归排序是将先将数组从中间开始分段，直到分为长度为1的数组为止，
     * 这一步是mergeSort，进行分割，然后用merge进行合并，
     * 有一个mid参数来分割两边。这样递归一层一层下来，
     * 就可以得到完整的排序，不过有个问题，
     * 每次都会创建一个temp数组保存临时的排序，会造成空间一定是O（n)
     */
    public static void main(String[] args) {
        // 定义一个待排序的数组
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;
        // 对数组进行快速排序
        mergeSort(arr,0,n-1);
        // 打印排序后的数组
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //这一步是分割，通过递归不停地分割
    public static void mergeSort(int[] arr, int left, int right){
        if (left >= right){
            return; //当数组长度为1时，自动退出
        }

        //分解,一直分到长度为1未知
        int mid = left+(right-left)/2;
        mergeSort(arr,left,mid);
        mergeSort(arr,mid+1,right);

        //合并
        merge(arr,left,mid,right);
    }

    //合并，将两个有序的子区间合并为一个有序的区间，根据Mid来区分
    public static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right-left+1]; //一个临时的数组，负责保存这个有序的新数组
        int i = left, j = mid +1, k = 0; //i和j分别代表两个数组的开头，k代表合并数组

        //将两个有序数组合并到temp，过程很简单，就是互相比
        while(i<=mid && j <=right){
            if(array[i]<=array[j]){
                //arr[i]更小就先把arr放进去
                temp[k] = array[i];
                k++;
                i++;
            }else{
                //反之亦然
                temp[k]=array[j];
                k++;j++;
            }
        }
        //接着将剩余的部分加上去
        while(i<=mid){
            temp[k] = array[i];
            k++;
            i++;
        }

        while(j<=right){
            temp[k] = array[j];
            k++;
            j++;
        }

        //最后将排好序的数组替换到原数组上
        for(int num = 0;num<temp.length;num++){
            array[left+num] = temp[num];
        }
    }
}

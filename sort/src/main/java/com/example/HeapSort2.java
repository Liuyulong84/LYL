package com.example;

/**
 * Created by $lyl on 2017/5/31.
 *
 * http://shmilyaw-hotmail-com.iteye.com/blog/1775868
 *
 * 建堆的时候 需要从下往上建堆，原因很简单。根基要稳当嘛， 要不从上往下的的时候，调节完的时候，发现下面的 又比 爷爷结点调过的还大 没办法搞了
 *
 * 因为建堆的时候已经保证了 下面的 子堆已经是 大根堆了，所以 从左后一个 换位置的时候，再次调整 是从上往下调，因为这时候
 * 第一个跟最后一个换位置 之后 调整的话，换上去的肯定是小点。  接着调整的话， 堆尖儿上的三个数，参与调整的话， 一撇子下来，另一撇子的子堆不动 但是还是保证了是 大顶堆
 */

public class HeapSort2 {
    private static int[] sort = new int[]{1,0,10,20,3,5,6,4,9,8,12,17,34,11};
    public static void main(String[] args) {
        buildMaxHeapify(sort);
        heapSort(sort);
        print(sort);
    }

    private static void buildMaxHeapify(int[] data){
        //没有子节点的才需要创建最大堆，从最后一个的父节点开始
        int startIndex = getParentIndex(data.length - 1);
        //从尾端开始创建最大堆，每次都是正确的堆
        for (int i = startIndex; i >= 0; i--) {
            maxHeapify(data, data.length, i);
        }
    }

    /**
     * 创建最大堆
     * @param data
     * @param heapSize 需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了
     * @param index 当前需要创建最大堆的位置
     */
    private static void maxHeapify(int[] data, int heapSize, int index){
        // 当前点与左右子节点比较
        int left = getChildLeftIndex(index);
        int right = getChildRightIndex(index);

        int largest = index;
        if (left < heapSize && data[index] < data[left]) {
            largest = left;
        }
        if (right < heapSize && data[largest] < data[right]) {
            largest = right;
        }
        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整
        if (largest != index) {
            int temp = data[index];
            data[index] = data[largest];
            data[largest] = temp;
            maxHeapify(data, heapSize, largest);
        }
    }

    /**
     * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的
     * @param data
     */
    private static void heapSort(int[] data) {
        //末尾与头交换，交换后调整最大堆
        for (int i = data.length - 1; i > 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;
            maxHeapify(data, i, 0);
        }
    }

    /**
     * 父节点位置
     * @param current
     * @return
     */
    private static int getParentIndex(int current){
        return (current - 1) >> 1;//current/2
    }

    /**
     * 左子节点position注意括号，加法优先级更高
     * @param current
     * @return
     */
    private static int getChildLeftIndex(int current){
        return (current << 1) + 1;
    }

    /**
     * 右子节点position
     * @param current
     * @return
     */
    private static int getChildRightIndex(int current){
        return (current << 1) + 2;
    }

    private static void print(int[] data){
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " |");
        }
    }
}
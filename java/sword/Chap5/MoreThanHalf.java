package sword.Chap5;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalf {

    public int moreThanHalfNum(int[] array) {
        if (array == null || array.length == 0) return 0;

        int mid = select(array, array.length / 2);
        return checkMoreThanHalf(array, mid);
    }

    /**
     * 统计中位数是否超过数组元素个数的一半，若没有默认返回0
     */
    private int checkMoreThanHalf(int[] array, int number) {
        int count = 0;
        for (int a : array) {
            if (a == number) count++;
        }

        return count > array.length / 2 ? number : 0;
    }

    /**
     * 选择排名为k的元素,只是部分排序，时间复杂度为O(N)
     */
    private int select(int[] array, int k) {
        int start = 0;
        int end = array.length - 1;
        // start==end时只有一个元素，不切分
        while (end > start) {
            int j = partition(array, start, end);
            if (j == k) return array[k];
            else if (j > k) end = j - 1;
            else if (j < k) start = j + 1;
        }

        return array[k];
    }

    /**
     * 快速排序的切分方法
     */
    private int partition(int[] array, int start, int end) {
        int i = start;
        int j = end + 1;
        int v = array[start];
        while (true) {
            while (array[++i] < v) if (i == end) break;
            while (array[--j] > v) if (j == start) break;
            if (i >= j) break;
            swap(array, i, j);
        }
        swap(array, start, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 解法2
     * @param array
     * @return
     */
    public int findNumMoreThanHalf(int[] array) {
        if (array == null || array.length == 0) return 0;

        int count = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                result = array[i];
                count = 1;
            }

            else if (array[i] == result) count++;
            else count--;
        }

        return checkMoreThanHalf(array, result);
    }

}


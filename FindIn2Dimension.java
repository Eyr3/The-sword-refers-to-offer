/**
 * Created by Eyr3 on 2018/4/10.
 * 题目：二维数组中，从左向右、从上到下递增，判断是否含有某整数
 * 测试用例：输入空指针
 * 思路：二维数组在内存中占据连续空间，利用行号、列号计算相对数组首地址的偏移量
 * O(m+n)+O(1)
 */
public class FindIn2Dimension {
    public static boolean Find(int[][] array, int target){
        if(array == null || array.length == 0 || array[0].length == 0)
            return false;
        int rows = array.length, cols = array[0].length;
        int row_cur = 0, col_cur = cols - 1;
        while (row_cur < rows && col_cur >=0 ){
            if(array[row_cur][col_cur] == target)
                return true;
            else if(array[row_cur][col_cur] > target){
                col_cur --;
            }
            else {
                row_cur ++;
            }
        }
        return false;
    }

    public static void main(String[] args){
        int data[][] = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(Find(data, 7));
        System.out.println(Find(data, 5));
    }
}

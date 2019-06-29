package me.jianbo.algorithms;

/**
 * 例题 5.3
 * 有一个含n个整数的数组a, 所有元素均不相同, 设计一个算法求其所有子集(幂集).
 * 例如 a[] = {1, 2, 3},
 * 所有子集是:
 *      {},
 *      {3},
 *      {2},
 *      {2, 3},
 *      {1},
 *      {1, 3},
 *      {1, 2},
 *      {1, 2, 3}
 * 输出顺序无关
 */
public class Ex0503 {

    /**
     * 输出一个解
     */
    public static void displaySolution(int a[], int n, int x[]) {
        System.out.print("{");
        for (int i = 0; i < n; i++) {
            if (x[i] == 1) {
                System.out.print(a[i]);
            }
        }
        System.out.println("}");
    }


    /**
     * 用回溯法求解向量x
     * @param nums
     * @param totalLength
     * @param currentIndex
     * @param result
     */
    public static void dfs(int nums[], int totalLength, int currentIndex, int result[]) {
        if (currentIndex >= totalLength) {
            displaySolution(nums, totalLength, result);
        } else {
            // 不选择当前元素
            result[currentIndex] = 0;
            dfs(nums, totalLength, currentIndex + 1, result);

            // 选择当前元数
            result[currentIndex] = 1;
            dfs(nums, totalLength, currentIndex + 1, result);
        }
    }

    public static void main(String[] args) {
        // 待求解数组
        int a[] = {1, 2, 3};
        // 用于保存每次的解
        int result[] = new int[3];

        dfs(a, a.length, 0, result);
    }
}

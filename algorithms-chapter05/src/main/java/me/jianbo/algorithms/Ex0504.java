package me.jianbo.algorithms;

/**
 * 例5.4
 * 设计一个算法在1, 2, 3, ... , 9（顺序不变）数字之间插入 + 或 - 或什么都不插入， 使得计算结果总是100的程序，
 * 并输出所有的可能性。
 * <p>
 * 例如：
 * {1+2+3-4+5+6+78+9} = 100
 * {1+2+34-5+67-8+9} = 100
 * {1+23-4+5+6+78-9} = 100
 * {1+23-4+56+7+8+9} = 100
 * {12+3+4+5-6-7+89} = 100
 * {12+3-4+5+67+8+9} = 100
 * {12-3-4+5-6+7+89} = 100
 * {123+4-5+67-89} = 100
 * {123+45-67+8-9} = 100
 * {123-4-5-6-7+8-9} = 100
 * {123-45-67+89} = 100
 */
public class Ex0504 {
    private static int[] NUMBERS = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public static void main(String[] args) {
        char[] operators = new char[9];
        int lastAddNumber = 1;
        int index = 1;
        int sum = 1;
        dfs(operators, lastAddNumber, index, sum);
    }

    /**
     * dfs 处理函数
     * @param operators 被加入的符号
     * @param lastAddNumber 上次加入的数字
     * @param index 当前处理到的位置
     * @param sum 和
     */
    private static void dfs(char[] operators, int lastAddNumber, int index, int sum) {
        if (index >= 9) {
            if (sum == 100) {
                display(operators);
            }
        } else {
            // 如果在此位置加上+号
            operators[index] = '+';
            sum += NUMBERS[index];
            dfs(operators, NUMBERS[index], index + 1, sum);
            sum -= NUMBERS[index];

            // 如果在此位置上加上-号
            operators[index] = '-';
            sum -= NUMBERS[index];
            dfs(operators, -NUMBERS[index], index + 1, sum);
            sum += NUMBERS[index];

            sum -= lastAddNumber;
            operators[index] = ' ';
            int current;
            if (lastAddNumber > 0) {
                current = lastAddNumber * 10 + NUMBERS[index];
                sum += current;
            } else {
                current = lastAddNumber * 10 - NUMBERS[index];
                sum += current;
            }
            dfs(operators, current, index + 1, sum);
        }
    }

    /**
     * 输出当前满足条件的结果
     * @param operators
     */
    private static void display(char[] operators) {
        System.out.print("{");
        for (int i = 0; i < 9; i++) {
            if (operators[i] == '+' || operators[i] == '-') {
                System.out.print(operators[i]);
            }
            System.out.print(NUMBERS[i]);
        }
        System.out.println("} = 100");
    }
}

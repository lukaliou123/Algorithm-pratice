package mix;

public class HuaRongDao {
    // 检测当前的布局是否可以解决
    public boolean canBeSolved(int[] puzzle) {
        int inversions = 0;
        for (int i = 0; i < puzzle.length; i++) {
            for (int j = i + 1; j < puzzle.length; j++) {
                // 注意，我们不计算空格的逆序数，假设空格用0表示
                if (puzzle[i] != 0 && puzzle[j] != 0 && puzzle[i] > puzzle[j]) {
                    inversions++;
                }
            }
        }
        return (inversions % 2 == 0);
    }

    public static void main(String[] args) {
        HuaRongDao hrd = new HuaRongDao();
        int[] puzzle = {2, 1, 3, 4, 5, 6, 7, 8, 0}; // 0 表示空格
        System.out.println(hrd.canBeSolved(puzzle) ? "可解" : "不可解");
    }
}

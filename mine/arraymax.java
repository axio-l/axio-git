public class arraymax {
    /** Returns the maximum value from m. */
    public static int max(int[] m) {
        int a = m [0];
        for (int i = 1; i < m.length; i = i + 1) {
            if (a <= m [i]) {
                    a = m [i];
            } else {
                continue;
            }
        }
        return a;
    }
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
        System.out.println(max(numbers));
    }
}

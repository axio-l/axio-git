public class TestSort {
    public static void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        if (input != expected) {
            System.out.println("error");
        }
    }

    public static void main(String[] args) {
        testSort();
    }
}

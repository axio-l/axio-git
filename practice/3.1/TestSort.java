import org.junit.Test;
import static org.junit.Assert.*;
//imports all classes under org.junit.Assert, including assertArrayEquals()


public class TestSort {
    @Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg"};
        String[] expected = {"an", "egg", "have", "i"};

        Sort.sort(input);

        assertArrayEquals(expected,input);

        //if (!java.util.Arrays.equals(input, expected)) {
        //    System.out.println("error");
        //}

        /*for (int i = 0; i < input.length; i+=1) {
            if (!input[i].equals(expected[i])) {
                System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i] + ".");
                return;
            }
        }*/
    }



    @org.junit.Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg"};
        int expected = 2;

        int actual = Sort.findSmallest(input, 0);
        assertEquals(expected,actual);

        String[] input2 = {"there", "are", "many", "pigs"};
        int expected2 = 2;

        int actual2 = Sort.findSmallest(input2, 2);
        assertEquals(expected2,actual2);

    }

    @org.junit.Test
    public void swapTest() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};
        Sort.swap(input, a, b);
        assertArrayEquals(expected,input);


    }


    /*public static void main(String[] args) {
        //swapTest();
        //testFindSmallest();
        testSort();
    } */
}

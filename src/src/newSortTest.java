import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class newSortTest {

    @Test
    public void test1(){
        //Testing a reverse array with size 2. A simple test case to check quicksort and mergeSortedHalves
        int [] a = {3, 2, 1};
        int size = 3;

        //Creating an instance of the class and passing array and size
        new newSort(a, size);

        //Test passed
        int[] exp = {1, 2, 3};
        assertArrayEquals(exp, a);
    }
    @Test
    public void test2(){
        //Testing a size 3 array but with size 2 so that it splits the array to see if after its sorted and gets merged, it merges correctly
        int [] a = {8, 35, 9};
        int size = 2;

        //Creating an instance of the class and passing array and size
        new newSort(a, size);

        //Test passed
        int[] exp = {8, 9, 35};
        assertArrayEquals(exp, a);
    }
    @Test
    public void test3(){
        //Testing a size 12 array at size 4 to get 3 different arrays to see if it breaks quicksort and/or mergeSortedHalves
        int [] a = {3, 19, 12, 4, 0, 55, 20, 69, 55, 77, 47, 15,};
        int size = 4;

        //Creating an instance of the class and passing array and size
        new newSort(a, size);

        //Test passed
        int[] exp = {0, 3, 4, 12, 15, 19, 20, 47, 55, 55, 69, 77};
        assertArrayEquals(exp, a);
    }
    @Test
    public void test4(){
        //Running an already sorted array to see if it'll break the code or if it'll pass easily
        int [] a = {0, 1, 2, 3, 4, 5, 6};
        int size = 3;

        //Creating an instance of the class and passing array and size
        new newSort(a, size);

        //Test passed
        int[] exp = {0, 1, 2, 3, 4, 5, 6};
        assertArrayEquals(exp, a);
    }
    @Test
    public void test5(){
        //Testing not only negative values, or duplicates, but also both positive and negative integers
        int [] a = {-10, 20, -20, 0, 10, -20, 0, -10};
        int size = 3;

        //Creating an instance of the class and passing array and size
        new newSort(a, size);

        //Test passed
        int[] exp = {-20, -20, -10, -10, 0, 0, 10, 20};
        assertArrayEquals(exp, a);
    }
}
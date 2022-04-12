import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

class SortClassTest {

    int maxIntSize = 1000 ;
    int maxListSize = 100 ;
    List<Integer> data = new ArrayList<Integer>();
    List<Integer> data2 = new ArrayList<Integer>();
    List<Integer> Bdata2 = new ArrayList<Integer>();

    List<Integer> real = new ArrayList<Integer>();
    List<Integer> real2 = new ArrayList<Integer>();
    List<Integer> Breal2 = new ArrayList<Integer>();

    //1705087 - Fahmid Al Rifat

    // initializion part

    @BeforeEach
    public void setUp() throws Exception {



        Random generator = new Random();

        for (int i = 0; i < maxListSize; i++) {
            data.add(  generator.nextInt(maxIntSize));
            real.add( data.get(i));
        }



        maxListSize =  generator.nextInt(1000);
        //maxListSize =  4;

        for (int i = 0; i < maxListSize; i++) {
            data2.add(  generator.nextInt(maxIntSize));
            real2.add( data2.get(i));
        }

        //maxListSize =  Integer.MAX_VALUE/8;
        maxListSize =  9999999;

        for (int i = 0; i < maxListSize; i++) {
            Bdata2.add(  generator.nextInt(maxIntSize));
            Breal2.add( Bdata2.get(i));
        }



    }


    @Test
    public void testNull() {
        SortClass sorter = new SortClass();
        sorter.sortAll(null);
    }
    @Test
    public void testEmpty() {
        SortClass sorter = new SortClass();
        sorter.sortAll(new ArrayList<Integer>());
    }

    @Test
    public void testOneElement() {
        SortClass sorter = new SortClass();
        List<Integer> test = new ArrayList<Integer>();
        test.add(9);

        sorter.sortAll(test);

        //printResult(test);
    }

    @Test
    public void BtestTwoElementDEC() {
        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(3, 2).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(3, 2).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);

    }

    @Test
    public void testTwoElementASC() {
        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(1, 2).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(1, 2).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);

    }

    @Test
    public void BtestTwoElementMAXINT() {
        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(2147483647, 2147483645).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(2147483647, 2147483645).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);

    }

    public void BtestODDElement() {
        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(1, 2 , 3).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(1, 2 ,3).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);

    }

    @Test
    public void testPreFix() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(3, 2, 1,4,5,6,10,9,8,7).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(3, 2, 1,4,5,6,10,9,8,7).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }

    @Test
    public void testPreAsc() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(1,2,3,4,5,6,7,8,9,10).collect(Collectors.toCollection(ArrayList::new));
        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }

    @Test
    public void testPreDec() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(10,9,8,7,6,5,4,3, 2, 1).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(10,9,8,7,6,5,4,3, 2, 1).collect(Collectors.toCollection(ArrayList::new));
        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }

    @Test
    public void BtestPreOneNeg() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(-10,9,8,7,6,5,4,3, 2, 1).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(-10,9,8,7,6,5,4,3, 2, 1).collect(Collectors.toCollection(ArrayList::new));
        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }

    @Test
    public void BtestPreSomeNeg() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(10,-9,8,7,6,5,4,-3, 2, -1).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(10,-9,8,7,6,5,4,-3, 2, -1).collect(Collectors.toCollection(ArrayList::new));
        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }
    @Test
    public void testPreEql() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(5,5,5,5,5,5,5,5,5,5).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(5,5,5,5,5,5,5,5,5,5).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }

    @Test
    public void BtestPreEqlZero() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(0,0,0,0,0,0,0,0,0,0).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(0,0,0,0,0,0,0,0,0,0).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);
        assertTrue(true);
    }

    @Test
    public void BtestPreMix() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(5,6,7,0,0,0,0,-5,-6,-7).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(5,6,7,0,0,0,0,-5,-6,-7).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);
        assertTrue(true);
    }



    @Test
    public void BtestPreNegEql() {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(-5,-5,-5,-5,-5,-5,-5,-5,-5,-5).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> realT = Stream.of(-5,-5,-5,-5,-5,-5,-5,-5,-5,-5).collect(Collectors.toCollection(ArrayList::new));

        sorter.sortAll(test);

        if (!validate2(test)) {
            fail("Not Sorted Properly ");
        }

        if (!validate1(test,realT)) {
            fail("Element altered during sorting ");
        }
        //printResult(test);

        assertTrue(true);
    }


    @Test
    public void testRandSize() {

        SortClass sorter = new SortClass();

        //printResult(data2);

        sorter.sortAll(data2);
        //sorter.sortAll(real2);

        if (!validate2(data2)) {
            fail("Not Sorted Properly ");
        }
        //printResult(data2);
        //System.out.println();
        //printResult(real2);
        //System.out.println();

        if (!validate1(data2,real2)) {
            fail("Element altered during sorting ");
        }

        //printResult(real2);
        //printResult(data2);

        assertTrue(true);
    }

    public void BtestRandSizeMAX() {

        SortClass sorter = new SortClass();

        //printResult(data2);

        sorter.sortAll(Bdata2);
        //sorter.sortAll(real2);

        if (!validate2(Bdata2)) {
            fail("Not Sorted Properly ");
        }
        //printResult(data2);
        //System.out.println();
        //printResult(real2);
        //System.out.println();

        if (!validate1(Bdata2,Breal2)) {
            fail("Element altered during sorting ");
        }

        //printResult(real2);
        //printResult(data2);

        assertTrue(true);
    }

    @Test
    public void testRandList() {

        SortClass sorter = new SortClass();

        sorter.sortAll(data);

        if (!validate2(data)) {
            fail("Not Sorted Properly ");
        }
       // printResult(data);


        if (!validate1(data,real)) {
            fail("Element altered during sorting ");
        }

       // printResult(real);
        //printResult(data);

        assertTrue(true);
    }



    //checking rule TWO

    private boolean validate2(List<Integer> data ) {
        for (int i = 0; i < data.size()-1; i++) {
            if (data.get(i) > data.get(i+1)) {
                return false;
            }
        }
        return true;
    }

    //checking rule TWO

    private boolean validate1(List<Integer> sorted,List<Integer> unsorted  ) {

        if(sorted.size()!=unsorted.size())
            return false;

        for (int i = 0; i < sorted.size(); i++) {

            for (int j = 0; j < unsorted.size(); j++) {

                //System.out.println("i "+i+" j "+j);
                //System.out.println("ii "+sorted.get(i)+" jj "+unsorted.get(j));

                if(((sorted.get(i)-unsorted.get(j)))==0)
                {
                    unsorted.set(j,-11111);
                    break;

                }
                if((j==(unsorted.size()-1)))
                {

                    //printResult(unsorted);
                    return false;
                }

            }

           // printResult(unsorted);
        }
        return true;
    }

    //Print
    private void printResult(List<Integer> data ) {

        for (int i = 0; i < data.size(); i++) {
            System.out.println(data.get(i)+" ");
        }

        System.out.println();
    }



}
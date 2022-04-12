import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class main {



    public static void main(String[] args) {

        SortClass sorter = new SortClass();
        List<Integer> test = Stream.of(3, 2, 1,4,5,6,10,9,8,7).collect(Collectors.toCollection(ArrayList::new));;

        sorter.sortAll(test);

        for (Integer num : test) {
            System.out.println(num+" ");
        }



    }


}

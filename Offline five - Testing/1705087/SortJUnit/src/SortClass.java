import java.util.List;

public class SortClass {

    private List<Integer> numbers;
    private int number ;
    private String order ;


    public void sortAll(List<Integer> data) {

        if (data == null||data.isEmpty()||data.size()<=1){

            return;
        }

        //System.out.println("size "+data.size());

        this.numbers = data;
        this.number = data.size();

        quicksort(0, number - 1);
    }
    private void quicksort(int low, int high) {
        int i = low, j = high;

        //bonus white box int range

        int pivot = numbers.get(low + (high-low)/2) ;

        //int pivot = numbers.get((high+low)/2) ;

        while (i <= j) {

            while (numbers.get(i) < pivot) {
                i++;
            }

            while (numbers.get(j) > pivot) {
                j--;
            }

            if (i <= j) {

                exchangeVal(i, j);
                j--;
                i++;
            }
        }
        //bonus
        if (low < j)
            quicksort(low, j);
        if (i < high)
            quicksort(i, high);
    }
    private void exchangeVal(int i, int j) {
        int temp = numbers.get(i);
        numbers.set(i,numbers.get(j)) ;
        numbers.set(j,temp) ;
    }
}

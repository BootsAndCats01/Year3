package FirstTerm.Week5;

public class Driver {

    public static void main(String[] args) {
        int[] array = new int[20000];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        SumTask task = new SumTask(0, array.length - 1, array);
        System.out.println(task.compute());
    }
}

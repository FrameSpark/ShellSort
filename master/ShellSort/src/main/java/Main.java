import MultiThread.Run;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int size = 25;
        Array a = new Array(size);
        a.view();
        ShellSort sorter = new ShellSort();

        sorter.sort(a.array);

        System.out.println("________________________");
        Array b = new Array(size);
        b.view();

        System.out.println("Многопоточная");
        long start = System.currentTimeMillis();
        Run runner = new Run(2);
        int [] sortArray;
        sortArray = runner.sort(b.array);

        for(int i=0; i<sortArray.length;i++){
            System.out.print(sortArray[i]+" ");
        }
        System.out.println("(" +( System.currentTimeMillis() - start) + ")");

    }
}

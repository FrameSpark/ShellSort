import MultiThread.Run;

public class Main {
    public static void main(String[] args) {
        int size = 10000;
        Array a = new Array(size);
       // a.view();
        ShellSort sorter = new ShellSort();

        sorter.sort(a.array);

        System.out.println("________________________");
        Array b = new Array(size);
       // b.view();

        System.out.println("Многопоточная");
        long start = System.currentTimeMillis();
        Run runner = new Run(2);
        runner.sort(b.array);

        System.out.println("(" +( System.currentTimeMillis() - start) + ")");

    }
}

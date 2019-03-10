public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(3, 3);
        Matrix b = new Matrix(3, 3);
        a.fillMatrix();
        b.fillMatrix();
        a.multiplyMatrix(b);
        System.out.println();
        MultiplyThreads p = new MultiplyThreads(3, a, b);
        a = p.multiplyThreadsMatrix();
        System.out.println(" ");
        a.view();

    }
}


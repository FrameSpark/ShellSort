public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(1000,1000);
        Matrix b = new Matrix(1000,1000);
        a.fillMatrix();
        b.fillMatrix();
        a.multiplyMatrix(b);
        MultiplyThreads p = new MultiplyThreads(4, a,b);
    }
}

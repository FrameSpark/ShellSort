
import aQute.libg.tuple.Pair;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MultiplyThreads {
    private Queue<Pair> tasks;
    private Thread[] threads;
    private Matrix a,b,c;

    public MultiplyThreads(int thread, Matrix a, Matrix b){
        threads = new Thread[thread];
        for(int i=0; i<thread; i++){
            threads[i] = new Thread(new Runner(i));
        }
        this.a =a;
        this.b = b;
        c = new Matrix(a.matrix.length,b.matrix.length);
    }

    public Matrix multiplyThreadsMatrix(){
        long start = System.currentTimeMillis();
        try{
            tasks = new ArrayBlockingQueue<Pair>(a.matrix.length * a.matrix.length);
            for(int i=0; i<a.matrix.length; i++){
                for(int j=0; j< a.matrix.length; j++){
                    tasks.add(new Pair(i,j));
                }
            }
            for(int i=0; i<threads.length;i++)
                threads[i].start();
            for(int i=0; i<threads.length; i++)
                threads[i].join();
        } catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
        System.out.println("Многопоточное умножение: " );
        System.out.print(System.currentTimeMillis() - start);
        return c;
    }



    class Runner implements Runnable {
        int threadNumber;

        Runner(int n){
            threadNumber = n;
        }

        @Override
        public void run(){
            Pair<Integer,Integer> index;
            int row, column;
            while ((index = tasks.poll()) != null){
                row = index.getFirst();
                column = index.getSecond();
                for(int k=0; k<a.matrix.length;k++){
                    System.out.println("(" +column + " " + row + ")" + " = " + "(" +column + " " + k + ")" + "(" +k + " " + row + ")");
                    c.matrix[column][row] += a.matrix[column][k] * b.matrix[k][row];

                }
            }

        }
    }
}



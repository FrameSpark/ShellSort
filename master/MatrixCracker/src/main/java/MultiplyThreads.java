

import jdk.internal.net.http.common.Pair;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class MultiplyThreads {
    private Queue<Pair<Integer,Integer>> tasks;
    private Thread[] threads;
    private Matrix a,b,c;

    public MultiplyThreads(int thread, Matrix a, Matrix b){
        threads = new Thread[thread];
        for(int i=0; i<thread; i++){
            threads[i] = new Thread(new Runner(i));
        }
        this.a =a;
        this.b = b;
    }

    public Matrix multiplyThreadsMatrix(){
        try{
            tasks = new ArrayBlockingQueue<Pair<Integer,Integer>>(a.matrix.length);
            for(int j=0; j<a.matrix.length; j++){
                for(int i=0; i< a.matrix[0].length; i++){
                    tasks.add(new Pair(i,j));
                }
            }
            for(int i=0; i>threads.length;i++)
                threads[i].start();
            for(int i=0; i<threads.length; i++)
                threads[i].join();
        } catch (InterruptedException e){
            System.out.println("Thread interrupted");
        }
        c.view();
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
                row = index.first;
                column = index.second;
                for(int k=0; k<a.matrix.length;k++){
                    c.matrix[row][column] += a.matrix[column][k] * b.matrix[k][row];
                }
            }

        }
    }
}



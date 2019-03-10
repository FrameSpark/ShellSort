package MultiThread;


import java.lang.reflect.Array;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Run {
    private  int threads;
    private  ExecutorService execut;

   public Run(int threads){
        this.threads = threads;
        execut = Executors.newFixedThreadPool(threads);
    }

    public void sort(int[] array){

        OneThread[] thread = new OneThread[threads];
        for(int i=0; i<thread.length;i++){
            int size = array.length/threads;
            int begin = size *i;
            int end = ((i+1) * size);
            if((array.length-end) < size){
                end = array.length;
            }
            thread[i] = new OneThread(array,begin,end);
        }
        for (OneThread a:thread){
            execut.execute(a);
        }
        execut.shutdown();
        System.arraycopy(merge(array,thread) ,0,array,0,array.length);






    }

    private  int[] merge(int[] array, OneThread[] thread){
        int[] arr = new int[array.length];
        for(int i=0; i<arr.length;i++){
            int min = Integer.MAX_VALUE;
            int k=-1;
            for(int j=0; j<thread.length;j++){
                if(!thread[j].isStop() && min > thread[j].peek()){
                    min = thread[j].peek();
                    k=j;
                }
            }
            if(k!=-1){
                arr[i] = thread[k].poll();
            }
        }
        return arr;
    }


}

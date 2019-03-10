package MultiThread;

public class OneThread implements Runnable {
    private int[] array;
    private int begin;
    private int end;
    private int index;
    private boolean stop = false;

    OneThread(int [] array, int begin, int end){
        this.array = array;
        this.begin = begin;
        this.end = end;
        this.index =begin;
     }

     public int peek(){
        return array[index];
     }

     public int poll(){
        int temp = array[index];
        check();
        return temp;
     }

     private void check(){
        this.index++;
        if (this.index >= this.end)
            this.stop=true;
     }

     public boolean isStop(){
        return stop;
     }
     @Override
    public void run() {
        int temp;
        for(int i=begin; i< end; i++){
            int k=i-1;
            temp = array[i];
            for(; k>=0 && array[k] > temp;){
                array[k+1] = array[k];
                array[k] = temp;
                k--;
            }
        }

    }
}

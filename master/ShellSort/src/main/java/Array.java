import java.util.Random;

public class Array {
    int[] array;
    Array(int size){
        array = new int[size];
        fill(array);
    }

    void fill(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(1000);
        }
    }
    void view(){
        System.out.println(" ");
        for(int i=0; i<array.length;i++){
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}

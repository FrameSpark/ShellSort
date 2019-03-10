
import java.util.Random;


public class Matrix {

    int[][] matrix;
    int i,j;
    Matrix(int i, int j){
        matrix = new int[i][j];
        this.i = i;
        this.j = j;
    }

    public void fillMatrix(){
        Random rand = new Random();
        for(int i=0; i< this.i; i++){
            for(int j=0; j<this.j; j++){
                matrix[i][j] = rand.nextInt(9);
            }
        }
    }
    public void view(){
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    /**
     * Функция произведения матриц без многопоточности
     * @param b Матрица множитель
     * @return Произведение матриц
     */
    public Matrix multiplyMatrix(Matrix b){
        long start = System.currentTimeMillis();
        if(this.j == b.i){
            Matrix c = new Matrix(this.i,b.j);
            for(int i=0;i<this.i;i++){
                for(int j=0; j<b.j;j++){
                    c.matrix[i][j]=0;
                    for(int k=0; k<this.j;k++){
                        c.matrix[i][j] += this.matrix[i][k] * b.matrix[k][j];
                    }
                }
            }
            long finish = System.currentTimeMillis() - start;
            System.out.println("Однопоточное умножение: ");
            System.out.print(finish);
            System.out.println();
            c.view();
            return c;
        }
        else
        {
            System.out.println("Ошибка размеров");
            return null;
        }

    }
}


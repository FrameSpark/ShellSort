public class ShellSort {

    void sort(int []a){
        System.out.println("Однопоточная сортировка");
        long start = System.currentTimeMillis();
        int i, j, k, h, m=0, b=a.length;
        int[] d = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
                84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
                58548857, 157840433, 410151271, 1131376761, 2147483647 };
        while (d[m] < b) ++m;
        while (--m >= 0){
            k = d[m];
            for (i = k; i < b; i++){     // k-сортировка
                j=i;
                h=a[i];
                while ((j >= k) && (a[j-k] > h)){
                    a[j]=a[j-k];
                    j -= k;
                }
                a[j] = h;
            }
        }
        System.out.println("(" + (System.currentTimeMillis() - start) + ")");
       // view(a);
    }

    void view(int []a){
        System.out.println(" ");
        for(int i=0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
}

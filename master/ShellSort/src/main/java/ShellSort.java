public class ShellSort {

    void sort(int []a){
        System.out.println("Однопоточная сортировка");
        long start = System.currentTimeMillis();
        int t,i,j,k,n=a.length;
        for(k=n/2;k>0;k/=2)
            for(i=k;i<n;i++)
            {
                t=a[i];
                for(j=i;j>=k;j-=k){
                    if(t<a[j-k])
                        a[j] = a[j-k];
                    else
                        break;
                }
                a[j]=t;
            }

        System.out.println("(" + (System.currentTimeMillis() - start) + ")");
        view(a);
    }

    void view(int []a){
        System.out.println(" ");
        for(int i=0; i<a.length;i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
}

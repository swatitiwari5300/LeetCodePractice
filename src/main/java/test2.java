public class test2 {

    public static void main(String[] args) {
        int[] a = {1,4,9};
        int[] b = {4,8,15};
        testArr(a,b);
    }

     static void testArr(int[] a, int[] b){
        int [] c = new int[a.length+b.length];

        int i = 0, j = 0, k= 0;

        while(i < a.length && j < b.length){

            if(a[i] < b[j]){ c[k++] = a[i];  i++;}
            else if(a[i] > b[j]){ c[k++] = b[j]; j++;}
            else{
                c[k++] = a[i];
                c[k++] = b[j];
                i++; j++;
            }
        }
        while( i < a.length){ c[k++] = a[i++] ;}
        while( j < b.length){ c[k++] = b[j++] ;}

        for(int n : c){
            System.out.println(n);
        }
}
}

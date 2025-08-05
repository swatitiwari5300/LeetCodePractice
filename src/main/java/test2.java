public class test2 {

    public static void main(String[] args) {
        int[] a = {1, 4, 9};
        int[] b = {4, 8, 15};
        testArr(a, b);

        String str = "sw234at890i65";
        transformString(str);
    }
    //hughes systique question : merge 2 sorted arrays
    static void testArr(int[] a, int[] b) {
        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {

            if (a[i] < b[j]) {
                c[k++] = a[i];
                i++;
            } else if (a[i] > b[j]) {
                c[k++] = b[j];
                j++;
            } else {
                c[k++] = a[i];
                c[k++] = b[j];
                i++;
                j++;
            }
        }
        while (i < a.length) {
            c[k++] = a[i++];
        }
        while (j < b.length) {
            c[k++] = b[j++];
        }

        for (int n : c) {
            System.out.println(n);
        }
    }
// hughes systique question : segregate the numeric values and alphabets in 2 different strings and store in array
    public static void transformString(String s) {
        //["swati","23489065"]]
        char[] charArr = s.toCharArray();

        StringBuilder strAlpha = new StringBuilder();
        StringBuilder strDigit = new StringBuilder();

        for (char ch : charArr) {

            if (Character.isDigit(ch)) {
                strDigit.append(ch);
            } else {
                strAlpha.append(ch);
            }
        }
        String[] ans = {strAlpha.toString(), strDigit.toString()};
        //System.out.println(ans);
        for (String str : ans) {
            System.out.println(str);
        }
    }
}

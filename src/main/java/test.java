import java.util.Arrays;
public class test {

    public static void main(String[] args) {
        String str = "swiss";
        //firstNonRepeatingChar(str);
        int[] arr = {1, 2, 4, 5, 6};
        missingNumber(arr);
    }


    public static void firstNonRepeatingChar(String str){


        String firstNonRepeatingChar = Arrays.stream(str.split(""))
                .filter(ch -> str.indexOf(ch) == str.lastIndexOf(ch))
                .findFirst().get();

        System.out.println(firstNonRepeatingChar);

    }

    //Q - find the missing number from the array
    public static void missingNumber(int[] arr){
        int itr = 1;
        for(int  i  = 1 ; i < arr.length ; i++){
            if(arr[i] == arr[i-1]+itr){
                continue;
            }else{
                System.out.println(arr[i-1]+1);
                break;
            }
        }

    }

    //Q - write a rest api to fetch the data based on - orgId(paginated)
}

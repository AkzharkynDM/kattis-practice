import java.util.Scanner;

public class Alphabeth {

    public static void solveAlphabeth(){
        // write your code here
        Scanner sc = new Scanner(System.in);
        String alpahbeth = sc.nextLine();
        //System.out.println('a'<'b');
        //System.out.println('a'+1 == 'b');

        int[] ones = new int[alpahbeth.length()];
        for (int i=0;i<alpahbeth.length();i++){
            ones[i] = 1;
        }

        for (int i=1;i<alpahbeth.length();i++) {
            for (int j = 0; j < i; j++) {
                if (alpahbeth.charAt(j) < alpahbeth.charAt(i) && ones[i] < ones[j]+1){
                    ones[i] = ones[j]+1;
                }
            }
        }

        int maxValues = 0;
        for (int i=0;i<ones.length;i++){
            if (ones[i] >maxValues){
                maxValues = ones[i];
            }
        }
        System.out.println(26-maxValues);
    }

}

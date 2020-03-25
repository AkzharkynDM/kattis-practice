import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hangman {

    public static void solve() {
        // write your code here
        Scanner sc = new Scanner(System.in);
        int chances = 10;
        String word = sc.nextLine();
        String permutation = sc.nextLine();
        List<Character> tries = new ArrayList<Character>();
        for(int i = 0; i<permutation.length(); i++){
            if(word.indexOf(permutation.charAt(i)) == -1){
                chances -= 1;
            }
            tries.add(permutation.charAt(i));
            if(chances == 0) {
                break;
            }
        }
        String ans = "WIN";
        for(Character c : word.toCharArray()) {
            if(!tries.contains(c)){
                ans = "LOSE";
                break;
            }
        }
        System.out.println(ans);
    }
}

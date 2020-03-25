import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class WordCloud {


    public static int computeP(int cw, int cmax){
        double resultP = 0;
        resultP =  8.0 +  Math.ceil(40*(cw-4)/(cmax-4));

        return (int) resultP;
    }

    public static int computeW(int P, int t){
        double resultW = 0;
        resultW =  Math.ceil(9.0/16.0 * t * P);
        return (int) resultW;
    }

    public static void solveWordCloud(){
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        int cloudCounter = 0;
        while(!line.equals("0 0")) {
            //do something with line
            String[] parts = line.split(" ");
            int maxWidth = Integer.parseInt(parts[0]);
            int wordsInCloud = Integer.parseInt(parts[1]);
            int maxCount = 0;
            Map<String, Integer> map = new LinkedHashMap<>();
            for(int i = 0; i<wordsInCloud; i++) {
                line = sc.nextLine();
                String[] partsCloud = line.split(" ");
                String word = partsCloud[0];
                int wordCount = Integer.parseInt(partsCloud[1]);
                if (maxCount <= wordCount){
                    maxCount = wordCount;
                }
                map.put(word, wordCount);
            }

            Iterator<Map.Entry<String, Integer>> entries = map.entrySet().iterator();
            int currentRowWidth = 0;
            int maxWordHeight = 0;
            int ans = 0;
            while (entries.hasNext()) {
                Map.Entry<String, Integer> entry = entries.next();
                int height = computeP(entry.getValue(), maxCount) ;
                int width = computeW(height, entry.getKey().length());
                if(currentRowWidth + width > maxWidth) {
                    ans += maxWordHeight;
                    maxWordHeight = 0;
                    currentRowWidth = 0;
                }
                maxWordHeight = Math.max(height, maxWordHeight);
                currentRowWidth += width;
                currentRowWidth += 10;
            }
            ans += maxWordHeight;
            cloudCounter ++;

            line = sc.nextLine();
            System.out.println("CLOUD " + cloudCounter + ": " + ans);
        }
    }
}

import java.util.*;

public class RoyalBlood {

    static Map<String, Double> mapBlood = new LinkedHashMap();

    static List<String> lines = new ArrayList<>();
    public static double getBloodIndex(String p1, String p2){
        if((mapBlood.get(p1) != null && mapBlood.get(p1) == -1.0) ||
                (mapBlood.get(p2) != null && mapBlood.get(p2) == -1.0)){
            return -1.0;
        }
        if (mapBlood.get(p1) == null){
            mapBlood.put(p1, 0.0);
        }
        if (mapBlood.get(p2) == null){
            mapBlood.put(p2, 0.0);
        }
        return  (mapBlood.get(p1)/2) + (mapBlood.get(p2)/2);
    }

    public static void solveMediumProblem(){
        Scanner sc = new Scanner(System.in) ;
        int numberOfRelations = sc.nextInt();
        int numberOfClaimants = sc.nextInt();
        sc.nextLine();
        String head  = sc.nextLine();
        mapBlood.put(head, 1.0);

        while (numberOfRelations > 0){
            String line = sc.nextLine();
            String[] parts = line.split(" ");
            mapBlood.put(parts[0], -1.0 );
            lines.add(line);
            numberOfRelations--;
        }

        boolean done = false;
        while(!done) {
            done = true;
            for (String line : lines) {
                String[] parts = line.split(" ");
                double valueBlood = getBloodIndex(parts[1], parts[2]);
                if(mapBlood.get(parts[0]) == null || mapBlood.get(parts[0]) == -1.0 ) {
                    mapBlood.put(parts[0], valueBlood);
                }
                if (mapBlood.get(parts[0]) == -1.0){
                    done = false;
                }
            }
        }

        double max = -1;
        String claimant = "";
        while (numberOfClaimants > 0) {
            String line = sc.nextLine();
            if (mapBlood.get(line) != null && mapBlood.get(line) > max) {
                max = mapBlood.get(line);
                claimant = line;
            }
            numberOfClaimants--;

        }
        System.out.println(claimant);

    }

}

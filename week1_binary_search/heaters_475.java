import java.util.Arrays;


public class heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int n = houses.length;
        int m = heaters.length;
        int minimum = 0;
        int j = 0;
        for(int i = 0 ;i< n ;i++){
            while( j < m - 1 && (Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i])))
                j ++;
            //System.out.println(i+" "+j);
            minimum = Math.max(minimum,Math.abs(heaters[j] - houses[i]));
        }
        return minimum;
        
    }
}

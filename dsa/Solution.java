import java.util.ArrayList;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        ArrayList<Integer> choices = new ArrayList<>();
        int len = gas.length;
        for(int i = 0;i<len;i++){
            if(gas[i]-cost[i]>=0)choices.add(i);
        }
        for(int c : choices){
            int start = c;
            int tank = gas[c] - cost[c];
            while(true){
                start = (start+1)%len;
                if(start==c)return c;
                else if(tank+gas[start]-cost[start] <0){
                    break;
                }
                tank += gas[start]-cost[start];
            }
        }
        return -1;
    }
}
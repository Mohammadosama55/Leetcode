class Solution {
    public boolean canCross(int[] stones) {
        int n=stones.length-1;
        Map<Integer,Set<Integer>>dp=new HashMap<>();
        for(int stone:stones){
            dp.put(stone,new HashSet<>());
        }
        dp.get(stones[0]).add(0);
        for(int stone:stones){
            for(int k:dp.get(stone)){
                for(int step=k-1;step<=k+1;step++){
                    if(step<=0)continue;
                    int newstep=step+stone;
                    if(dp.containsKey(newstep)){
                        dp.get(newstep).add(step);
                    }
                    
                }
            }
        }
        return !dp.get(stones[n]).isEmpty();
        
    }
}
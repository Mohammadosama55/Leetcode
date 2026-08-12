class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize !=0){
            return false;
        }
        Arrays.sort(hand);
        HashMap<Integer,Integer>f=new HashMap<>();
        for(int card:hand){
            f.put(card,f.getOrDefault(card,0)+1);
        }
        for(int card:hand){
            if(f.get(card)==0){
                continue;
            }
            for(int x=card;x<card+groupSize;x++){
                if(f.getOrDefault(x,0)==0){
                    return false;
                }
                f.put(x,f.get(x)-1);
            }
        }
        return true;
        
    }
}
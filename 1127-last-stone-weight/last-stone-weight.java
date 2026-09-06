class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxheap=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone:stones){
            maxheap.offer(stone);
        }
        while(maxheap.size()>1){
            int y=maxheap.poll();
            int x=maxheap.poll();
            if(x!=y){
                maxheap.offer(y-x);
            }
        }
        return maxheap.isEmpty()?0:maxheap.peek();
        
    }
}
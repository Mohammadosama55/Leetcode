class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        int[][]sorted=new int[n][3];
        for(int i=0;i<n;i++){
            sorted[i]=new int[]{tasks[i][0],tasks[i][1],i};
        }
        Arrays.sort(sorted,(a,b)->a[0]-b[0]);
       PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> a[1] != b[1] ? a[1] - b[1] : a[2] - b[2]
        );
        
        int[] result = new int[n];
        int resIdx = 0, ptr = 0;
        long time = sorted[0][0];
        while(resIdx<n){
            while(ptr <n && sorted[ptr][0]<=time){
                heap.offer(sorted[ptr]);
                ptr++;
            }
            if(heap.isEmpty()){
                time=sorted[ptr][0];
                continue;

            }
            int[]cnt=heap.poll();
            time +=cnt[1];
            result[resIdx++]=cnt[2];
        }
        return result;
    }
    
}
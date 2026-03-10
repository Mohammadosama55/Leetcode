class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int index=-1;
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemSize) {
                 if (capacity[i] < min) {
                    min = capacity[i];
                    index = i;
                }

            }  
            
        }

        return index;
    }}
//     int index = -1;
//         int min = Integer.MAX_VALUE; // Start with maximum value

//         for (int i = 0; i < capacity.length; i++) {
//             if (capacity[i] >= itemSize && capacity[i] < min) {
//                 min = capacity[i];
//                 index = i;
//             }
//         }

//         return index;
//     }
// }




       
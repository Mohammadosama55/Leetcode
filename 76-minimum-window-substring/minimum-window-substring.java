class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())return "";
        int[] target=new int[128];
        for(char c:t.toCharArray()) target[c]++;
        int[] window=new int[128];
        int have=0, need=0;
        for(int count:target) if(count>0) need++;
        int left=0,minLen=Integer.MAX_VALUE;
        int resL=-1,resR=-1;
        for(int right=0;right<s.length();right++){
            char c=s.charAt(right);
            window[c]++;
            if(target[c]>0 && window[c]==target[c]){
                have++;
            }
            while(have==need){
                if(right - left +1<minLen){
                    minLen=right-left +1;
                    resL=left;
                    resR=right;
                }
            char leftChar=s.charAt(left);
            window[leftChar]--;
            if(target[leftChar]>0 && window[leftChar]<target[leftChar]){
                have--;
            }
            left++;
            }
        }
      return resL == -1 ? "" : s.substring(resL, resR + 1);
        
    }
}
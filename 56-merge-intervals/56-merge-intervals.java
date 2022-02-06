class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        
        List<int[]> mergedIntervals = new ArrayList();
        int counter = 0;
        
        while(counter<intervals.length){
            if(mergedIntervals.isEmpty()){
                mergedIntervals.add(intervals[counter]);
            }else if(mergedIntervals.get(mergedIntervals.size()-1)[1] >= intervals[counter][0]){
                if(mergedIntervals.get(mergedIntervals.size()-1)[1] < intervals[counter][1]){
                    mergedIntervals.get(mergedIntervals.size()-1)[1] = intervals[counter][1]; 
                }
            }else{
                mergedIntervals.add(intervals[counter]);
            }    
            counter++;
        }
        
       
        int[][] result = new int[mergedIntervals.size()][2];
        
        for(int i =0;i<mergedIntervals.size();i++){
            result[i] = mergedIntervals.get(i);
        }
         return result;
        
    }
    
   
        
    
}
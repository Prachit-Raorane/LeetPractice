class Solution {
    
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        
        solve(s,0,new ArrayList<>());
        
        return result;
    
    }
    
    private void solve(String s,int idx,List<String> answer){
        
        if(answer.size() > 4){
            return;
        }
        
        if(answer.size()==4 && idx == s.length()){
            StringBuilder sb = new StringBuilder();
            
            for(int i =0; i< answer.size();i++){
                if(answer.get(i).length() > 1 && answer.get(i).charAt(0)=='0') return;
         
                
                sb.append(answer.get(i));
                
                if(i != answer.size()-1){
                    sb.append(".");
                }
            }
            
            result.add(sb.toString());
            return;
        }
        
        for(int i=idx;i<s.length();i++){
            String temp = s.substring(idx,i+1);
            
            if(temp.length() > 3) break;
            
            if(Integer.parseInt(temp) >= 0 && Integer.parseInt(temp) <= 255 ){
                answer.add(temp);
                solve(s,i+1,answer);
                answer.remove(answer.size()-1);
            }
        }
        
    }
    
}
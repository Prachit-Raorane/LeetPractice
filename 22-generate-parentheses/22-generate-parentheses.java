class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>();
        resultString("",n,n, result);
        return result;
    }

    private void resultString(String current, int open, int close, ArrayList<String> result) {

        if(open == 0 && close == 0){
            result.add(current);
            return;
        }

        if(open > 0){
            resultString(current + "(",open-1,close,result);
        }

        if(close>0 && close > open){
            resultString(current+")",open,close-1,result);
        }
    }

}
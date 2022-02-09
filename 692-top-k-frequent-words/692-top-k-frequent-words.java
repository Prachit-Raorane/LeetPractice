class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         HashMap<String, Integer> map = new HashMap<>();
        PriorityQueue<String> queue = new PriorityQueue<>((a,b) -> {
            return map.get(b) != map.get(a) ? map.get(b)-map.get(a) : a.compareTo(b);
        });
        
        for(String s: words){
            map.put(s, map.getOrDefault(s, 0)+1);
        }
        
        for(String s: map.keySet()){
            queue.add(s);
        }
        
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i< k; i++){
            list.add(queue.poll());
        }
        
        return list;
    }
    }
    
    

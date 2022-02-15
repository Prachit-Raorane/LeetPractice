class Solution {
 public int lengthOfLongestSubstring(String s) {
            int start = 0;
            int globalMax = 0;
            Map<Character,Integer> characterPositions = new HashMap<>();

            for (int index = 0; index < s.length(); index++) {

                Character currentCharacter = s.charAt(index);

                if(characterPositions.containsKey(currentCharacter)){
                    start = Math.max(start,characterPositions.get(currentCharacter) + 1);
                }

                characterPositions.put(currentCharacter,index);

                globalMax = Math.max(globalMax,index-start+1);
            }

            return globalMax;
        }

}
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        String[][] total = new String[genres.length][3];
        Map<String,Integer> sum = new HashMap<>();

        for(int i=0; i<genres.length; i++){
            total[i] = new String[] {genres[i],String.valueOf(plays[i]),String.valueOf(i)};
            sum.put(genres[i], sum.getOrDefault(genres[i],0)+plays[i]);
        }
        
        Arrays.sort(total,(a,b)->{
            if(sum.get(a[0]) != sum.get(b[0])) return sum.get(b[0])-sum.get(a[0]);
            
            int playA = Integer.parseInt(a[1]);
            int playB = Integer.parseInt(b[1]);
            if(playA!=playB) return playB-playA; 
            
            int idA = Integer.parseInt(a[2]);
            int idB = Integer.parseInt(b[2]);
            return idA-idB;    
        });
        
        Map<String,Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(String[] s: total){
            String genre = s[0];
            int id = Integer.parseInt(s[2]);
            
            int cnt = count.getOrDefault(genre, 0);
            if(cnt<2){
                result.add(id);
                count.put(genre,cnt+1);
            }
        }
        
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
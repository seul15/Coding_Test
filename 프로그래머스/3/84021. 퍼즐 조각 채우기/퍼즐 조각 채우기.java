import java.util.*;

class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1, 0,0};
    List<List<List<int[]>>> rotateBlock;
    
    void bfs(int[][] map, boolean[][] visited, List<List<int[]>> block, int target){
        Queue<int[]> q = new LinkedList<>();
        int N = map.length;
        for(int x = 0; x< N; x++){
            for(int y = 0; y<N; y++){
                if(!visited[x][y] && map[x][y] == target){
                    int minx =x;
                    int miny = y;
                    List<int[]> temp = new LinkedList<>();
                    visited[x][y] = true;
                    q.offer(new int[]{x,y});
                    temp.add(new int[]{x,y});
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        int nx = now[0];
                        int ny = now[1];
                        for(int i=0; i<4; i++){
                            int nextx = nx + dx[i];
                            int nexty = ny + dy[i];
                            if(0>nextx || nextx >=N || 0>nexty || nexty>=N) continue;
                            if(!visited[nextx][nexty] && map[nextx][nexty] == target){
                                q.offer(new int[]{nextx,nexty});
                                temp.add(new int[]{nextx,nexty});
                                visited[nextx][nexty] = true;
                                minx = Math.min(minx, nextx);
                                miny = Math.min(miny, nexty);
                            }
                        }
                    }
                    
                    // 정규화
                    for(int[] t: temp){
                        t[0] -= minx;
                        t[1] -= miny;
                    }
                    // 정렬
                    temp.sort((a,b) -> {
                        if(a[0] != b[0]) return a[0]-b[0];
                        return a[1]-b[1];
                    });
                    
                    block.add(temp);
                }
            }
        }
    }
    
    List<int[]> rotate90(List<int[]> now){
        List<int[]> temp = new LinkedList<>();
        int minx = Integer.MAX_VALUE;
        int miny = Integer.MAX_VALUE;
        
        for(int[] n: now){
            int x =n[0];
            int y =n[1];
            int[] dot = new int[]{-1*y,x};
            minx = Math.min(minx, dot[0]);
            miny = Math.min(miny, dot[1]);
            temp.add(dot);
        }
        
        // 정규화
        for(int[] t: temp){
            t[0] -= minx;
            t[1] -= miny;
        }
        
        // 정렬
        temp.sort((a,b)->{
            if(a[0] != b[0]) return a[0]-b[0];
            return a[1]-b[1];
        });
        
        return temp;
    }
    
    boolean isSame(List<int[]> a, List<int[]> b){
        
        if(a.size() != b.size()) return false;
        for(int i=0; i<a.size(); i++){
            if(a.get(i)[0] != b.get(i)[0] ||
              a.get(i)[1] != b.get(i)[1]) return false;
        }
        return true;
    }
    
    public int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> block = new LinkedList<>();
        List<List<int[]>> empty = new LinkedList<>();
        int answer=0;
        
        boolean[][] visited = new boolean[table.length][table.length];
        
        bfs(table, visited, block, 1);
        
        for(int i=0; i<table.length; i++){
            Arrays.fill(visited[i], false);
        }
        bfs(game_board, visited, empty, 0);
        
        // 회전
        rotateBlock = new LinkedList<>();
        
        for(List<int[]> b: block){
            List<List<int[]>> state = new LinkedList<>();
            
            state.add(b);
            List<int[]> now = b;
            
            for(int i=0; i<3; i++){
                now = rotate90(now);
                state.add(now);
            }
            
            rotateBlock.add(state);
        }
        
        // 맞는 블록 찾기
        boolean[] used = new boolean[rotateBlock.size()];
        
        for(List<int[]> e : empty){
            
            boolean match =false;
            for(int idx=0; idx<rotateBlock.size(); idx++){
                if(used[idx]) continue;
                
                List<List<int[]>> b = rotateBlock.get(idx);
                
                // 회전 좌표 하나씩 비교
                for(List<int[]> rotate: b){
                    if(isSame(e,rotate)){
                        used[idx] = true;
                        answer+= rotate.size();
                        match = true;
                        break;
                    }
                }
                if(match) break;
            }
        }
        return answer;
    }
}
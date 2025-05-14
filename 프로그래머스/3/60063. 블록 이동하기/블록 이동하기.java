import java.util.*;

class Solution {
    static int N;
    static int[] pos1;
    static int[] pos2;
    static int[][][][] distance;
    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    
    static boolean isValid(int[] pos){
        return 0<=pos[0] && pos[0]<N && 0<=pos[1] && pos[1]<N;
    }
    
    static boolean isGreater(int[] pos1, int[] pos2){
        if(pos1[0]>pos2[0]) return true;
        if(pos1[0] == pos2[0]){
            if(pos1[1] > pos2[1]) return true;
        }
        return false;
    }
    
    static int bfs(int[] pos1, int[] pos2, int[][] board){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{pos1[0],pos1[1],pos2[0],pos2[1]});
        distance[pos1[0]][pos1[1]][pos2[0]][pos2[1]] = 0;
        while(!q.isEmpty()){
            int[] current = q.poll();
            int[] cpos1 = new int[]{current[0],current[1]};
            int[] cpos2 = new int[]{current[2],current[3]};
            int dist = distance[cpos1[0]][cpos1[1]][cpos2[0]][cpos2[1]];
    
            for(int i=0; i<4; i++){ // 상하좌우 이동
                int[] npos1 = new int[]{cpos1[0]+dr[i],cpos1[1]+dc[i]};
                int[] npos2 = new int[]{cpos2[0]+dr[i],cpos2[1]+dc[i]};
                if(isValid(npos1) && isValid(npos2) && 
                   board[npos1[0]][npos1[1]] ==0 && board[npos2[0]][npos2[1]] ==0 && 
                    distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] == -1){
                    q.offer(new int[]{npos1[0],npos1[1],npos2[0],npos2[1]});
                    distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] = dist+1;
                    if(npos2[0]==N-1&&npos2[1]==N-1) return distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]];
                }
            }
            // 회전
            if(cpos1[0] == cpos2[0]){ // 가로
                //1번 바퀴
                for(int i: new int[]{1,-1}){
                    int[] npos2 = new int[]{cpos2[0],cpos2[1]}; 
                    int[] npos1 = new int[]{cpos1[0]+i,cpos1[1]};
                    if(isValid(npos1) && board[npos1[0]][npos1[1]]==0){
                        npos1[1]++;
                        if(isGreater(npos1,npos2)){
                            int[] temp = new int[]{npos1[0], npos1[1]};
                            npos1[0] = npos2[0]; 
                            npos1[1] = npos2[1];
                            npos2[0] = temp[0];
                            npos2[1] = temp[1];
                        }
                        if(isValid(npos1) && isValid(npos2) && 
                           board[npos1[0]][npos1[1]]==0 && board[npos2[0]][npos2[1]] ==0 &&
                          distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] == -1){
                            q.offer(new int[]{npos1[0],npos1[1],npos2[0],npos2[1]});
                            distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] = dist+1;
                            if(npos2[0]==N-1&&npos2[1]==N-1) return distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]];
                        }
                    }
                }
                //2번 바퀴
                for(int i: new int[]{1,-1}){
                    int[] npos1 = new int[]{cpos1[0],cpos1[1]};
                    int[] npos2 = new int[]{cpos2[0]+i,cpos2[1]};
                    if(isValid(npos2) && board[npos2[0]][npos2[1]]==0){
                        npos2[1]--;
                        if(isGreater(npos1,npos2)){
                            int[] temp = new int[]{npos1[0], npos1[1]};
                            npos1[0] = npos2[0]; 
                            npos1[1] = npos2[1];
                            npos2[0] = temp[0];
                            npos2[1] = temp[1];
                        }
                        if(isValid(npos1) && isValid(npos2) && 
                           board[npos1[0]][npos1[1]]==0 && board[npos2[0]][npos2[1]] ==0 &&
                          distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] == -1){
                            q.offer(new int[]{npos1[0],npos1[1],npos2[0],npos2[1]});
                            distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] = dist+1;
                            if(npos2[0]==N-1&&npos2[1]==N-1) return distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]];
                        }
                    }
                }
            }
            else{ // 세로
                //1번 바퀴
                for(int i: new int[]{1,-1}){
                    int[] npos2 = new int[]{cpos2[0],cpos2[1]}; 
                    int[] npos1 = new int[]{cpos1[0],cpos1[1]+i};
                    if(isValid(npos1) && board[npos1[0]][npos1[1]]==0){
                        npos1[0]++;
                        if(isGreater(npos1,npos2)){
                            int[] temp = new int[]{npos1[0], npos1[1]};
                            npos1[0] = npos2[0]; 
                            npos1[1] = npos2[1];
                            npos2[0] = temp[0];
                            npos2[1] = temp[1];
                        }
                        if(isValid(npos1) && isValid(npos2) && 
                           board[npos1[0]][npos1[1]]==0 && board[npos2[0]][npos2[1]] ==0 &&
                          distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] == -1){
                            q.offer(new int[]{npos1[0],npos1[1],npos2[0],npos2[1]});
                            distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] = dist+1;
                            if(npos2[0]==N-1&&npos2[1]==N-1) return distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]];
                        }
                    }
                }
                //2번 바퀴
                for(int i: new int[]{1,-1}){
                    int[] npos1 = new int[]{cpos1[0],cpos1[1]}; 
                    int[] npos2 = new int[]{cpos2[0],cpos2[1]+i};
                    if(isValid(npos2) && board[npos2[0]][npos2[1]]==0){
                        npos2[0]--;
                        if(isGreater(npos1,npos2)){
                            int[] temp = new int[]{npos1[0], npos1[1]};
                            npos1[0] = npos2[0]; 
                            npos1[1] = npos2[1];
                            npos2[0] = temp[0];
                            npos2[1] = temp[1];
                        }
                        if(isValid(npos1) && isValid(npos2) && 
                           board[npos1[0]][npos1[1]]==0 && board[npos2[0]][npos2[1]] ==0 &&
                          distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] == -1){
                            q.offer(new int[]{npos1[0],npos1[1],npos2[0],npos2[1]});
                            distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]] = dist+1;
                            if(npos2[0]==N-1&&npos2[1]==N-1) return distance[npos1[0]][npos1[1]][npos2[0]][npos2[1]];
                        }
                    }
                }
            }
        }
        return -1;
    }
    
    
    public int solution(int[][] board) {
        N = board.length;
        distance = new int[N][N][N][N];
        for(int[][][] x1: distance){
            for(int[][] y1: x1){
                for(int[] x2: y1){
                    Arrays.fill(x2, -1);
                }
            }
        }
        pos1 = new int[]{0,0};
        pos2 = new int[]{0,1};
        
        return bfs(pos1,pos2,board);
    }
}
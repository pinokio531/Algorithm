import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        int total = numbers.length();
        int[][] map = new int[total+1][total+1];
        int BLANK = 99;
        
        HashMap<Integer, Integer> hash = new HashMap<>();
        
        //이중배열 초기화
        for(int i=0; i<=total; i++){
            for(int j=0; j<=total; j++){
                map[i][j] = BLANK;
            }
        }
        
        //주어진 값 넣기
        for(int k=1; k<=total; k++){
            map[0][k] = map[k][0] = numbers.charAt(k-1);
        }
        
        //값 조합
        for(int y=1; y<=total; y++){
            for(int x=1; x<=total; x++){
                
                boolean prime = true;
                map[y][x] = Integer.parseInt(String.valueOf(map[y][0]) + String.valueOf(map[0][x]));
                
                //소수판별
                for(int q=2; q<map[y][x]; q++){
                    if(map[y][x] !=0 && map[y][x] % 2 == 0){
                        prime = false;
                        break;
                    }
                }
                
                //소수이면
                if(prime && hash.containsKey(map[y][x])){
                    hash.put(map[y][x], map[y][x]);
                }
            }
        }
        
        answer = hash.size();
        
        
        
        
        
        return answer;
    }
}
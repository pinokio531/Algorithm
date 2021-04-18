import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        Queue<Integer> que = new LinkedList<>();       //큐 생성
        Queue<Integer> tmpAnswer = new LinkedList<>(); //임시 큐 생성
        
        //배열을 큐로 전환
        for(int i=0; i<prices.length; i++){
            que.offer(prices[i]);
        }
        
        int p_num = que.poll();                         //비교할 값 꺼내기
        int start = 1;                                  //배열에서 비교 시작점
        
        while(!que.isEmpty()){
            int count = 0;          //주식이 떨어지지 않는 횟수 카운트
            
            for(int j=start; j<prices.length; j++){
                count++;            //비교할 때 마다 횟수 1회 증가(다음날 바로 떨어지더라도 비교하면 count=1 이기 때문)
                if(p_num > prices[j]){
                    break;
                }
            }
            start++;                 //시작점 하나 올림
            tmpAnswer.offer(count);  //비교할 값 꺼내기
            p_num = que.poll();      //마지막 남은거 꺼내는 경우에는 while문을 타지않음
        }
        
        tmpAnswer.offer(0);          //마지막 단계는 무조건 '0' 이니까
        
        //임시저장 큐에 있는 값은 정답 형식인 배열로 변환
        int[] answer = new int[tmpAnswer.size()];
        for(int k=0; k<answer.length; k++){
            answer[k] = tmpAnswer.poll();
        }
        
        return answer;
    }
}
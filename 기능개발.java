import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        
        Queue<Integer> que = new LinkedList<>(); //스피드 큐
        
        //speeds배열 큐로  변환
        for(int i : speeds){
            que.offer(i);
        }
        
        int day = 0; //소요되는 날짜
        Queue<Integer> dayQue = new LinkedList<>(); //소요되는 날짜 큐
        
        //큐가 빌 때까지
        while(!que.isEmpty()){
            for(int j : progresses){
                int workSpeed = que.poll();
                day = (int) Math.ceil((double) (100-j)/workSpeed);
                dayQue.offer(day);
            }
        }
        
        
        Queue<Integer> tmpAnswer = new LinkedList<>();
        
        int count = 1;
        int work = dayQue.poll();;
        
        //날짜 빌때까지
        while(!dayQue.isEmpty()){
            if(work >= dayQue.peek()){ //다음값과 비교후 전날이 높다면
                dayQue.poll();
                count++; //카운트셈
            }
            else{ //다음값과 비교후 전날이 낮다면
                tmpAnswer.offer(count); //count를 모두 출력하고
                count=1; //1로 초기화
                work = dayQue.poll();
            }
        }
        
        tmpAnswer.offer(count);
        
        answer = new int[tmpAnswer.size()];
        for(int z=0; z < answer.length; z++){
            answer[z] = tmpAnswer.poll();
        }
        
        return answer;
    }
}
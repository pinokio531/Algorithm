import java.util.*;

class Main{
    public static void main(String[] args) {
        int[] answer = {};
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        
        Queue<Integer> que = new LinkedList<>(); //스피드 큐
        
        //speeds배열 큐로  변환
        for(int i : speeds){
            que.offer(i);
        }
        
        int day = 0; //소요되는 날짜
        Queue<Integer> dayQue = new LinkedList<>(); //소요되는 날짜 큐
        
        
            while(!que.isEmpty()){
                for(int j : progresses){
                    int workSpeed = que.poll();
                    day = (int) Math.ceil((double) (100-j)/workSpeed);
                    dayQue.offer(day);
                }
            }
        
        
        Queue<Integer> tmpAnswer = new LinkedList<>();
        
        int count = 1;
        int work = 0;
        
        while(!dayQue.isEmpty()){
            work= dayQue.poll();
            
            if(work >= dayQue.peek()){
                count++;
            }
            else{
                tmpAnswer.offer(count);
                count=1;
            }
            
        }
        
        answer = new int[tmpAnswer.size()];
        for(int z=0; z < answer.length; z++){
            answer[z] = tmpAnswer.poll();
        }
    }
}
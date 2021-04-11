import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int time=0;                                             //걸린 시간
        int bridgeTruckWeight = 0;                              //다리위 트럭 무게
        Queue<Integer> truck = new LinkedList<>();              //다리 건너기 전 트럭들
        Queue<Integer> bridgeTruck = new LinkedList<>();        //다리 위 트럭들
        
        //truck_weights 큐로 변환
        for(int z=0; z<truck_weights.length; z++){
            truck.offer(truck_weights[z]);
        }
        
        //다리 건너기전, 다리 위 트럭이 아무것도 없으면 종료
        while(!truck.isEmpty() || !bridgeTruck.isEmpty()){
            if(bridgeTruck.size() == bridge_length){            //다리위 트럭 길이와, 다리 길이가 같으면
                int out = bridgeTruck.poll();                   //다리 맨 앞에 트럭 뺌
                bridgeTruckWeight = bridgeTruckWeight-out;      //그 무게만큼 다리위 무게에서 뺌
            }

            time++;
            
            if(!truck.isEmpty()){ //대기 중인 트럭이 있으면
                if(weight >= (bridgeTruckWeight + truck.peek())){           //다음에 올라올 트럭을 합쳐서 다리 무게보다 가벼울때
                int in = truck.poll();                                      //다음 트럭 빼서
                bridgeTruck.offer(in);                                      //다리 위로 올림
                bridgeTruckWeight = bridgeTruckWeight+in;                   //전체 무게 추가
            }
                else{                                                       //다음에 올라올 트럭을 합쳐서 다리 무게보다 무거울때
                    bridgeTruck.offer(0);                                   //0을 올림
                }
            }
            
            else{                                                           //대기 중인 트럭이 없고, 다리 위 트럭이 있으면
                if(!bridgeTruck.isEmpty() && bridgeTruckWeight==0){
                    break;
                }
                else{
                    bridgeTruck.offer(0);
                }
            }
            

        }
        answer = time;
        return answer;
    }
}
import java.util.*;

// Programmers Level2
// 해쉬, 구현
// 50분 소요
public class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Set<String> parkingLot = new HashSet<>();
        Map<String,String[]> inDb = new HashMap<>();
        Map<String,Integer> parkingTimeDb = new HashMap<>();
        List<ParkingFee> answerList = new ArrayList<>();
        StringTokenizer st;

        for (String record : records) {
            st = new StringTokenizer(record);
            String[] time = st.nextToken().split(":");
            String carNum = st.nextToken();
            String op = st.nextToken();
            if (op.equals("IN")) {
                inDb.put(carNum, time);
                parkingLot.add(carNum);
            }
            else if (op.equals("OUT")) {
                int pt = getParkingTime(inDb.get(carNum), time);
                parkingTimeDb.put(carNum, parkingTimeDb.getOrDefault(carNum,0)+pt);
                parkingLot.remove(carNum);
            }
        }

        for (Object o : parkingLot.toArray()) {
            String carNum = (String) o;
            int pt = getParkingTime(inDb.get(carNum), new String[]{"23","59"});
            parkingTimeDb.put(carNum, parkingTimeDb.getOrDefault(carNum,0)+pt);
            parkingLot.remove(carNum);
        }

        for (String carNum : parkingTimeDb.keySet()) {
            int pt = parkingTimeDb.get(carNum);
            int pf = pt <= fees[0] ? fees[1] : fees[1]+(int)Math.ceil((pt-fees[0])*1.0/fees[2])*fees[3];
            answerList.add(new ParkingFee(carNum,pf));
        }

        answerList.sort((o1,o2)->o1.carNumber.compareTo(o2.carNumber));
        int[] answer = new int[answerList.size()];
        int idx=0;
        for (ParkingFee fee : answerList) answer[idx++] = fee.parkingFee;
        return answer;
    }

    public int getParkingTime(String[] in, String[] out) {
        int inHour = Integer.parseInt(in[0]);
        int inMinute = Integer.parseInt(in[1]);
        int outHour = Integer.parseInt(out[0]);
        int outMinute = Integer.parseInt(out[1]);
        if (outMinute<inMinute) return (outHour-inHour-1)*60+(outMinute+60-inMinute);
        else return (outHour-inHour)*60+(outMinute-inMinute);
    }

    public class ParkingFee {
        String carNumber;
        int parkingFee;

        public ParkingFee(String carNumber, int parkingFee) {
            this.carNumber = carNumber;
            this.parkingFee = parkingFee;
        }
    }
}

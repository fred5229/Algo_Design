import java.util.ArrayList;
import java.util.Scanner;

class IntervalScheduling {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = Integer.parseInt(sc.nextLine().trim());

        ArrayList<TimeSlot> slots = new ArrayList<>(i);

        while(sc.hasNextLine()){
            String[] x = sc.nextLine().trim().split(" ");
            slots.add(new TimeSlot(Integer.parseInt(x[0]), Integer.parseInt(x[1])));
        }

        slots.sort(((a, b) -> a.end - b.end));

        int[] startTimes = new int[i];

        for(int z = 0; z < slots.size() ; z++ ){
            startTimes[z] = slots.get(z).start;
        }

        int y = 0;

        while(!slots.isEmpty()){
            TimeSlot ts = slots.get(0);
            slots.remove(0);
            slots.removeIf(s -> (s.start > ts.start && s.start < ts.end) || (s.end > ts.start && s.end < ts.end));
            y++;
        }

        System.out.println(y);
    }
}

class TimeSlot{

    public TimeSlot(int start, int end){
        this.start = start;
        this.end = end;
    }

    public int start;
    public int end;
}
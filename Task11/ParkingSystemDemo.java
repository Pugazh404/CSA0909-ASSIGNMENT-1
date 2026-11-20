import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

abstract class ParkedVehicle {
    private final String registration;
    ParkedVehicle(String registration) {
        if (registration == null || registration.isBlank()) throw new IllegalArgumentException("Invalid registration");
        this.registration = registration;
    }
    public String registration() { return registration; }
    abstract double hourlyRate();
}
class Bike extends ParkedVehicle {
    Bike(String r) { super(r); }
    double hourlyRate() { return 10; }
}
class Sedan extends ParkedVehicle {
    Sedan(String r) { super(r); }
    double hourlyRate() { return 30; }
}
class EV extends Sedan {
    EV(String r) { super(r); }
}
class ParkingTicket {
    final long id;
    final ParkedVehicle vehicle;
    final int floor, slot;
    final LocalDateTime entry;
    ParkingTicket(long id, ParkedVehicle v, int f, int s, LocalDateTime e) {
        this.id=id; vehicle=v; floor=f; slot=s; entry=e;
    }
}
class ParkingService {
    private static long nextTicket=1000;
    private final ParkedVehicle[][] spaces;
    private final Map<String,ParkingTicket> active=new HashMap<>();
    ParkingService(int[] capacity) {
        spaces=new ParkedVehicle[capacity.length][];
        for(int i=0;i<capacity.length;i++) spaces[i]=new ParkedVehicle[capacity[i]];
    }
    ParkingTicket enter(ParkedVehicle v, boolean monthlyPass) {
        if(active.containsKey(v.registration())) throw new IllegalArgumentException("Duplicate active registration");
        for(int f=0;f<spaces.length;f++) for(int s=0;s<spaces[f].length;s++) {
            if(spaces[f][s]==null) {
                spaces[f][s]=v;
                ParkingTicket t=new ParkingTicket(++nextTicket,v,f,s,LocalDateTime.now());
                active.put(v.registration(),t);
                System.out.println("Entry: "+v.registration()+" ticket="+t.id+" slot="+f+","+s+
                    (monthlyPass?" monthly-pass":""));
                return t;
            }
        }
        throw new IllegalStateException("Parking full");
    }
    double exit(String reg, long minutes, boolean monthlyPass) {
        if(minutes<0) throw new IllegalArgumentException("Negative duration");
        ParkingTicket t=active.remove(reg);
        if(t==null) throw new IllegalArgumentException("No active ticket");
        spaces[t.floor][t.slot]=null;
        long hours=(minutes+59)/60;
        double fee=monthlyPass?0:hours*t.vehicle.hourlyRate();
        System.out.println("Exit: "+reg+" duration="+minutes+" min fee=Rs "+fee+" slot released");
        return fee;
    }
    int available() {
        int n=0; for(ParkedVehicle[] floor:spaces) for(ParkedVehicle v:floor) if(v==null)n++;
        return n;
    }
}
public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingService p=new ParkingService(new int[]{2,1});
        p.enter(new Bike("TN01AA1111"),false);
        p.enter(new Sedan("TN02BB2222"),false);
        p.enter(new EV("TN03CC3333"),true);
        System.out.println("Available slots: "+p.available());
        System.out.println("Collected: Rs "+p.exit("TN01AA1111",61,false));
        System.out.println("Monthly pass exit: Rs "+p.exit("TN03CC3333",120,true));
        System.out.println("Available slots: "+p.available());
        try { p.enter(new Sedan("TN02BB2222"),false); }
        catch(IllegalArgumentException e) { System.out.println(e.getMessage()); }
    }
}

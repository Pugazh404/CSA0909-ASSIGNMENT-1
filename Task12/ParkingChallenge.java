import java.time.LocalDate;
import java.time.LocalTime;

interface DayPass {
    boolean validOn(LocalDate date);
}
class OneDayPass implements DayPass {
    private final LocalDate date;
    OneDayPass(LocalDate date) { this.date=date; }
    public boolean validOn(LocalDate d) { return date.equals(d); }
}
abstract class NewVehicle {
    private final String reg;
    NewVehicle(String reg) { this.reg=reg; }
    String reg() { return reg; }
    abstract double fee(LocalTime entry, int minutes);
}
class E_Bike extends NewVehicle {
    E_Bike(String r) { super(r); }
    double fee(LocalTime entry, int minutes) { return 25.0; }
}
class DeliveryVan extends NewVehicle {
    DeliveryVan(String r) { super(r); }
    double fee(LocalTime entry, int minutes) {
        int hours=(minutes+59)/60;
        LocalTime end=entry.plusMinutes(minutes);
        boolean daytime=!entry.isBefore(LocalTime.of(9,0)) && !end.isAfter(LocalTime.of(17,0));
        return hours*40.0*(daytime?2:1);
    }
}
class VisitorCar extends NewVehicle {
    VisitorCar(String r) { super(r); }
    double fee(LocalTime entry, int minutes) { return ((minutes+59)/60)*40.0; }
}
public class ParkingChallenge {
    static double finalFee(NewVehicle v, LocalTime in, int minutes, DayPass pass, LocalDate date) {
        if(pass!=null && pass.validOn(date)) return 0;
        return v.fee(in,minutes);
    }
    public static void main(String[] args) {
        LocalDate today=LocalDate.now();
        DayPass pass=new OneDayPass(today);
        NewVehicle ebike=new E_Bike("TN10EB1001");
        NewVehicle van=new DeliveryVan("TN10DV2002");
        NewVehicle visitor=new VisitorCar("TN10VC3003");
        System.out.println("E-bike fee: Rs "+finalFee(ebike,LocalTime.of(10,0),60,null,today));
        System.out.println("Delivery van daytime fee: Rs "+finalFee(van,LocalTime.of(10,0),120,null,today));
        System.out.println("Visitor with one-day pass: Rs "+finalFee(visitor,LocalTime.of(11,0),90,pass,today));
        System.out.println("Delivery van evening fee: Rs "+finalFee(van,LocalTime.of(16,0),120,null,today));
    }
}

package pass.Company.Mathworks;
import java.util.*;

public class ood {

    class Theater{
        String name;
        Map<String, Set<String>> movieTimeSlots;
        Map<String, Set<Screen>> movieScreen;
    }
    class Screen{
        int number;
        String movie;
        int available;
        String timeSlot;
    }

    class Customer{
        String type;
        int price;
    }
    Map<String, Theater> map = new HashMap<>();
    public String bookTicket(String theater, String movie, String timeSlot, int numTickets, String customerType){
        Theater t = map.get(theater);
        if (!t.movieTimeSlots.containsKey(movie)) return "1";
        Set<String> timeSlots = t.movieTimeSlots.get(movie);
        if (!timeSlots.contains(timeSlot)) return "3";
        Set<Screen> screens = t.movieScreen.get(movie);
        int count = 0;
        for (Screen sc : screens){
            count += sc.available; 
        }
        if (count < numTickets) return "2";
        boolean flag = false;
        if (customerType == "VIP") flag = true;
        for (Screen sc : screens){
            if (sc.available < numTickets){
                sc.available = 0;
                numTickets -= sc.available;
            } 
            else {
                sc.available -= numTickets;
            }
        }
        return "";
    }
}

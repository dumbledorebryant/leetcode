package pass.Company.Mathworks;
import java.util.*;

public class ood {
    class Theater{
        String name;
        Map<Integer, Integer> screens;
        Theater(String name){
            this.name = name;
        }
        public void initScreen(int index, int num){
            screens.put(index, num);
        }
        public int getNum(int index){
            return screens.get(index);
        }
    }

    class Movie{

    }
    public String bookTicket(String theater, String movie, String timeSlot, int numTickets, String customerType){
        
    }
}

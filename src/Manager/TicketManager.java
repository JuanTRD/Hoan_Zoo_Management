package Manager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import IO.TicketIO;
import Module.Ticket;
public class TicketManager {
    Scanner scanner = new Scanner(System.in);
    List<Ticket> tickets = new ArrayList<Ticket>();
    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
    public void readTicket(){
        tickets = TicketIO.readTicket();
    }
    public void writeTicket(){
        TicketIO.writeTicket(tickets);
    }
    public void displayTicket(){
        for(Ticket ticket : tickets){
            System.out.println(ticket.toString());
        }
    }
    public double getTicketCount(){
        double count = 0;
        for(Ticket ticket : tickets){
            count+= ticket.getQuantity();
        }
        return count;
    }
    public double getProfitTicket(){
        double profit = 0;
        for(Ticket ticket : tickets){
            profit+= ticket.getQuantity()*ticket.getPrice();
        }
        return profit;
    }
    public Ticket createTicket(){
        while(true){
            try{
                System.out.println("Nhap gia ve");
                int price = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhap so luong ve");
                int quantity = Integer.parseInt(scanner.nextLine());
                return new Ticket(price,quantity);
            }catch(Exception e){
                e.printStackTrace();
            }
        }


    }
}

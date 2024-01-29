package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Module.Ticket;

public class TicketIO {
    static File ticketFile = new File("ticket.csv");

    public static void writeTicket(List<Ticket> tickets) {
        try {
            FileWriter fileWriter = new FileWriter(ticketFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Ticket t : tickets) {
                bufferedWriter.write(t.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static List<Ticket> readTicket() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(ticketFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                Ticket ticket = new Ticket(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]) );
                tickets.add(ticket);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }
}

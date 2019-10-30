package test;

public class BuyTicket implements TicketService{
    @Override
    public void buy() {
        System.out.print("买票成功");
    }
}

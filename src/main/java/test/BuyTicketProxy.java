package test;

public class BuyTicketProxy implements TicketService{
    private TicketService ticketService;

    BuyTicketProxy(TicketService ticketService){
        this.ticketService=ticketService;
    }
    @Override
    public void buy() {
            System.out.print("检验是否正确买票-----------");
            ticketService.buy();
    }
}

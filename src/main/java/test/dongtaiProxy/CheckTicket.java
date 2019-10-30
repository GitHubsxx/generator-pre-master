package test.dongtaiProxy;

import test.BuyTicket;
import test.TicketService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CheckTicket implements InvocationHandler{
    private TicketService ticketService;
    public CheckTicket(TicketService ticketService){
        this.ticketService=ticketService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print("检票是否正确--------");
        method.invoke(ticketService,null);
        return null;
    }
}

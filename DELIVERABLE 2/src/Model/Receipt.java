package Model;

import java.time.LocalDateTime;

public class Receipt {
    private double price;
    private LocalDateTime time;
    private LocalDateTime date;
    private Payment pmt;
    
    public Receipt(double price, LocalDateTime time, LocalDateTime date) {
        this.price = price;
        this.time = time;
        this.date = date;
    }
    
    public String paymentInfo(Payment payment) {
        double amount = payment.getAmount();
        return "Price: " + price + "\nAmount: " + amount + "\nTime: " + time + "\nDate: " + date;
    }
}

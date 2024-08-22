interface PaymentProcessor {
    void processPayment(double amount);
}


class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through PayPal.");
    }
}


class Stripe {
    public void makeStripePayment(double amount) {
        System.out.println("Payment of $" + amount + " made through Stripe.");
    }
}


class Square {
    public void payWithSquare(double amount) {
        System.out.println("Payment of $" + amount + " made through Square.");
    }
}


class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}


class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makeStripePayment(amount);
    }
}


class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.payWithSquare(amount);
    }
}


public class PaymentTest {
    public static void main(String[] args) {
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(100.0);

        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.0);

        PaymentProcessor squareProcessor = new SquareAdapter(new Square());
        squareProcessor.processPayment(300.0);
    }
}
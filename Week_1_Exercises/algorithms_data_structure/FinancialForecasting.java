public class FinancialForecasting {

    
    public static double calculateFutureValue(double initialAmount, double growthRate, int years) {
        
        if (years == 0) {
            return initialAmount;
        }
                return calculateFutureValue(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double initialAmount = 1000.0; 
        double growthRate = 0.05;      
        int years = 10;                

        double futureValue = calculateFutureValue(initialAmount, growthRate, years);
        System.out.printf("Future Value after %d years: %.2f%n", years, futureValue);
    }
}
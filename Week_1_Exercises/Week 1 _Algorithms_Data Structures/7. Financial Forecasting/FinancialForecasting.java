public class FinancialForecasting {

    public static double futureValue(double pv, double r, int n) {
        if (n == 0) {
            return pv;
        }
        return futureValue(pv, r, n - 1) * (1 + r);
    }

    public static void main(String[] args) {
        double presentValue = 2000;  
        double growthRate = 0.08;    
        int periods = 12;            

        double predictedValue = futureValue(presentValue, growthRate, periods);
        System.out.println("Predicted future value: " + predictedValue);
    }
}

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    // Map to store computed future values for memoization
    private static Map<Integer, Double> memo = new HashMap<>();

    // Basic recursive method to calculate future value
    public static double calculateFutureValueRecursive(double initialAmount, double growthRate, int years) {
        // Base case: if years are zero, the future value is the initial amount
        if (years == 0) {
            return initialAmount;
        }
        // Recursive case: apply growth rate for one year and then call recursively for the remaining years
        return calculateFutureValueRecursive(initialAmount * (1 + growthRate), growthRate, years - 1);
    }

    // Optimized method using memoization to calculate future value
    public static double calculateFutureValueOptimized(double initialAmount, double growthRate, int years) {
        // Check if value is already computed
        if (memo.containsKey(years)) {
            return memo.get(years);
        }

        // Base case: if years are zero, the future value is the initial amount
        if (years == 0) {
            return initialAmount;
        }

        // Recursive case: apply growth rate for one year and then call recursively for the remaining years
        double futureValue = calculateFutureValueOptimized(initialAmount * (1 + growthRate), growthRate, years - 1);

        // Store the computed value in the map
        memo.put(years, futureValue);

        return futureValue;
    }

    public static void main(String[] args) {
        double initialAmount = 1000; // Initial investment amount
        double annualGrowthRate = 0.05; // 5% growth rate
        int forecastYears = 10; // Number of years to forecast

        // Calculate future value using basic recursive method
        double futureValueRecursive = calculateFutureValueRecursive(initialAmount, annualGrowthRate, forecastYears);

        // Calculate future value using optimized method
        double futureValueOptimized = calculateFutureValueOptimized(initialAmount, annualGrowthRate, forecastYears);

        // Output the results
        System.out.printf("Future value of an investment of %.2f at an annual growth rate of %.2f%% over %d years (recursive) is %.2f%n",
                initialAmount, annualGrowthRate * 100, forecastYears, futureValueRecursive);

        System.out.printf("Future value of an investment of %.2f at an annual growth rate of %.2f%% over %d years (optimized) is %.2f%n",
                initialAmount, annualGrowthRate * 100, forecastYears, futureValueOptimized);
    }
}


/* 
 Q1 Explain the concept of recursion and how it can simplify certain problems.
 
     Recursion is a technique where a method calls itself to solve smaller instances of the same problem. 
     It often simplifies complex problems by breaking them down into more manageable sub-problems.
     
     In our example, the problem of calculating future value can be broken down into smaller 
     sub-problems: computing the future value for one year and then recursively solving for the remaining years.

 
*/
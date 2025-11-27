public class SalaryCalculator {
    private static final double BASE_SALARY = 1000.0;
    private static final double MAX_SALARY_CAP = 2000.0;
    private static final int DAYS_SKIPPED_THRESHOLD = 5;

    private static final double STANDARD_MULTIPLIER = 1.0;
    private static final double PENALTY_MULTIPLIER = 0.85;

    private static final int PRODUCTS_SOLD_THRESHOLD = 20;
    private static final int HIGH_BONUS_MULTIPLIER = 13;
    private static final int STANDARD_BONUS_MULTIPLIER = 10;
    
    public double salaryMultiplier(int daysSkipped) {
        return daysSkipped >= DAYS_SKIPPED_THRESHOLD ? PENALTY_MULTIPLIER: STANDARD_MULTIPLIER ;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= PRODUCTS_SOLD_THRESHOLD ? HIGH_BONUS_MULTIPLIER : STANDARD_BONUS_MULTIPLIER;
    }

    public double bonusForProductsSold(int productsSold) {
        return productsSold * this.bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double calculatedSalary =  BASE_SALARY * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);
        return Math.min(calculatedSalary, MAX_SALARY_CAP);
    } 
}
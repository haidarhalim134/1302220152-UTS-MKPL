package lib;

public class IncomeInfo {
    private int monthlySalary;
	private int otherMonthlyIncome;
	private int annualDeductible;

    public void setMonthlySalary(int salary) {
        monthlySalary = salary;
    }

    public int getMonthlySalary() {
		return monthlySalary;
	}
	
	public void setAnnualDeductible(int deductible) {	
		this.annualDeductible = deductible;
	}

	public int getAnnualDeductible() {
		return annualDeductible;
	}
	
	public void setAdditionalIncome(int income) {	
		this.otherMonthlyIncome = income;
	}

	public int getAdditionalIncome() {
		return otherMonthlyIncome;
	}
}

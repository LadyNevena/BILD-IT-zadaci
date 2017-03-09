package zadaci_09_03_2017;

class LoanModified {

	private double annualInterestRate;
	private int numOfYears;
	private double loanAmount;

	public LoanModified() {
		this(7.5, 30, 100000);
	}

	public LoanModified(double annualInterestRate, int numOfYears, double loanAmount) {
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		if (numOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		setAnnualInterestRate(annualInterestRate);
		setNumOfYears(numOfYears);
		setLoanAmount(loanAmount);
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		if (annualInterestRate <= 0)
			throw new IllegalArgumentException("Annual interest rate must be positive.");
		this.annualInterestRate = annualInterestRate;
	}

	public int getNumOfYears() {
		return numOfYears;
	}

	public void setNumOfYears(int numOfYears) {
		if (numOfYears <= 0)
			throw new IllegalArgumentException("Number of years must be positive.");
		this.numOfYears = numOfYears;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		if (loanAmount <= 0)
			throw new IllegalArgumentException("Loan amount must be positive.");
		this.loanAmount = loanAmount;
	}

	public double monthlyPayment() {
		double monthlyInterestRate = annualInterestRate / 1200;
		return loanAmount * monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numOfYears * 12)));
	}

	public double totalPayment() {
		return monthlyPayment() * numOfYears * 12;
	}

	public static void main(String[] args) {
		try {
			new LoanModified(7.5, 30, 100000);
			new LoanModified(-1, 3, 3);
			new LoanModified(7.5, 30, 20000);
		} catch (Exception ex) {
			System.out.println(ex);
		}

		System.out.println("End of program");

	}

}

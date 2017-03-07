package zadaci_07_03_2017;

public class Loan {
	private double value;
	
	Loan(double value){
		this.value= value;
		
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public String toString(){
		return "Loan object with value = "+value;
	}

}

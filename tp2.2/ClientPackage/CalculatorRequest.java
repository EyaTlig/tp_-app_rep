package ClientPackage;

import java.io.Serializable;

public class CalculatorRequest implements Serializable {
     public double operand1;
     public char operator;
     public double operand2;
     public double req;


    public CalculatorRequest(double operand1, char operator, double operand2) {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;
    }

	public void setResultat(double req) {
		this.req = req;
	}
}

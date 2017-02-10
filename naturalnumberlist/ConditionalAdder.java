package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.IBooleanVariable;
import positronic.satisfiability.naturalnumber.INaturalNumber;

public class ConditionalAdder extends positronic.satisfiability.naturalnumber.ConditionalAdder
{
	private static final long serialVersionUID = -6461192646477193565L;

	public ConditionalAdder(INaturalNumberList numbersArray,
			IBitString membership, INaturalNumber conditionalSum) throws Exception 
	{
		super(numbersArray.getNaturalNumberArray(),membership.getBVArray(),conditionalSum);
	}
	
	public ConditionalAdder(INaturalNumberList numbersArray,
			IBooleanVariable[] membership, INaturalNumber conditionalSum) throws Exception 
	{
		super(numbersArray.getNaturalNumberArray(),membership,conditionalSum);
	}
}
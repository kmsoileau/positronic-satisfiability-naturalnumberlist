package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.exceptions.NaturalNumberListXorerException;
import positronic.satisfiability.naturalnumber.NaturalNumberXorer;

public class NaturalNumberListXorer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;
	
	public NaturalNumberListXorer(INaturalNumberList addend1, INaturalNumberList addend2, INaturalNumberList sum) throws NaturalNumberListException, Exception
	{
		if(addend1.size()!=addend2.size() || addend1.size()!=sum.size())
			throw new NaturalNumberListXorerException("Size mismatch of INaturalNumberList parameters passed to constructor.");
		IProblem[] p=new MetaProblem[addend1.size()];
		for(int i=0;i<p.length;i++)
			p[i]=new NaturalNumberXorer(addend1.getNaturalNumber(i),addend2.getNaturalNumber(i),sum.getNaturalNumber(i));
		this.setClauses(new Conjunction(p).getClauses());
	}
}

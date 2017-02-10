package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListAdderException;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.naturalnumber.NaturalNumberAdder;

/**
 * This performs a "vector" addition of two like-sized 
 * INaturalNumberLists. This means that 
 * sum.getNaturalNumber(i)=addend1.getNaturalNumber(i)+addend2.getNaturalNumber(i)
 * for each i=0,1,2,...,(sum.size()-1)
 * 
 * @author Kerry Michael Soileau
 */
public class NaturalNumberListAdder extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;
	
	public NaturalNumberListAdder(INaturalNumberList addend1, INaturalNumberList addend2, INaturalNumberList sum) throws NaturalNumberListException, Exception
	{
		if(addend1.size()!=addend2.size() || addend1.size()!=sum.size())
			throw new NaturalNumberListAdderException("Size mismatch of INaturalNumberList parameters passed to constructor.");
		IProblem[] p=new MetaProblem[addend1.size()];
		for(int i=0;i<p.length;i++)
			p[i]=new NaturalNumberAdder(addend1.getNaturalNumber(i),addend2.getNaturalNumber(i),sum.getNaturalNumber(i));
		this.setClauses(new Conjunction(p).getClauses());
	}
}

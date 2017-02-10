/*
 * BitStringListRepeater.java	1.0 06/02/10
 *
 * Copyright 2006 Positronic Software.
 *
 *
 */

/**
 * A class which imposes the constraint that at least one member of
 * of the given IBitStringList appears at least twice in that 
 * IBitStringList.
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 06/02/10
 * @see BitStringEqualizer
 * @see IBitString
 * @see Disjunction
 * @see IClause
 * @see IProblem
 * @see MetaProblem
 */

package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.bitstring.BitStringEqualizer;
import positronic.satisfiability.bitstring.IBitString;
import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IClause;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;


public class NaturalNumberListRepeater extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 3268793939837872505L;

	public NaturalNumberListRepeater(INaturalNumberList list) throws Exception
	{
		IProblem p=null;
		for(int i=0;i<list.size();i++)
		{
			INaturalNumber b=list.getNaturalNumber(i);
			for(int j=i+1;j<list.size();j++)
				p=new Disjunction(p,new NaturalNumberEqualizer(b,list.getNaturalNumber(j)));
		}
		if(p==null)
			this.setClauses((IClause[])null);
		else
			this.setClauses(p.getClauses());
	}
}

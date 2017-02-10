package positronic.satisfiability.naturalnumberlist.permutation;

import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.Mapper;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.elements.ProblemPair;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class Permuter extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 474894716363406592L;

	public Permuter(INaturalNumber x, INaturalNumber y, Permutation perm) throws Exception
	{
		ProblemPair[] pp=new ProblemPair[perm.getOrder()];
		for(int i=0;i<pp.length;i++)
			pp[i]=new ProblemPair(new NaturalNumberFixer(x,i),new NaturalNumberEqualizer(y,perm.get(i)));
		this.setClauses(new Mapper(pp).getClauses());
	}
}

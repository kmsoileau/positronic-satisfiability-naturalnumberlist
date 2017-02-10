package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;

public class NaturalNumberListMembershipper extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;

  public NaturalNumberListMembershipper(INaturalNumber element, INaturalNumberList set) throws Exception
  {
    if(set==null)
      throw new NaturalNumberListException("Passed a null INaturalNumberList to constructor.");
    if(element==null)
      throw new NaturalNumberListException("Passed a null INaturalNumber to constructor.");
    IProblem[] res=new IProblem[set.size()];
    for(int i=0;i<set.size();i++)
    {
      INaturalNumber curr=set.getNaturalNumber(i);
      res[i]=new NaturalNumberEqualizer(curr,element);
    }
    IProblem problem=new Disjunction(res);
    this.setClauses(problem.getClauses());
  }
}

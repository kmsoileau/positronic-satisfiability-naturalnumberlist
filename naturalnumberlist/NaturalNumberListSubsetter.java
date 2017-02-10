package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListException;

public class NaturalNumberListSubsetter extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;

  //Ensures that every INaturalNumber in A is also in B
  public NaturalNumberListSubsetter(INaturalNumberList A, INaturalNumberList B) throws Exception
  {
    if(A==null)
      throw new NaturalNumberListException("Passed a null INaturalNumberList to constructor.");
    if(B==null)
      throw new NaturalNumberListException("Passed a null INaturalNumberList to constructor.");
    
    IProblem res[]=new IProblem[A.size()];
    for(int i=0;i<A.size();i++)
      res[i]=new NaturalNumberListMembershipper(A.getNaturalNumber(i),B);
    IProblem total=new Conjunction(res);
    total=new Conjunction(total,
    		new NaturalNumberListNonrepeater(A),
    		new NaturalNumberListNonrepeater(B));
    this.setClauses(total.getClauses());
  }
}

package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Disjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListMembershipException;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;
/**
 * <p>Title: NaturalNumberListMembership</p>
 * <p>Description: TBS</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

public class NaturalNumberListMembership extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;
  
  public NaturalNumberListMembership(INaturalNumber inn, INaturalNumberList bsl) throws Exception
  {
    if(bsl==null)
      throw new NaturalNumberListMembershipException("Passed a null INaturalNumberList to constructor.");
    if(inn==null)
      throw new NaturalNumberListMembershipException("Passed a null INaturalNumber to constructor.");
    IProblem[] res=new IProblem[bsl.size()];
    for(int i=0;i<bsl.size();i++)
    {
      INaturalNumber curr=bsl.getNaturalNumber(i);
      res[i]=new NaturalNumberEqualizer(curr,inn);
    }
    IProblem problem=new Disjunction(res);
    this.setClauses(problem.getClauses());
  }
}
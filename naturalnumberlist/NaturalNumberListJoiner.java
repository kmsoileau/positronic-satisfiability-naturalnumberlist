/*
 * NaturalNumberListJoiner.java	1.0 06/02/10
 *
 * Copyright 2006 Positronic Software.
 *
 *
 */

package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListException;
import positronic.satisfiability.naturalnumber.NaturalNumberEqualizer;

public class NaturalNumberListJoiner extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;
  
  public NaturalNumberListJoiner(INaturalNumberList join,INaturalNumberList A,INaturalNumberList B) throws Exception
  {
    if(join==null || A==null || B==null)
      throw new NaturalNumberListException("Passed null INaturalNumberList to NaturalNumberListJoiner constructor.");
    if(join.size()!=A.size()+B.size())
    	throw new NaturalNumberListException("INaturalNumberList join is incorrect size to hold the INaturalNumberList formed by the concatenation of INaturalNumberLists A and B.");
    	
    IProblem problem=null;
    for(int i=0;i<A.size();i++)
    	problem=new Conjunction(problem,new NaturalNumberEqualizer(A.getNaturalNumber(i),join.getNaturalNumber(i)));
    for(int i=A.size();i<A.size()+B.size();i++)
    	problem=new Conjunction(problem,new NaturalNumberEqualizer(B.getNaturalNumber(i-A.size()),join.getNaturalNumber(i)));
    
    this.setClauses(problem.getClauses());
  }
}
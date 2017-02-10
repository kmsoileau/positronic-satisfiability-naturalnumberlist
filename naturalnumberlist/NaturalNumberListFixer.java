package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.BitFixer;
import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.NaturalNumberListException;

public class NaturalNumberListFixer extends MetaProblem implements IProblem
{
  private static final long serialVersionUID = 1L;
  
  public NaturalNumberListFixer(INaturalNumberList target) throws Exception
  {
    if(target==null)
      throw new NaturalNumberListException("Passed null INaturalNumberList to constructor.");
    IProblem problem=null;
    for(int i=0;i<target.size();i++)
      for(int j=0;j<target.getNaturalNumber(i).size();j++)
      {
        IProblem bf=new BitFixer(target.getNaturalNumber(i).getBooleanVariable(j),
          target.getNaturalNumber(i).getBooleanVariable(j).getValue());
        problem=new Conjunction(problem,bf);
      }
    this.setClauses(problem.getClauses());
  }

  /*
  public NaturalNumberListFixer(INaturalNumberList target, boolean[][] data) throws BooleanLiteralException,NaturalNumberException,NaturalNumberListException
  {
    if(data==null)
      throw new NaturalNumberListException("Passed null boolean[][] to constructor.");
    IProblem problem=null;
    for(int i=0;i<data.length;i++)
      for(int j=0;j<data[i].length;j++)
        problem=new Conjunction(problem,new BitFixer(target.getNaturalNumber(i).getBooleanVariable(j),data[i][j]));
    this.setClauses(problem.getClauses());
  }

  public NaturalNumberListFixer(INaturalNumberList target, INaturalNumber[] data) throws BooleanLiteralException,NaturalNumberException,NaturalNumberListException
  {
    boolean[][] bdata=new boolean[data.length][];
    for(int i=0;i<bdata.length;i++)
    {
      bdata[i]=new boolean[data[i].size()];
      for(int j=0;j<bdata[i].length;j++)
        bdata[i][j]=data[i].getBooleanVariable(j).getValue();
    }
    NaturalNumberListFixer res=new NaturalNumberListFixer(target,bdata);
    this.setClauses(res.getClauses());
  }
  */
}
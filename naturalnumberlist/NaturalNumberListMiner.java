/**
 * An extension of the Problem class which determines the minimum value found in 
 * an INaturalNumberList.
 *
 * To use this class, one passes an INaturalNumberList list and an INaturalNumber 
 * min to the appropriate constructor. The NaturalNumberListMiner object produced 
 * is a Problem, and one may manipulate it using any of the methods provided by 
 * the Problem class.
 *
 * For example, when the Problem instance p defined by
 *
 * <p><tt>Problem p = new NaturalNumberListMiner(min,list);</tt></p>
 *
 * is satisfied, the following truth equations will be satisfied:
 *
 * <p><tt>min <= X</tt> for every member <tt>X</tt> in <tt>list</tt></p>
 * 
 * and
 * 
 * <p><tt>min</tt> is a member of <tt>list</tt></p>
 *
 * @author  Kerry Michael Soileau
 * <blockquote><pre>
 * ksoileau@yahoo.com
 * http://kerrysoileau.com/index.html
 * </pre></blockquote>
 * @version 1.0, 05/11/23
 * @see Conjunction
 * @see IProblem
 * @see MetaProblem
 * @see INaturalNumber
 * @see NaturalNumberOrderer
 */
package positronic.satisfiability.naturalnumberlist;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumberOrderer;

public class NaturalNumberListMiner extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public NaturalNumberListMiner(INaturalNumberList list,INaturalNumber min) throws Exception
	{
		IProblem[] p=new NaturalNumberOrderer[list.size()];
		for(int i=0;i<p.length;i++)
			p[i]=new NaturalNumberOrderer(min,list.getNaturalNumber(i));
		IProblem result=new Conjunction(
				new NaturalNumberListMembership(min,list),
					new Conjunction(p));
		this.setClauses(result.getClauses());
	}
}

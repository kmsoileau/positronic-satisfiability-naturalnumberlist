/**
 * An extension of the Problem class which determines the maximum value found in 
 * an INaturalNumberList.
 *
 * To use this class, one passes an INaturalNumberList list and an INaturalNumber 
 * max to the appropriate constructor. The NaturalNumberListMaxer object produced 
 * is a Problem, and one may manipulate it using any of the methods provided by 
 * the Problem class.
 *
 * For example, when the Problem instance p defined by
 *
 * <p><tt>Problem p = new NaturalNumberListMaxer(max,list);</tt></p>
 *
 * is satisfied, the following truth equations will be satisfied:
 *
 * <p><tt>max >= X</tt> for every member <tt>X</tt> in <tt>list</tt></p>
 * 
 * and
 * 
 * <p><tt>max</tt> is a member of <tt>list</tt></p>
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

public class NaturalNumberListMaxer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = 1L;

	public NaturalNumberListMaxer(INaturalNumberList list,INaturalNumber max) throws Exception
	{
		IProblem[] p=new NaturalNumberOrderer[list.size()];
		for(int i=0;i<p.length;i++)
			p[i]=new NaturalNumberOrderer(list.getNaturalNumber(i),max);
		IProblem result=new Conjunction(
				new NaturalNumberListMembership(max,list),
					new Conjunction(p));
		this.setClauses(result.getClauses());
	}
}

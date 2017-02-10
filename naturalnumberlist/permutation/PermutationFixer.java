package positronic.satisfiability.naturalnumberlist.permutation;

import java.util.ArrayList;

import positronic.satisfiability.elements.Conjunction;
import positronic.satisfiability.elements.IProblem;
import positronic.satisfiability.elements.MetaProblem;
import positronic.satisfiability.exceptions.PermutationFixerException;
import positronic.satisfiability.naturalnumber.NaturalNumberFixer;

public class PermutationFixer extends MetaProblem implements IProblem
{
	private static final long serialVersionUID = -5340199870671278851L;

	public PermutationFixer(Permutation perm, ArrayList<Long> image) throws Exception
	{
		if(perm.getOrder()!=image.size())
			throw new PermutationFixerException("Order of Permutation does not match length of image array.");
		if(!perm.proper(image))
			throw new PermutationFixerException("Initializing range array does not produce a permutation.");
		IProblem ret=null;

		for(int i=0;i<image.size();i++)
			ret=new Conjunction(ret,new NaturalNumberFixer(perm.get(i),image.get(i)));

		this.setClauses(ret.getClauses());
	}

	public PermutationFixer(Permutation perm, long[] image) throws Exception
	{
		if(perm.getOrder()!=image.length)
			throw new PermutationFixerException("Order of Permutation does not match length of image array.");
		if(!perm.proper(image))
			throw new PermutationFixerException("Initializing range array does not produce a permutation.");
		IProblem ret=null;

		for(int i=0;i<image.length;i++)
			ret=new Conjunction(ret,new NaturalNumberFixer(perm.get(i),image[i]));

		this.setClauses(ret.getClauses());
	}
}

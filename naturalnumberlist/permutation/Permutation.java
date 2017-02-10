package positronic.satisfiability.naturalnumberlist.permutation;

import java.util.ArrayList;

import positronic.satisfiability.naturalnumber.INaturalNumber;
import positronic.satisfiability.naturalnumber.NaturalNumber;

public class Permutation
{
	private INaturalNumber[] image;
	private int order;

	public Permutation(int order) throws Exception
	{
		this.image=new INaturalNumber[order];
		this.order=order;
		for(int i=0;i<this.order;i++)
			this.setImage(i, new NaturalNumber());
	}

	public INaturalNumber get(int i)
	{
		return image[i];
	}

	public int getOrder()
	{
		return order;
	}

	public boolean proper(ArrayList<Long> image) 
	{
		for(int i=0;i<image.size();i++)
		{
			if(image.get(i)<0 || image.get(i)>=this.order)
				return false;
			for(int j=i+1;j<image.size();j++)
				if(image.get(j)==image.get(i))
					return false;
		}
		return true;
	}

	public boolean proper(long[] image)
	{
		for(int i=0;i<image.length;i++)
		{
			if(image[i]<0 || image[i]>=this.order)
				return false;
			for(int j=i+1;j<image.length;j++)
				if(image[j]==image[i])
					return false;
		}
		return true;
	}

	public void setImage(int i, INaturalNumber val)
	{
		this.image[i] = val;
	}

	public String toString()
	{
		String ret="";
		for(int i=0;i<this.getOrder();i++)
			ret+=i+" ";
		ret+="\n";
		for(int i=0;i<this.getOrder();i++)
			ret+="| ";
		ret+="\n";
		for(int i=0;i<this.getOrder();i++)
			ret+=this.get(i)+" ";
		return ret;
	}


}

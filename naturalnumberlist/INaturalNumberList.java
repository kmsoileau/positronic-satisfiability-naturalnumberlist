package positronic.satisfiability.naturalnumberlist;

/**
 * <p>Title: INaturalNumberList</p>
 * <p>Description: The interface for classes implementing the natural 
 * number list.</p>
 * <p>Copyright (c) 2005</p>
 * <p>Company: Positronic Software</p>
 * @author Kerry Michael Soileau
 * @version 1.0
 */

import positronic.satisfiability.bitstringlist.IBitStringList;
import positronic.satisfiability.naturalnumber.INaturalNumber;

public interface INaturalNumberList extends IBitStringList
{
	@Override
	String getName();
	INaturalNumber getNaturalNumber(int i) throws Exception;
	INaturalNumber[] getNaturalNumberArray();
}
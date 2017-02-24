package com.cooksys.ftd.assignments.collections;

import com.cooksys.ftd.assignments.collections.generators.Cap;
import com.cooksys.ftd.assignments.collections.hierarchy.Hierarchy;
import com.cooksys.ftd.assignments.collections.model.Capitalist;
import com.cooksys.ftd.assignments.collections.model.FatCat;
import com.cooksys.ftd.assignments.collections.model.WageSlave;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import static org.hamcrest.CoreMatchers.instanceOf;

import java.util.*;

public class MegaCorp implements Hierarchy<Capitalist, FatCat> {

	
	HashSet<Capitalist> hashset = new HashSet<Capitalist>();
    /**
     * Adds a given element to the hierarchy.// Done
     * <p>
     * If the given element is already present in the hierarchy, 
     * do not add it and return false // Done
     * <p>
     * If the given element has a parent and the parent is not part of the hierarchy,
     * add the parent and then add the given element 
     * <p>
     * If the given element has no parent but is a Parent itself,
     * add it to the hierarchy 
     * <p>
     * If the given element has no parent and is not a Parent itself,
     * do not add it and return false
     *
     * @param capitalist the element to add to the hierarchy
     * @return true if the element was added successfully, false otherwise
     */ 
    @Override
    public boolean add(Capitalist capitalist) {
    	
    	//bad conditions
    	if (capitalist == null)		// makes sure that if it is null then it wont be added
    	{
    		return false;
    	}
    	else if(hashset.contains(capitalist)) // Makes sure that it wont' be added twice
    	{
    		return false;
    	}
    	
    	
    	//make sure parents are in the MegaCorp
    	if ((capitalist.hasParent())&&(!hashset.contains(capitalist.getParent()))) // if the entry has a parent and and the set does not contain
    	{																		   // the add method is called again with the parent of the entry. 
    		//use recursion, look at this carefully
    		hashset.add(capitalist.getParent());
    		//return add(capitalist.getParent());
    		return add(capitalist);
    		
    	}
    	//add the dude
    	else if((capitalist instanceof FatCat))
    	{
    		hashset.add(capitalist); 												// adds t
    		return true;
    	} 
    	else if((capitalist.getParent() == null) && (capitalist instanceof WageSlave))
		{
			return false;															// This adds the fatcat that is first without a parent
		}
    	else if((capitalist.getParent() != null) && (capitalist instanceof WageSlave))
    	{
    		hashset.add(capitalist);												// Adds the wageslave that has a parent
    		return true;
    	}
    	return true; 
    	    	
    }

    /**
     * @param capitalist the element to search for
     * @return true if the element has been added to the hierarchy, false otherwise
     */
    @Override
    public boolean has(Capitalist capitalist) {    	
        return hashset.contains(capitalist);
    }

    /**
     * @return all elements in the hierarchy,
     * or an empty set if no elements have been added to the hierarchy
     */
    @Override
    public Set<Capitalist> getElements() {
    	
    	HashSet<Capitalist> finalSet = hashset;
    	
    	if (hashset.isEmpty())
    	{
    		return new HashSet<Capitalist>();
    	}
        
        return finalSet;
    }

    /**
     * @return all parent elements in the hierarchy,
     * or an empty set if no parents have been added to the hierarchy
     */
    @Override
    public Set<FatCat> getParents() {
       // throw new NotImplementedException();
    	Set<FatCat> finalSet = new HashSet<FatCat>();
    	for (Capitalist c : hashset) {
    		if (c instanceof FatCat)
    		{
    			finalSet.add((FatCat) c); // Casted the fatCat object to the Capitalist which isnt a problem because there is a check 
    		}
    	}
    	
    	return finalSet;
         
    }

    /**
     * @param fatCat the parent whose children need to be returned
     * @return all elements in the hierarchy that have the given parent as a direct parent,
     * or an empty set if the parent is not present in the hierarchy or if there are no children
     * for the given parent
     */
    @Override
    public Set<Capitalist> getChildren(FatCat fatCat) {
    	
    	Set<Capitalist> finalSet = new HashSet<Capitalist>();
    	for (Capitalist c : hashset) {
    		if (c.getParent() == fatCat )
    		{
    			finalSet.add(c);  
    		}
    	}
    	
    	return finalSet;
    }

    /**
     * @return a map in which the keys represent the parent elements in the hierarchy,
     * and the each value is a set of the direct children of the associate parent, or an
     * empty map if the hierarchy is empty.
     */
    @Override
    public Map<FatCat, Set<Capitalist>> getHierarchy() {
    	
    	
    	
    	Map<FatCat, Set<Capitalist>> finalHashMap = new HashMap<FatCat, Set<Capitalist>>();
    	for (Capitalist c : hashset ) 
    	{
    		Set<Capitalist> finalSet = new HashSet<Capitalist>();
    		if (c instanceof FatCat)
    		{
    			
    			for (Capitalist d : hashset) 
    			{
    				if (d.getParent() == d )
    						{
    						finalSet.add(d);
    						//finalHashMap.put(c, d) ;
    						// add capitilast to set
    						}
    			}
    		}
    		finalHashMap.put((FatCat)c, finalSet) ;
    	}
    	return finalHashMap;
        // Will have to iterate through the map in order to fill it in from a set. 
    }

    /**
     * @param capitalist
     * @return the parent chain of the given element, starting with its direct parent,
     * then its parent's parent, etc, or an empty list if the given element has no parent
     * or if its parent is not in the hierarchy
     */
    @Override
    public List<FatCat> getParentChain(Capitalist capitalist) {
    	
    	ArrayList<FatCat> finalList = new ArrayList<FatCat>();
    	
    	Capitalist k = capitalist;

    	if(k !=null || k.hasParent() != false )
    	{
    		while (k.hasParent() && has(k.getParent()))
    		{
    			finalList.add((FatCat)k);
    			k = k.getParent();
    		}
    	}
    	return finalList; 
    	 
    }
    
    
}

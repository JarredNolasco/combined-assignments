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
    	
    	if (capitalist == null || this.has(capitalist) || capitalist.hasParent() == false && capitalist instanceof WageSlave) {
    		return false;
    	} else if (capitalist.hasParent() != true && capitalist instanceof FatCat) {
    		hashset.add(capitalist); 
    		return true;
    	} else {
    		hashset.add(capitalist);
    		this.add(capitalist.getParent());
    		return true;
    	}
 
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
    	Set<FatCat> parents = getParents();
    	Set<Capitalist> children;
    	
    	for (FatCat f : parents ) 
    	{
    	  children = getChildren(f);
    	  finalHashMap.put(f, children) ;
    	}
    	return finalHashMap;
    }

    /**
     * @param capitalist
     * @return the parent chain of the given element, starting with its direct parent,
     * then its parent's parent, etc, or an empty list if the given element has no parent
     * or if its parent is not in the hierarchy
     */
    @Override
    public List<FatCat> getParentChain(Capitalist capitalist) {
    	
    	
    	List<FatCat> parents = new ArrayList<>();
    	
    	Capitalist c = capitalist;
    	
    	if (c == null || c.hasParent() == false || !(hashset.contains(c.getParent()))) {
    		return parents;
    	}else{
    	
    	FatCat parent = capitalist.getParent();
        while (parent != null) {
            parents.add(parent);
            parent = parent.getParent();
        }
    	}
        return parents;
    }
     
    	
    	
   
    
}

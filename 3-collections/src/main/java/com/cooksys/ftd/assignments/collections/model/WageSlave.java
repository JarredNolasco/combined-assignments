package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class WageSlave implements Capitalist {

	private String wageSlaveName;
	private int wageSlaveSalary;
	private FatCat wageSlaveOwner;
	
    public WageSlave(String name, int salary) {
    	wageSlaveName = name;
    	wageSlaveSalary= salary;  
    }

    public WageSlave(String name, int salary, FatCat owner) {
    	wageSlaveName = name;
    	wageSlaveSalary= salary;  
    	wageSlaveOwner = owner;
    }

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((wageSlaveName == null) ? 0 : wageSlaveName.hashCode());
		result = prime * result + ((wageSlaveOwner == null) ? 0 : wageSlaveOwner.hashCode());
		result = prime * result + wageSlaveSalary;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WageSlave other = (WageSlave) obj;
		if (wageSlaveName == null) {
			if (other.wageSlaveName != null)
				return false;
		} else if (!wageSlaveName.equals(other.wageSlaveName))
			return false;
		if (wageSlaveOwner == null) {
			if (other.wageSlaveOwner != null)
				return false;
		} else if (!wageSlaveOwner.equals(other.wageSlaveOwner))
			return false;
		if (wageSlaveSalary != other.wageSlaveSalary)
			return false;
		return true;
	}

	/**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
        return wageSlaveName;
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
        return wageSlaveSalary;
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
    	
    	if (wageSlaveOwner != null)
    	{
    		return true;
    	}else{
    	
    		return false;
    	}
        
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
        
    	return wageSlaveOwner;
    }
}

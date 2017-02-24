package com.cooksys.ftd.assignments.collections.model;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FatCat implements Capitalist {

	private String fatCatName;
	private int fatCatSalary;
	private FatCat fatCatOwner;
	
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fatCatName == null) ? 0 : fatCatName.hashCode());
		result = prime * result + ((fatCatOwner == null) ? 0 : fatCatOwner.hashCode());
		result = prime * result + fatCatSalary;
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
		FatCat other = (FatCat) obj;
		if (fatCatName == null) {
			if (other.fatCatName != null)
				return false;
		} else if (!fatCatName.equals(other.fatCatName))
			return false;
		if (fatCatOwner == null) {
			if (other.fatCatOwner != null)
				return false;
		} else if (!fatCatOwner.equals(other.fatCatOwner))
			return false;
		if (fatCatSalary != other.fatCatSalary)
			return false;
		return true;
	}

	public FatCat(String name, int salary) {
        fatCatName = name;
        fatCatSalary = salary;
    }

    public FatCat(String name, int salary, FatCat owner) {
    	 fatCatName = name;
         fatCatSalary = salary;
         fatCatOwner = owner;
    }

    /**
     * @return the name of the capitalist
     */
    @Override
    public String getName() {
        return fatCatName;
    }

    /**
     * @return the salary of the capitalist, in dollars
     */
    @Override
    public int getSalary() {
        return fatCatSalary;
    }

    /**
     * @return true if this element has a parent, or false otherwise
     */
    @Override
    public boolean hasParent() {
        return fatCatOwner != null;
    }

    /**
     * @return the parent of this element, or null if this represents the top of a hierarchy
     */
    @Override
    public FatCat getParent() {
        return fatCatOwner;
    }
}

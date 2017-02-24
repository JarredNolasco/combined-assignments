package com.cooksys.ftd.assignments.objects;

import java.util.Random;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Rational implements IRational {
    /**
     * Constructor for rational values of the type:
     * <p>
     * `numerator / denominator`
     * <p>
     * No simplification of the numerator/denominator pair should occur in this method.
     *
     * @param numerator   the numerator of the rational value
     * @param denominator the denominator of the rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
	
	private int numerator ;
	private int denominator;
	
    public Rational(int numerator, int denominator) throws IllegalArgumentException {
    	
        if (denominator == 0 )
        {
        	throw new IllegalArgumentException();
        }
        
        this.numerator = numerator;
        this.denominator = denominator; 
    }

    /**
     * @return the numerator of this rational number
     */
    @Override
    public int getNumerator() {
       
    	return numerator; 
    }

    /**
     * @return the denominator of this rational number
     */
    @Override
    public int getDenominator() {
        return denominator;
    }

    /**
     * Specializable constructor to take advantage of shared code between Rational and SimplifiedRational
     * <p>
     * Essentially, this method allows us to implement most of IRational methods directly in the interface while
     * preserving the underlying type
     *
     * @param numerator the numerator of the rational value to construct
     * @param denominator the denominator of the rational value to construct
     * @return the constructed rational value
     * @throws IllegalArgumentException if the given denominator is 0
     */
    @Override
    public Rational construct(int numerator, int denominator) throws IllegalArgumentException {
        if(denominator == 0)
        {
         throw new IllegalArgumentException();	
        }
        return new Rational(numerator,denominator);
    }

  
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rational other = (Rational) obj;
		if (denominator != other.denominator)
			return false;
		if (numerator != other.numerator)
			return false;
		return true;
	}

    /**
     * If this is positive, the string should be of the form `numerator/denominator`
     * <p>
     * If this is negative, the string should be of the form `-numerator/denominator`
     *
     * @return a string representation of this rational value
     */
    @Override
    public String toString() {
    	
    	if ((numerator > 0) && (denominator > 0))
        	
    	{
        	return( numerator + "/" + denominator);
        }
    	
    	if ((denominator<0) && (numerator<0))
    	{
    		
    		numerator = Math.abs(numerator);
    		denominator = Math.abs(denominator);
    		return (numerator + "/" + denominator );
    	}
    	
        if ((numerator < 0) || (denominator < 0))
        {
        	
        	
        	if(numerator < 0)
        	{
        		numerator = Math.abs(numerator);
        	}else if(denominator < 0)
        	{
        		denominator = Math.abs(denominator); 
        	}
        	
        	
        	
        	return ( "-"+numerator + "/" + denominator );
        }
        
        return "";
    }
}

    
    


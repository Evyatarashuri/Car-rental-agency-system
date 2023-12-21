/**
 * This class represents a car with different attributes of a Car's rental program.
 * @author Evyatar Ashuri.
 * @version 20/11/2022
 */
public class Car
{
    private int _id; // ID the number of the car
    private char _type; // Rating the car by letter
    private String _brand; // The name of the car's brand
    private boolean _isManual; // The type of the car'gear 

    private final int DEFAULT_ID = 9999999; // The dafault id of the car
    private final int MAX_ID = 9999999; // The maximum number that id can be
    private final int MIN_ID = 1000000; // The minimum number that id can be   

    /**
     * Initialize a car object
     * id should be a 7 digits number, otherwise set it to 9999999
     * type should be 'A','B','C' or 'D', otherwise set it to 'A'
     * @param id the number id of the car( 7 digits number)
     * @param type the type of the car ('A','B','C' or 'D')
     * @param brand the name of the car's brand
     * @param isManual the type of the car's gear 
     */
    public Car (int id, char type, String brand, boolean isManual)// constructor
    {
        this._brand = brand; 
        this._isManual = isManual;

        if(id>=MIN_ID && id<=MAX_ID) 
        {
            this._id = id; // if id is valid
        }
        else
        {
            this._id = DEFAULT_ID; // default id = 9999999
        }

        if(type == 'A' || type == 'B' || type == 'C' || type == 'D')
            this._type = type; // if type is valid
        else
            this._type = 'A'; // default type 

    }

    /**
     * Copy constructor other Car
     * Constructs an object using the same values  
     * @param other The car object from which to construct the new car  
     */
    public Car (Car other) //copy constructor
    {
        this._id = other._id;
        this._type = other._type;
        this._brand = other._brand;
        this._isManual = other._isManual;
    }

    /**
     * Returns the id's number
     * @return ID number
     */
    public int getId() // Returns the id's number
    {
        return _id;
    }

    /**
     * Returns the type of the car
     * @return Type of the car
     */
    public char getType() // Returns the type of the car
    {
        return _type;
    }

    /**
     *Returns the brand name of the car
     *@return Brand name of the car 
     */
    public String getBrand() // Returns the brand name of the car
    {
        return _brand;
    }

    /**
     * Returns if the car's gear of the car is manual
     * @return Is the gear type is manual 
     */
    public boolean isManual() // Returns if the car's gear of the car is manual
    {
        return _isManual;   
    }

    /**
     * Sets the id's number to the new given id
     * only if the given ID number is valid 
     * @param id the id value to be set
     */
    public void setId(int id) // Sets the id's number to the new given id
    {
        if(id>=MIN_ID && id<=MAX_ID) // cheking for valid id
        {
            this._id = id; // only this._id is valid, not returning default id
        }
    }

    /**
     *Sets the type 
     *only if the given type is valid
     *@param type the type value to bee set
     */
    public void setType(char type) // Sets the type,only if the given type is valid.
    {
        if(type == 'A' || type == 'B' || type == 'C' || type == 'D')
        {
            this._type = type; // only this._type is valid, not returning default type
        }
    }

    /**
     * Sets the brand of the car 
     *@param brand the brand value to be set
     */
    public void setBrand(String brand) // Sets the brand of the car
    {
        if(brand != null) // user cannot enter null to the program
        {
            this._brand = brand; 
        }
    }

    /**
     *Sets the isManual flag of the car
     *@param manual the isManual flag of the car 
     */
    public void setIsManual(boolean manual) // Sets the isManual flag of the car.
    {
        this._isManual = manual;
    }

    /**
     * Returns a String object that represents this car
     * @return String that represents this car by it's all is attributes 
     */
    public String toString() //String method 
    {
        if(_isManual == true) // cheking if the car is manual 
        {
            return("id:" +_id + " type:" + _type + " brand:" + _brand + " gear:" + "manual"); // manual gear
        }
        else
        {
            return ("id:"+_id + " type:" +_type + " brand:" + _brand + " gear:" + "auto"); // auto gear 
        }
    }

    /**
     * Returns if two cars are the same 
     * Cars are considered the same if they have the same type, brand and gear
     * @param other the car to compare this car to
     * @return true if the cars are the same, otherwise false
     */
    public boolean equals (Car other) //equals method 
    {
        return _brand.equals(other._brand) && _isManual == other._isManual && _type == other._type; 
    }

    /**
     * Check if this car is better than the other car
     * A car is considered better than another car if its type is higher.
     * If both cars have the same type, an automated car is better than a manual car.
     * @param other The car to compare this car to 
     * @return true if this car is better than the other car, otherwise false
     */
    public boolean better (Car other) //better method 
    {
        if(this._type > other._type) // checking for a better type
        {
            return(true);
        }
        else if(this._type == other._type) // if types are equals 
        {
            if(this._isManual == true && other._isManual == true) // checking if both regular gear  
            {
                return(false);
            }
            else if(this._isManual == false && other._isManual == true)
            {
                return(true);
            }
            else 
            {
                return(false); 
            }
        }

        else
        {
            return(false);// same type and both automatic car
        }
    }

    /**
     * Check if this car is worse than the other car
     * @param other car to compare this car to 
     * @return true if this car is worse than the other car, otherwise false
     */
    public boolean worse (Car other)//worse method
    {
        return other.better(this); // the opposite of method better by method signature - worse 
    }
}

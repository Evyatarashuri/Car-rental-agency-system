/**
 * This class represents a Rent object.
 * @author Evyatar Ashuri.
 * @version 30/11/2022 
 */
public class Rent
{
    private String _name; // The name of the person who's renting the car.
    private Car _car; // The object of the Car class that displays the features of the car.
    private Date _pickDate; // Date of start of rental.
    private Date _returnDate; // Date of end of rental.

    private  final int PRICE_A = 100; // Price per day of type A car.
    private  final int PRICE_B = 150; // Price per day of type B car.
    private  final int PRICE_C = 180; // Price per day of type C car.
    private  final int PRICE_D = 240; // Price per day of type D car.

    private final double DISCOUNT_FULL_WEEK = 0.1; // Discount on weekly car rental.
    private final int DAYS_IN_WEEK = 7; // days in week. 

    /**
     * Creates a new Rent object
     * <p>
     * The return date must be at least one day after the pickup date,
     * <p>
     * otherwise set it to one day after the pick up date.
     * @param name name of the person who's renting the car.
     * @param car the rented car.
     * @param pick the pickup date. 
     * @param ret the return date.
     */
    public Rent (String name, Car car, Date pick, Date ret) // Creates a new Rent object.
    {
        this._name = name;
        this._car = new Car (car);
        this._pickDate = new Date (pick);

        if (new Date (ret).before(this._pickDate)) //checking if ret (user attribute) before pickDate (our attribute) 
        {
            this._returnDate = pick.tomorrow(); // if true - adding the method tomorrow to pick (user) and apply to returnDate (our)
        }
        else if(_pickDate.equals(ret)) // checking if pickDate equals to ret
        {
            this._returnDate = pick.tomorrow(); // if true - adding the method tomorrow to pick (user) and apply to returnDate (our)   
        }
        else
            this._returnDate = new Date (ret);    
    }

    /**
     * Copy constructor.
     * @param other the rent to be copied.
     */
    public Rent (Rent other) // Copy constructor. 
    {
        this._name = other._name;
        this._car = new Car (other._car);
        this._pickDate = new Date (other._pickDate);
        this._returnDate = new Date (other._returnDate);
    }

    /**
     * Gets the name
     * @return The name.
     */
    public String getName() // Gets the name
    {
        return _name;
    }

    /**
     * Sets the client name.
     *@param name the client name.
     */
    public void setName(String name) // Sets the client name.
    {
        _name = name;
    }

    /**
     * Gets the car.
     * @return The car.
     */
    public Car getCar() // Gets the car.
    {
        return new Car(_car);
    }

    /**
     * Sets the rented car.
     * @param car the rented car 
     */
    public void setCar(Car car) // Sets the rented car.
    {
        _car = new Car(car);
    }

    /**
     * Gets the pick up date.
     * @return The pick up date.
     */
    public Date getPickDate() // Gets the pick up date.
    {
        return new Date(_pickDate);
    }

    /**
     * Sets the pick up date.
     * <p>
     * The pick up date must be at least one day before the return date,
     * <p>
     * otherwise - don't change the pick up date.
     * @param pick The pick up date.
     */
    public void setPickDate(Date pick) // Sets the pick up date.
    {
        if (pick.before(_returnDate)) // pick must to be before the returnDate
        {
            _pickDate = new Date(pick);
        }
    }

    /**
     * Gets the return date.
     * @return The returnDate. 
     */
    public Date getReturnDate() // Gets the return date.
    {
        return new Date(_returnDate);
    }

    /**
     * Sets the return date.
     * <p>
     * The return date must be at least one day after the pick up date,
     * <p>
     * otherwise - don't change the return date.
     * @param ret the return date.
     */
    public void setReturnDate(Date ret) // Sets the return date
    {
        if (_pickDate.before(ret)) // pickDate (our attribute) must to be before ret (user attribute)
        {
            _returnDate = new Date(ret);
        }
    }

    /**
     * Check if 2 rents are the same.
     * @param other the rent to compare this rent to.
     * @return true if the rents are the same.
     */
    public boolean equals (Rent other) // Check if 2 rents are the same.
    {
        if(this._name.equals(other._name) && this._pickDate.equals(other._pickDate)
        && this._returnDate.equals(other._returnDate) && this._car.equals(other._car)) 
        {
            return true; // if all the attributes are equals
        }
        else
        {
            return false;
        }   
    }

    /**
     * Checks the difference in days between the car rental date and the car return date.
     * @return The number of rent days.
     */
    public int howManyDays() // Numbers of rent days.
    {
        return this._returnDate.difference(this._pickDate);
    }

    /**
     * Returns the rent total price.
     * @return The rent total price.
     */
    public int getPrice() // Method that return the rent total price by using the private method getPrice
    {
        return getPrice(this._car.getType()); //using the method  getType from the class Car to give the type of the car
    }

    private int getPrice(char type) // A private method that calculate and return the rent total price. 
    {
        int totalDays = howManyDays(); // Declare a new variable "totalDays" and using the method: howManyDays 
        int price = totalDays * pricePerDay(type); // Declare a new variable "price" 
        int pricePerWeek = pricePerDay(type) * DAYS_IN_WEEK; // Declare a new variable "pricePerWeek" 
        int weekCounter = totalDays / DAYS_IN_WEEK; // Declare a new variable "weekCounter" 
        price -= (int)(weekCounter * DISCOUNT_FULL_WEEK * pricePerWeek);
        // getting the price by multiply the weekCounter, DISCOUNT_FUUL_WEEK and pricePerWeek and subtract
        // the Final calculation by the price.

        return price;
    }

    /**
     * Try to upgrade the car to a better car.
     * <p>
     * If the given car is better than the current car of the rent,
     * <p>
     * upgrade it and return the upgrade additional cost,
     * <p>
     * otherwise - don't upgrade.
     * @param newCar the car to upgrade to.
     * @return The upgrade cost.
     */
    public int upgrade(Car newCar)
    {
        if (!newCar.better(_car)) //checking if the newCar(user car) is not better  
        {
            return 0; // not better 
        }

        int increase = getPrice(newCar.getType()) - getPrice(_car.getType());
        _car = new Car(newCar); // calculate the extra cash to add to the payment. 

        return increase;
    }

    /**
     * This method checks if there is a double rental registration in the system.
     * <p>
     * If there is a duplicate registration,
     * <p>
     * the method will return a new object of type Rent with the same name and car as the object on which the method operates.
     * @param other the other rent.
     * @return The unified rent or null. 
     */
    public Rent overlap(Rent other) // Check if there is a double listing of a rent 
    {   
        if (!other._name.equals(_name) || !_car.equals(other._car))  
        {
            return null; // if the name or the car is not equals 
        }

        if (_pickDate.after(other._returnDate) || other._pickDate.after(_returnDate)) 
        {
            return null; // if there is no overlap between the rental dates
        }
        
        Date pick = _pickDate.before(other._pickDate) ? _pickDate : other._pickDate;
        Date ret = _returnDate.after(other._returnDate) ? _returnDate : other._returnDate;
        return new Rent(_name, _car, pick, ret); // return a new Rent object.
    }  

    private int pricePerDay(char type) // A private method that returns the price per day based on the type of the car.
    {
        switch (type)
        {
            case 'A':
                return PRICE_A; //price A = 100
            case 'B':
                return PRICE_B; //price B = 15
            case 'C':
                return PRICE_C; //price C = 180
            default:
                return PRICE_D; //price D = 240
        }
    }

    /**
     * Returns a String that represents this rent.
     * @return String that represents this rent in the following format:
     * Name:Evyatar From:30/10/2022 To:12/11/2022 Type:B Days:13 Price:1845
     */
    public String toString() //String method to print 
    {
        return "Name:" + _name + " From:" + _pickDate.toString() + " To:" + _returnDate + " Type:" + _car.getType() + " Days:" + _returnDate.difference(_pickDate) + " Price:" + getPrice();
    }
}

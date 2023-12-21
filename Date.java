/**
 * This class represents a Date object of a Car's rental program.
 * @author Evyatar Ashuri. 
 * @version 23/11/2022
 */
public class Date
{
    private int _day; // the day in a full date
    private int _month;// the month in a full date
    private int _year;// the year in a full date

    private final int  DEFAULT_DAY = 1; // the day in default date 
    private final int  DEFAULT_MONTH = 1; // the month in default date 
    private final int  DEFAULT_YEAR = 2000; // the year in default date 

    private final int MIN_DAY = 1; // minimum day in a month 
    private final int MAX_DAY = 31; // maximum day in a month
    private final int MIN_MONTH = 1; // minimum month in a year
    private final int MAX_MONTH = 12; // maximum month in a year 
    private final int MIN_YEAR = 1000; // minimum year in 4 digits
    private final int MAX_YEAR = 9999; // maximum year in 4 digits
    private final int JAN = 1; // month January
    private final int FEB = 2; // month February
    private final int MAR = 3; // month March
    private final int APR = 4; // month April
    private final int MAY = 5; // month May
    private final int JUN = 6; // month June
    private final int JUL = 7; // month July
    private final int AUG = 8; // month August
    private final int SEP = 9; // month September
    private final int OCT = 10; // month October
    private final int NOV = 11; // month November
    private final int DEC = 12; // month December
    private final int MIN_DAY_STR = 1; // minimum days in the method ToString
    private final int MAX_DAY_STR = 9; // maximum days in the method ToString
    private final int MIN_MONTH_STR = 1; // minimum months in the method ToString
    private final int MAX_MONTH_STR = 9; // maximum months in the method ToString

    /**
     * If the given date is valid - creates a new Date object,
     * otherwise creates the date 1/1/2000
     * @param day the day in month (1-31)
     * @param month the month in the year 
     * @param year the year (4 digits)
     */
    public Date (int day, int month, int year) // constructor 
    {
        if(validDate(day, month, year) == true) // returns true if validDate is true
        {
            this._day = day;
            this._month = month;
            this._year = year;
        }
        else // false for the validDate, getting the defaults date
        {
            this._day = DEFAULT_DAY;
            this._month = DEFAULT_MONTH;
            this._year = DEFAULT_YEAR;
        }
    }

    private boolean validDate(int day, int month, int year) // method ValidDate check if the given date is valid
    {
        if(day >= MIN_DAY && day <=MAX_DAY && month >= MIN_MONTH && month <= MAX_MONTH && year >= MIN_YEAR && year <= MAX_YEAR)  
        {
            if(month == JAN || month == MAR || month == MAY || month == JUL || month == AUG  || month == OCT || month == DEC) // months with 1 to 31 days
            {  
                if(day >= MIN_DAY && day <= MAX_DAY)
                {
                    return(true);    
                } 
                else
                {
                    return(false);
                }
            }
            else if(month == APR || month == JUN || month == SEP || month == NOV) // months with 1 - 30 days 
            {
                if(day >= MIN_DAY && day <= 30)
                {
                    return(true);  
                }
                else
                {
                    return(false);
                }
            }
            else if(month == FEB) // month with days by 1 - 28/29. 
            {  
                if(leapYear(year) == true) // checking if leap year 
                {
                    if(day >= MIN_DAY && day <= 29)
                    {
                        return(true);
                    }
                    else
                    {
                        return(false);
                    }
                } 
                else{ //NON LEAP YEAR
                    if(day >= MIN_DAY && day <= 28) //  day can be 1-28 on February 
                    {
                        return(true);
                    }

                    else
                    {
                        return(false);
                    }
                }
            }
            else
            {
                return(false);
            }
        }
        else // validDate (day, month, year)
        {
            return false;
        }
    }

    /**
     * Copy constructor 
     * @param other the date to be copied
     */
    public Date (Date other)//Copy constructor 
    {
        this._day = other._day;
        this._month = other._month;
        this._year = other._year;
    }

    /**
     * this method check if the given year is a leap year.
     * by dividing the year by 400, 100 and 4.
     * @param year the given year.
     * @return true if the year is a leap year, false if doesn't
     */
    private boolean leapYear(int year) // this method check if the given year is a leap year.
    {
        if(( year % 400) == 0) //dividing the year by 400 return a leap year 
        {
            return true;
        }
        else if ((year % 100) == 0) // if the year divided by 400 and also dividing by 100 the year isn't a leap year 
        {
            return false;
        }
        else if ((year % 4) == 0) // if the year is divided by 400,100 and 4 the year will be a leap year 
        {
            return true; 
        }
        else
        {
            return false; // not dividing at all by the numbers 
        }
    }

    /**
     * Gets the day
     * @return the day 
     */
    public int getDay() // Gets the day
    {
        return _day;
    }

    /**
     * Gets the month
     * @return the month 
     */
    public int getMonth() // Gets the month
    {
        return _month;
    }

    /**
     * Gets the year
     * @return the year
     */
    public int getYear() //Gets the year
    {
        return _year;
    }

    /**
     * Set the day (only if date remains valid)
     * @param dayToSet the date value to be set 
     */
    public void setDay(int dayToSet) // set the day
    {
        if(validDate(dayToSet,_month,_year) == true)
        {
            this._day = dayToSet;
        } 
    }

    /**
     * Set the month (only if date remains valid)
     * @param monthToSet the month value to be set
     */
    public void setMonth(int monthToSet) // Set the month 
    {
        if(validDate(_day,monthToSet,_year) == true)
        {
            this._month = monthToSet;
        } 
    }

    /**
     * Sets the year (only if date remains valid)
     * @param yearToSet the year value to be set
     */
    public void setYear(int yearToSet) // Sets the year 
    {
        if(validDate(_day,_month,yearToSet) == true)
        {
            this._year = yearToSet;
        } 
    }

    /**
     * Check if 2 dates are the same
     * @param other the date to compare this date to
     * @return true if the dates are the same, otherwise false
     */
    public boolean equals (Date other) // Check if 2 dates are the same
    {
        if(this._day == other._day && this._month == other._month
        && this._year == other._year)
        {
            return true; // return true if : day, month, year are equals to other date
        }
        else
        {
            return false;
        }
    }

    /**
     * Check if this date is before other date
     * @param other date to compare this date to
     * @return true if this date is before other date, otherwise false
     */
    public boolean before (Date other) // Check if this date is before other date
    {
        if(this._year < other._year)         
        {
            return true;
        }
        else if(this._year > other._year)
        {
            return false;
        }   
        else if(this._month < other._month)
        {    
            return true;
        }
        else if(this._month > other._month)
        {
            return false;
        }
        else if(this._day < other._day)
        {
            return true;
        }
        else
        {
            return false; // Date other is before
        }
    }

    /**
     * Check if this date is after other date 
     * @param other date to compare this date to
     * @return true if this date is after other date, otherwise false
     */
    public boolean after (Date other) // Check if this date is after other date
    {
        return other.before(this); // using the before method on this to calculate if other is before  
    }

    private int calculateDate ( int day, int month, int year) // Calculates the number of days that have passed since the beginning counting
    {
        if (month < 3) {
            year--;
            month = month + 12;
        }
        return 365 * year + year/4 - year/100 + year/400 + ((month+1) * 306)/10 + (day - 62);
    }

    /**
     * Calculates the difference in days between two dates
     * @param other the date to calculate the difference between
     * @return the number of days between the dates (non negative value)
     */
    public int difference (Date other) // Calculates the difference in days between two dates
    {
        int day, month, year;

        return (Math.abs(calculateDate(this._day , this._month , this._year) - // Using the Math.abs on each dates and subtract them
                (calculateDate(other._day , other._month ,other._year)))); 
    }

    /**
     * Calculate the date of tomorrow and checking if the 
     * given date is valid by the method ValidDate.
     * @return the date of tomorrow
     */
    public Date tomorrow() // Calculate the date of tomorrow
    { 
        Date tomorrow = new Date (this);
        if(validDate(_day+1,_month,_year))  
        {
            return new Date(_day+1,_month,_year);
        }   // Adding only 1 for day, month and year staying the same
        else
        {
            if(validDate(_day=1,_month+=1,_year))
            {
                return new Date (_day,_month,_year);
            } // Adding 1 for day and 1 for month, year staying the same

            if(validDate(_day=1,_month=1,_year+=1))
            {
                return new Date (_day,_month,_year);
            }            
            else
            {                                 
                return new Date (_day,_month,_year); // the date isn't valid 
            }
        }
    }

    /**
     *Returns a String that represents this date
     *@return String that represents this date in the following format:
     * day (2 digits) / month(2 digits) / year (4 digits) 
     */
    public String toString() // String that represents this date
    {
        if (_day >=MIN_DAY_STR && _day <=MAX_DAY_STR && _month >=MIN_MONTH_STR && _month <=MAX_MONTH_STR) 
        {
            return ("0"+_day+"/"+"0"+_month+"/"+_year); // retun if day & month added from 1-9 without "0" this return add "0" to the string
        }
        else if (_month >=MIN_MONTH_STR && _month <=MAX_MONTH_STR)
        {
            if (_day > MAX_DAY_STR)
            {
                return (_day+"/"+"0"+_month+"/"+_year); // day is bigger than 9 and month is 1-9, only month getting "0"
            }
            else 
            {
                return ("0"+_day+"/"+"0"+_month+"/"+_year);
            }
        }    
        else if (_day >=MIN_DAY_STR && _day <=MAX_DAY_STR)
        {
            return ("0"+_day+"/"+_month+"/"+_year); // month is bigger than 9 and day is 1-9, only day getting "0"
        }
        else 
        {
            return (_day+"/"+_month+"/"+_year); // day and month above 9
        }
    }
}

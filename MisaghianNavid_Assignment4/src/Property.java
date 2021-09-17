// * Class: CMSC203
// * Instructor: Dr. Ahmed Tarek
// * Description: Make a rent and area program that deteirmines the psacing of the land around an area and if you can build an apartment there or not
// * Due: ~
// * Platform/compiler: IntelliJ Ji
// * I pledge that I have completed the programming assignment independently.
//   I have not copied the code from a student or any source.
//   I have not given my code to any student.
//   Print your Name here: __Navid Misaghian__________

public class Property {

    //string variables to be used within method

    private java.lang.String city;

    private java.lang.String owner;

    private java.lang.String propertyName;

    private double rentAmount;

    private Plot plot;


    /**
     * This is the start of my property class, The class Property will contain:
     * 1.	Instance variables for property name, city, rental amount, owner, and plot.  Refer to JavaDoc for the data types of each instance variable.
     * 2.	toString method to represent a Property object.
     * 3.	Constructors (a copy constructor and parameterized constructor) and getter and setter methods. One parameterized constructor
     * will have parameters for property name, city, rent amount, owner, x and y location of the upper left corner of the property’s plot,
     * the plot’s width and its depth. A second constructor will only have parameters for name, city, rental amount, and owner, and will generate a default x, y, width, and depth.
     *
     */

    public
    Property ( ) {
//INTAALIZE MY VARAIBLES

        city = new String ();
//city
        owner = new String ();
//owner
        propertyName = new String ();
//preopertyname
        rentAmount = 0.0;
//rentacmout

        plot = new Plot ();
        //plot
    }

    /**
     * Method to copy construcot htat copy's infor that is
     * passed to it
     *
     * @param p
     */
    public
    Property ( Property p ) {

        this.city = p.getCity ();
//city
        this.owner = p.getOwner ();
//owner
        this.propertyName = p.getPropertyName ();
//get the property name
        this.rentAmount = p.getRentAmount ();
//rent amount
        this.plot = p.getPlot ();
        //get the plot
    }

    /**
     * this is the propert moethod that sets the name cit and owner
     *
     * @param propertyName
     * @param city
     * @param rentAmount
     * @param owner
     */


    public
    Property ( String propertyName, String city, double rentAmount, String owner ) {

        this.propertyName = propertyName;

        this.city = city;

        this.rentAmount = rentAmount;

        this.owner = owner;

        this.plot = new Plot ();
    }

    /**
     * this is the contination for the proeprty method duplicate that will be abvle to set the dimesnions
     */

    public
    Property ( String propertyName, String city, double rentAmount, String owner,
               int x, int y, int width, int depth ) {

        this.propertyName = propertyName;

        this.city = city;

//Accquire proerty name

        this.rentAmount = rentAmount;

        this.owner = owner;

        ///Set the dimensions

        this.plot =
                new Plot ( x,
                        y,
                        width,
                        depth );

    }


    public
    String getCity ( ) {
        return city;
    }

    public
    void setCity ( java.lang.String city ) {
        this.city = city;
    }

    public
    String getOwner ( ) {
        return owner;
    }

    public
    void setOwner ( java.lang.String owner ) {
        this.owner = owner;
    }

    public
    String getPropertyName ( ) {
        return propertyName;
    }

    public
    void setPropertyName ( java.lang.String propertyName ) {
        this.propertyName = propertyName;
    }

    public
    double getRentAmount ( ) {
        return rentAmount;
    }

    public
    void setRentAmount ( double rentAmount ) {
        this.rentAmount = rentAmount;
    }


    public
    Plot getPlot ( ) {
        return plot;
    }

    public
    void setPlot ( int x, int y, int width, int depth ) {
        this.plot = new Plot( x, y, width, depth );
    }


    @Override

    public
    java.lang.String toString ( ) {

        return String.format ( "Property Name: %d \n Located in %d \n Belonging to: %d \n"

                               + "Rent Amount: %d \n "

                ,
                propertyName ,
                city ,
                owner ,
                rentAmount );


    }
}


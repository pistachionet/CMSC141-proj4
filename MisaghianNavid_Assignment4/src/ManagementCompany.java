public class ManagementCompany {

    private final int
            MAX_PROPERTY
            =5;
    private final int
            MGMT_WIDTH
            =10;
    private final int
            MGMT_DEPTH
            =10;
    private double
            mgmFeePer;
    private String
            name;
    private Property[]
            properties;


    private String taxID;

    private Plot plot;

    /**
     * Public MangementCompany method sets the properties and texID of the strings
     */
    public ManagementCompany(){

        mgmFeePer = 0.0;

        name = new String();

        properties = new Property[MAX_PROPERTY];

        taxID = new String();

        plot = new Plot();
    }

    public ManagementCompany( java.lang.String name , java.lang.String taxID ,
                              double mgmFee ) {
        this.name
                =name;
        this.taxID
                =taxID;
        this.mgmFeePer
                =mgmFee;
        this.plot
                =new Plot ( );
        this.properties
                =new Property[MAX_PROPERTY];

    }

    /**
     * public MangmentCompany class declartion
     * @param name
     * @param taxID
     * @param mgmFee
     * @param x
     * @param y
     * @param width
     * @param depth
     */

    public ManagementCompany( String name , String taxID , double mgmFee , int x , int y ,
                              int width , int depth ) {
        this.name
                =name;
        this.taxID
                =taxID;
        this.mgmFeePer
                =mgmFee;
        this.plot
                =new Plot (
                x ,
                y ,
                width ,
                depth );
        this.properties
                =new Property[MAX_PROPERTY];
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        Plot otherCompanyPlot = otherCompany.getPlot();

        this.name = otherCompany.getName();

        this.taxID = otherCompany.getTaxID();

        this.mgmFeePer = otherCompany.getMgmFeePer();

        this.plot = new Plot(otherCompanyPlot.getX(), otherCompanyPlot.getY(),
                otherCompanyPlot.getWidth(), otherCompanyPlot.getDepth());

        this.properties = new Property[MAX_PROPERTY];
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public void setMgmFeePer(double mgmFeePer) {
        this.mgmFeePer = mgmFeePer;
    }
//instaianting
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public String getTaxID() {
        return taxID;
    }

    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }

    public Plot getPlot() {
        return plot;
    }

    public void setPlot(Plot plot) {
        this.plot = plot;
    }

    public int getMAX_PROPERTY() {
        return MAX_PROPERTY;
    }

    public int getMGMT_WIDTH() {
        return MGMT_WIDTH;
    }

    public int getMGMT_DEPTH() {
        return MGMT_DEPTH;
    }

    public int addProperty(Property property) {

        if(this.properties[MAX_PROPERTY - 1] != null) {
            return -1;
        }

        //if property is null return -2
        if(property == null) {
            return -2;
        }

        //if plot is not contained return -3
        if(this.plot.encompasses(property.getPlot()) == false) {
            return -3;
        }

        //if plot is overlaps with existing plot -4
        for(Property prop : this.properties) {

            if(prop == null) {
                break;
            }

            if(prop.getPlot().overlaps(property.getPlot())){
                return -4;
            }

        }

        //else return index
        int idx;
        for(idx = 0; idx < MAX_PROPERTY; idx++) {
            if(this.properties[idx] == null) {
                this.properties[idx] = new Property(property);

                break;
            }


        }
        return idx;
    }

    @SuppressWarnings("unused")
    public
    int addProperty( String name , String City , double rent , String Owner ) {

        int
                idx
                =0;

        Property
                prop
                =new Property (
                name ,
                City ,
                rent ,
                Owner
        );

        //if array is full return -1
        if (this.properties[MAX_PROPERTY -
                            1] !=
            null) {
            return -1;
        }

        //Create null property method to be able to get the prospective code

        if (prop ==
            null) {
            return -2;
        }

        //if plot is not contained return -3
        if (this.plot.encompasses ( prop.getPlot ( ) ) ==
            false) {
            return -3;
        }

        //if plot is overlaps with existing plot -4
        for(Property p : this.properties) {

            if(p == null) {
                break;
            }

            if(p.getPlot().overlaps(prop.getPlot())){
                return -4;
            }

        }

        //else return index
        for(; idx < MAX_PROPERTY; idx++) {
            if(this.properties[idx] == null) {
                this.properties[idx] = new Property(prop);

                break;
            }


        }
        return idx;

    }

    public int addProperty(String name, String City, double rent, String Owner, int x, int y, int width, int depth){

        int idx = 0;

        Property prop = new Property(name, City, rent, Owner, x, y, width, depth);

        //if array is full return -1
        if(this.properties[MAX_PROPERTY - 1] != null) {
            idx = -3;

        }

        //This is the property manager that returns the number -2 for the methoid
        if(prop == null) {
            idx = -2;
        }

        //if plot is not contained return -3
        if(this.plot.encompasses(prop.getPlot()) == false) {
            idx = -4;

        }

        //if plot is overlaps with existing plot -4
        for(Property p : this.properties) {

            if(p == null) {
                break;
            }

            if(p.getPlot().overlaps(prop.getPlot())){
                idx = -4;

            }

        }

        //else return index
        for(; idx < MAX_PROPERTY; idx++) {
            if(this.properties[idx] == null) {
                this.properties[idx] = new Property(prop);

                break;
            }

            return idx;
        }

        return idx;
    }




    public double totalRent() {

       //Have the total rent be set
        double total = 0;

        //have the for loop
        for(int idx = 0; idx < MAX_PROPERTY; idx++){

            if(properties[idx] != null) {
                //sets the value of total as plus each amount of rent on each property
                total += properties[idx].getRentAmount();

            }
        }



       //return the total
        return total;
    }

    public double maxRentProp() {


        double maxRent = 0.0;

        String rent = new String();

        for(int idx = 0; idx < MAX_PROPERTY; idx++) {
            //go into array at current iteration
            if(maxRent < properties[idx].getRentAmount()) {

                maxRent = properties[idx].getRentAmount();

            }
        }
        rent = Double.toString(maxRent);
        return maxRent;
    }


    public int maxRentPropertyIndex() {
        int maxRentIdx = 0;

        double temp = properties[0].getRentAmount();

        for(int idx = 0; idx < MAX_PROPERTY; idx++) {
            //go into array at current iteration
            if(temp < properties[idx].getRentAmount()) {

                maxRentIdx = idx;

                temp = properties[idx].getRentAmount();
            }
        }

        //return maxRentIdx
        return maxRentIdx;
    }

    public String displayPropertyAtIndex(int i) {

        //string to hold property information
        String propInfo = new String();

        if(properties[i] != null) {
            propInfo = ("Owner: " + properties[i].getOwner() +
                    "City: " + properties[i].getCity() +
                    "Property Name: " + properties[i].getPropertyName() +
                    "Rent Amount: " + properties[i].getRentAmount() +
                    "Plot: " + properties[i].getPlot() );
        }

        return propInfo;


    }

    @Override
    public String toString() {

        String printPropInfo = new String();
        System.out.println("List of the properties for Alliance, taxID: " + taxID);

        System.out.println("__________________");

        for (int i = 0; i < MAX_PROPERTY; i++) {
            if (properties[i] != null) printPropInfo =
                    (
                            " Property Name: " +
                                    properties[i].getPropertyName() +
                                    "\n" +
                                    " Located in: " +
                                    properties[i].getCity() +
                                    "\n" +
                                    " Belonging to: " +
                                    properties[i].getOwner() +
                                    "\n" +
                                    " Rent Amount: " +
                                    properties[i].getRentAmount()
                    );
        }

        System.out.println("__________________");
        System.out.println("Total management Fee: " + mgmFeePer);

        return printPropInfo;
    }
}




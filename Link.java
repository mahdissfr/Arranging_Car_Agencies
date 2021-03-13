package aut.ir;


public class Link {

    public String name;
    public Link next;
    public Link subserviceLink;
    public int counter;
    public int cost;
    public String descriptionForCustomer;
    public String descriptionForAgency;
    public String model;

    //Link constructor
    public Link(String name,String descriptionForCustomer ,String descriptionForAgency ,String model, int cost) {
        this.descriptionForAgency=descriptionForAgency;
        this.descriptionForCustomer=descriptionForCustomer;
        this.cost=cost;
        this.model=model;
        this.name=name;
        next = null;
        subserviceLink = null;
        counter=0;
    }

    public void setCounter() {
        counter += 1;
    }
}

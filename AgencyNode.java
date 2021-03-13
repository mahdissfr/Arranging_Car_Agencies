package aut.ir;

import java.util.ArrayList;

public class AgencyNode {

    public String name;
    public AgencyNode next;
    public ArrayList<Link> agencysServices;

    //Link constructor
    public AgencyNode(String agencysName) {
        name=agencysName;
        next = null;
        agencysServices=new ArrayList<>();
    }
}

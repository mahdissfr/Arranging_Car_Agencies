package aut.ir;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mahdis on 12/14/2017.
 */
public class AgencyList {

    public AgencyNode first;

    public AgencyNode getFirst() {
        return first;
    }

    public void setFirst(AgencyNode first) {
        this.first = first;
    }


    //LinkList constructor
    public AgencyList() {
        setFirst(null);
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    //Inserts a new Link at the first of the list
    public void addAgency(String agencyName) {
        AgencyNode agencyNode = new AgencyNode(agencyName);
        agencyNode.next = getFirst();
        setFirst(agencyNode);
        System.out.println(getFirst().name);

    }


    public Link search(String serviceName,LinkList linkList){
        Link currnet=linkList.first;
        while (currnet!=null){
            if(currnet.name.equals(serviceName))
                break;
            currnet=currnet.next;
        }
        return currnet;
    }

    public void addOffer(String serviceName, String agencyName,LinkList linkList) {
        Link toAdd=search(serviceName,linkList);
        if(toAdd==null){
            Scanner scanner=new Scanner(System.in);
            System.out.println("there is no service named "+serviceName);
            return;
        }
        AgencyNode agency = findagency(agencyName);
        if (agency == null) {
            System.out.println("there is not any agency named " + agencyName);
            return;
        }
        ArrayList<Link> servicesList = agency.agencysServices;
        if (validService(serviceName, servicesList)!=-1) {
            System.out.println("it was has been added");
            return;
        }
        servicesList.add(toAdd);
        toAdd.setCounter();
    }

    private AgencyNode findagency(String agencyName) {
        if (isEmpty()) {
            return null;
        }

        AgencyNode current = getFirst();
        while (current != null) {
            if (current.name.equals(agencyName)) {
                break;
            }
            current = current.next;
        }
        return current;
    }

    public int validService(String serviceName, ArrayList<Link> agencysServices) {
        Link tmp;
        for (int i = 0; i < agencysServices.size(); i++) {
            tmp = agencysServices.get(i);
            if (tmp.name.equals(serviceName))
                return i;
        }
        return -1;
    }

    public void listagencies(LinkList linkList) {
        AgencyNode current = getFirst();
        while (current != null) {
            System.out.println("agency: "+current.name);
            if(current.agencysServices.size()>0)
                 System.out.println(current.agencysServices.get(0).name);

            for (Link eachNode:current.agencysServices
                 ) {
                System.out.println("{");
                linkList.listServicesFrom(eachNode.name);
                System.out.println("}");
            }
            current = current.next;
        }
    }
    public void delete(String serviceName,String agencyName,LinkList linkList){
        AgencyNode agency = findagency(agencyName);
        if (agency == null) {
            System.out.println("there is not any agency named " + agencyName);
            return;
        }
        ArrayList<Link> servicesList = agency.agencysServices;
        int tmp=validService(serviceName, servicesList);
        if (tmp!=-1) {
            Link del=servicesList.get(tmp);
            if(--del.counter==0)
                linkList.deleteService(serviceName);
            servicesList.remove(tmp);

        }
    }

}

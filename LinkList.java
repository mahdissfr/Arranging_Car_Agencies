package aut.ir;

/**
 * Created by mahdis on 12/14/2017.
 */
public class LinkList {

    public Link first;

    //LinkList constructor
    public LinkList() {
        first = null;
    }

    //Returns true if list is empty
    public boolean isEmpty() {
        return first == null;
    }

    public Link getFirst() {
        return first;
    }

    //Inserts a new Link at the first of the list
    public void addService(String name,String descriptionForCustomer ,String descriptionForAgency ,String model, int cost) {
        Link link = new Link(name,descriptionForCustomer ,descriptionForAgency ,model,cost);
        link.next = first;
        first = link;
    }


    public void addsubservice(String subserviceName, String serviceName,String descriptionForCustomer ,String descriptionForAgency ,String model, int cost) {
        Link tmp = findService(serviceName, getFirst());
        if (tmp == null)
            System.out.println("there is not a " + serviceName + " service");
        else {
            addToDlink(tmp, subserviceName,descriptionForCustomer,descriptionForAgency,model,cost);
        }

    }

    private void addToDlink(Link service, String subservice,String descriptionForCustomer ,String descriptionForAgency ,String model, int cost) {
        Link nextNode = service.subserviceLink;
        service.subserviceLink=new Link(subservice,descriptionForCustomer,descriptionForAgency,model,cost);
        service.subserviceLink.next=nextNode;

    }

    public Link findService(String serviceName, Link firstLink) {
        if (firstLink == null) {
            return null;
        }

        Link current = firstLink;
        while (current != null) {
            if (current.name.equals(serviceName)) {
                break;
            }

            if (current.subserviceLink != null) {
                Link tmp = findService(serviceName, current.subserviceLink);
                if (tmp != null) {
                    current = tmp;
                    break;
                }
            }
            current = current.next;
        }
        return current;
    }

    public void listServices(Link link) {
        if (link == null)
            return;
        System.out.println(link.name);
        if(link.subserviceLink!=null) {
            System.out.println("{");
            listServices(link.subserviceLink);
            System.out.println("}");
        }
        listServices(link.next);
    }

    public void listServicesFrom(String serviceName) {
        listServices(findService(serviceName, first).subserviceLink);
    }

    public void deleteServicesFrom(Link sub) {
        if(sub==null) return;
        deleteServicesFrom(sub.subserviceLink);
        deleteServicesFrom(sub.next);
        sub=null;

    }

    public void deleteService(String name) {
        Link q = null;
        Link p = first;
        while (p != null) {
            if (p.name.equals(name)) {
                if (q != null)
                    q.next = p.next;
                else first = p.next;
                break;
            }
            q = p;
            p = p.next;
        }
        deleteServicesFrom(p.subserviceLink);
        p = null;
    }
}

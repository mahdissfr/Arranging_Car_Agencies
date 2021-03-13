package aut.ir;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("first you should offer some services");
        System.out.println("enter the name of the service");
        String serviceName=scanner.next();
        System.out.println("enter a description for customer");
        String descriptionForCustomer=scanner.next();
        System.out.println("enter a description for agency");
        String descriptionForAgency=scanner.next();
        System.out.println("enter the model of the car");
        String model=scanner.next();
        System.out.println("enter a price for it");
        int cost=scanner.nextInt();
        LinkList linkList=new LinkList();
        linkList.addService(serviceName,descriptionForCustomer ,descriptionForAgency ,model,cost);
        int toDo ;
        AgencyList agencyList=new AgencyList();
        MaxHeap maxHeap=new MaxHeap();
        while (true) {
            System.out.println("what now?!");
            System.out.println("1-add service");
            System.out.println("2-add subservice");
            System.out.println("3-list of services");
            System.out.println("4-list of subservices offering by a service");
            System.out.println("5-add an agency");
            System.out.println("6-offering a service for an agency");
            System.out.println("7-list of agencies");
            System.out.println("8-delete a service from a agency");
            System.out.println("9-order a service from an agency");
            System.out.println("10-list of orders");
            System.out.println("11-exit");
            toDo = scanner.nextInt();
            switch (toDo) {
                case 11:
                    return;
                case 1: {
                    System.out.println("enter the name of the service");
                    serviceName = scanner.next();
                    System.out.println("enter a description for customer");
                    descriptionForCustomer = scanner.next();
                    System.out.println("enter a description for agency");
                    descriptionForAgency = scanner.next();
                    System.out.println("enter the model of the car");
                    model = scanner.next();
                    System.out.println("enter a price for it");
                    cost = scanner.nextInt();
                    linkList.addService(serviceName,descriptionForCustomer ,descriptionForAgency ,model,cost);
                    break;
                }
                case 2: {
                    System.out.println("enter the name of the subservice");
                    String subserviceName = scanner.next();
                    System.out.println("enter the name of the service");
                    serviceName = scanner.next();
                    System.out.println("enter a description for customer");
                    descriptionForCustomer = scanner.next();
                    System.out.println("enter a description for agency");
                    descriptionForAgency = scanner.next();
                    System.out.println("enter the model of the car");
                    model = scanner.next();
                    System.out.println("enter a price for it");
                    cost = scanner.nextInt();
                    linkList.addsubservice(subserviceName,serviceName,descriptionForCustomer ,descriptionForAgency ,model,cost);
                    break;
                }
                case 3: {
                    linkList.listServices(linkList.getFirst());
                    break;
                }
                case 4: {
                    System.out.println("list subservices from?");
                    serviceName = scanner.next();
                    linkList.listServicesFrom(serviceName);
                    break;
                }
                case 5: {
                    System.out.println("enter the name of the agency");
                    String agencyName = scanner.next();
                    agencyList.addAgency(agencyName);
                    break;
                }
                case 6: {
                    System.out.println("enter the name of the service");
                    serviceName = scanner.next();
                    System.out.println("enter the name of the agency");
                    String agencyName = scanner.next();
                    agencyList.addOffer(serviceName, agencyName,linkList);
                    break;
                }
                case 7:{
                    agencyList.listagencies(linkList);
                    break;
                }
                case 8: {
                    System.out.println("enter the name of the service");
                    serviceName = scanner.next();
                    System.out.println("enter the name of the agency");
                    String agencyName = scanner.next();
                    agencyList.delete(serviceName, agencyName,linkList);
                    break;
                }
                case 9:{
                    System.out.println("enter the name of the service");
                    serviceName = scanner.next();
                    System.out.println("enter the name of the agency");
                    String agencyName = scanner.next();
                    System.out.println("enter your name");
                    String customerName = scanner.next();
                    System.out.println("choose the urgency");
                    System.out.println("1-necessary");
                    System.out.println("2-needful");
                    System.out.println("3-normal");
                    int urgency = scanner.nextInt();
                    System.out.println("b inja bgu k miresi");
                    maxHeap.order(serviceName,agencyName,customerName,urgency);
                    System.out.println("!!!!!!!!");
                    break;
                }
                case 10:{
                    System.out.println("enter the name of the agency");
                    String agencyName = scanner.next();
                    maxHeap.listOrders(agencyName);
                    break;
                }
                default:
                    System.out.println("wrong input");
            }

        }
    }
}

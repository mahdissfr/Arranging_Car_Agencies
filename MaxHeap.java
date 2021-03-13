package aut.ir;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mahdis on2/15/2017.
 */
public class MaxHeap {
    private Node[] orders;
    private int lastNode;

    public MaxHeap() {
        orders = new Node[50];
        orders[0] = new Node(null, null, null, 4);
        orders[0].setTime(getTime());
        lastNode = 0;
    }

    public boolean isEmpty() {
        return orders[1] == null;
    }

    public Long getTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String[] sp = dateFormat.format(date).split(" ");
        String[] time = sp[1].split(":");
        String timestr = "";
        for (String st : time
                ) {
            timestr += st;
        }
        return Long.parseLong(timestr);
    }

    private void increaseLastNode() {
        lastNode++;
    }

    public void order(String serviceName, String agencyName, String customerName, int immediacyLevel) {
        Node node = new Node(serviceName, agencyName, customerName, immediacyLevel);
        node.setTime(getTime());
        if (lastNode == 50) {
            return;
        }
        increaseLastNode();
        int i = lastNode;
        while (i > 1) {
            if (node.getImmediacyLevel() > orders[i / 2].getImmediacyLevel()) break;
            if (node.getImmediacyLevel() == orders[i / 2].getImmediacyLevel())
                if (node.getTime() > orders[i / 2].getTime()) break;
            orders[i] = orders[i / 2];
            i = i / 2;
        }
        orders[i] = node;
        System.out.println(orders[i]);
    }

    private Node deleteOrder() {
        if (lastNode == 0) {
            return null;
        }
        Node first = orders[1];
        Node last = orders[lastNode];
        orders[lastNode] = null;
        lastNode--;
        int i, j;
        for (i = 1, j = 2; j <= lastNode; ) {
            if (j < lastNode) {
                if (orders[j].getImmediacyLevel() > orders[i + 1].getImmediacyLevel()) j++;
                if (orders[j].getImmediacyLevel() == orders[i + 1].getImmediacyLevel())
                    if (orders[j].getTime() > orders[i + 1].getTime())
                        j++;
            }
            if (last.getImmediacyLevel() < orders[j].getImmediacyLevel()) break;
            orders[i] = orders[j];
            i = j;
            j *= 2;
        }
        orders[i] = last;
        return first;
    }

    public void listOrders(String agencyName) {
        Node firstNode = deleteOrder();
        while (firstNode != null) {
            System.out.println(firstNode.toString());
            firstNode = deleteOrder();
        }
    }

}

class Node {


    private String serviceName;
    private String agencyName;
    private String customerName;
    private int immediacyLevel;
    private long time;

    public long getTime() {
        return time;
    }

    public int getImmediacyLevel() {
        return immediacyLevel;
    }

    public void setImmediacyLevel(int immediacyLevel) {
        this.immediacyLevel = immediacyLevel;
    }

    public Node(String serviceName, String agencyName, String customerName, int immediacyLevel) {
        this.serviceName = serviceName;
        this.agencyName = agencyName;
        this.customerName = customerName;
        this.immediacyLevel = immediacyLevel;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Node{" +
                "serviceName='" + serviceName + '\'' +
                ", agencyName='" + agencyName + '\'' +
                ", customerName='" + customerName + '\'' +
                ", immediacyLevel=" + immediacyLevel +
                ", time=" + time +
                '}';
    }
}
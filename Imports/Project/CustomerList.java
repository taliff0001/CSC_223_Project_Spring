package Project;

public class CustomerList {
    private String name;
    private CustomerList next;

    public CustomerList(String name) {
        this.name = name;
        this.next = null;
    }

    public void setNext(CustomerList next) {
        this.next = next;
    }

    public CustomerList getNext() {
        return next;
    }

    public String getName() {
        return name;
    }
}

public class CustomerQueue {
    private CustomerList head;
    private CustomerList tail;

    public CustomerQueue() {
        this.head = null;
        this.tail = null;
    }

    public void addCustomer(String name) {
        CustomerList customer = new CustomerList(name);

        if (tail == null) {
            head = customer;
            tail = customer;
        } else {
            tail.setNext(customer);
            tail = customer;
        }
    }

    public CustomerList removeCustomer() {
        if (head == null) {
            return null;
        }

        CustomerList customer = head;
        head = head.getNext();

        if (head == null) {
            tail = null;
        }

        return customer;
    }

    public CustomerList peek() {
        return head;
    }
}


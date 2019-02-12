package common.apache_commons.entity;

//顾客类
public class Customer {
    private long id;
    private String name;
    private Address[] addresses;
    public Customer() {
    }
    public Customer( long id, String name, Address[]addresses) {
        this .id = id;
        this .name = name;
        this .addresses = addresses;
    }
    //get-set method

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address[] getAddresses() {
        return addresses;
    }

    public void setAddresses(Address[] addresses) {
        this.addresses = addresses;
    }
}

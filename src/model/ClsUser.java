package model;

public abstract class ClsUser {
    // Attributes----------------
    private int id = 0;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    public ClsUser(String nameU, String emailU) {
        this.name = nameU;
        this.email = emailU;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 9) {
            System.out.println("Alert! Enter your phone number with a minimum of 8 digits.");
        } else {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    public String toString() {
        return "\nUser: " + getName() + ", Email: " + getEmail() +
                "\nAddress: " + getAddress() + ", Phone: " + getPhoneNumber();
    }

    // Clase Abstracta Principal
    public abstract void showDataUser();
}

package com.alexiskang.tarifazero.model;

public class UserAddress {

    private boolean selected;
    private Address address;

    public boolean isSelected() {
        return selected;
    }

    public Address getAddress() {
        return address;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

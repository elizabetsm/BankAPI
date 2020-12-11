package sber.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class User implements Serializable {
    private int user_id;
    private String user_name;
    private int card_id;
    private int customer_id;


    public User(String user_name, int card_id, int customer_id) {

        this.user_name = user_name;
        this.card_id = card_id;
        this.customer_id = customer_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getCard_id() {
        return card_id;
    }

    public void setCard_id(int card_id) {
        this.card_id = card_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    @Override
    public String toString() {
        return "{" +
                "user name = " + user_name +
                ", card id=" + card_id +
                ", customer id=" + customer_id +
                '\'' +
                '}';
    }
}

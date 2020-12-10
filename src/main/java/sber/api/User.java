package sber.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class User implements Serializable {
    private int user_id;
    private int card;
    private String Client;


    public User(int user_id, int card, String client) {
        this.user_id = user_id;
        this.card = card;
        Client = client;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int account) {
        this.user_id = user_id;
    }

   int getCards() {
        return card;
    }

    public void setCards(HashMap<String, Integer> cards) {
        this.card = card;
    }

    public String getClient() {
        return Client;
    }

    public void setClient(String client) {
        Client = client;
    }

    @Override
    public String toString() {
        return "sber.api.User{" +
                "id=" + user_id +
                ", card=" + card +
                ", Client='" + Client +'\'' +
                '}';
    }
}

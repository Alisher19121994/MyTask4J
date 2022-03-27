package com.best.mytask4j.Users;

import java.io.Serializable;

public class Member implements Serializable {
    String name;
    int id;

    public Member(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}

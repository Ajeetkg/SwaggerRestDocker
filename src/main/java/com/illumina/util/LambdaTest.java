package com.illumina.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by agupta2 on 11/11/15.
 */
public class LambdaTest {

/*    public static void main(String[] args){
        System.out.println("Hello Lambda");

        List<User> list = createListOfUsers();

    }*/

    public static List<User> createListOfUsers(){
        User user1= new User(1, "one");
        User user2= new User(2, "two");
        User user3= new User(3, "three");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        return list;

    }
}

class User{
    Integer id;
    String name;

    User(Integer id, String name){
        this.id=id;
        this.name=name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode(){
        return this.id*31;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;
        if(id != that.id) return false;
        return true;
    }

    @Override
    public String toString(){
       StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("id").append(":").append(this.id).append(", ");
        stringBuilder.append("name").append(":").append(this.name);
        return stringBuilder.toString();
    }
}
package com.illumina.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by agupta2 on 11/11/15.
 */
public class LambdaTest {

    public static void main(String[] args){
        System.out.println("Hello Lambda");

        List<User> list = createListOfUsers();
        //list.stream().

    }

    public static List<User> createListOfUsers(){
        User user1= new User(1, "one");
        User user2= new User(2, "two");
        User user3= new User(3, "three");
        User user4= new User(4, "four");
        User user5= new User(5, "five");

        User user6= new User(6, "six");
        User user7= new User(7, "seven");
        User user8= new User(8, "eight");

        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        list.add(user6);
        list.add(user7);
        list.add(user8);

        return list;

    }

    private void lambdaTest(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> list = new ArrayList<>();
        List<Integer> twoEvenSquares =
                numbers.stream()
                        .filter(n -> {
                            System.out.println("filtering " + n);
                            return n % 2 == 0;
                        })
                        .map(n -> {
                            System.out.println("mapping " + n);
                            return n * n;
                        })
                        .limit(2)
                        .collect(Collectors.toList());
    }

    private void transactionExample(List<Transaction> transactions){
        List<String> transactionIds = new ArrayList<>();
        for(Transaction t: transactions){
            transactionIds.add(t.getId());
        }

    }
}

class Transaction{
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
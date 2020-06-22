package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> userList = new ArrayList<>();

    public Forum() {

        userList.add(new ForumUser(1,"Charles", 'M', LocalDate.of(2001, 5, 23),43));
        userList.add(new ForumUser(2,"Andrew", 'M', LocalDate.of(2002, 6, 21), 145));
        userList.add(new ForumUser(3,"Vicky", 'F', LocalDate.of(2009, 3, 13),13));
        userList.add(new ForumUser(4,"Rose", 'F', LocalDate.of(2001, 2, 22),1113));
        userList.add(new ForumUser(5,"Moe", 'M', LocalDate.of(1967, 3, 12), 3113));
        userList.add(new ForumUser(6,"Ricky", 'M', LocalDate.of(1956, 2, 13), 3613));
        userList.add(new ForumUser(7,"Bubba", 'M', LocalDate.of(1970, 9, 15), 4613));
        userList.add(new ForumUser(8,"Mary", 'F', LocalDate.of(1981, 7, 8), 213));
        userList.add(new ForumUser(9,"Kenny", 'M', LocalDate.of(1961, 8, 12), 3));
        userList.add(new ForumUser(10,"Victor", 'M', LocalDate.of(1979, 11, 12), 31));
        userList.add(new ForumUser(11,"Lisa", 'F', LocalDate.of(1970, 10, 12), 31));
        userList.add(new ForumUser(12,"Jenny", 'F', LocalDate.of(1982, 5, 12), 311));
    }

    public List<ForumUser> getUserList () {
        return new ArrayList<>(userList);
    }

}

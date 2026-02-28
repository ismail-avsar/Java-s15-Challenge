package com.library.model;

public class Faculty extends MemberRecord {

    public Faculty(int memberId, String name) {
        super(memberId, name, 5);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir Akademisyenim. İsmim: " + getName());
    }
}
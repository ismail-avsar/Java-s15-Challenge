package com.library.model;

public class Student extends MemberRecord {

    public Student(int memberId, String name) {
        super(memberId, name, 5);
    }

    @Override
    public void whoYouAre() {
        System.out.println("Ben bir Öğrenciyim. İsmim: " + getName());
    }
}
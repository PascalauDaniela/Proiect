package com.company;

public class orphanage {
    private String name;
    private String cnp;
    private int age;

    public orphanage(String name, int age, String cnp){
        this.name = name;
        this.age = age;
        this.cnp = cnp;
    }



    @Override
    public String toString() {
        return "orphanage{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp){
        this.cnp = cnp;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

}
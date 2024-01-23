/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalv3;

/**
 *
 * @author AbuZar
 */
public class Person {
    
    private String name;
    private int age;
    

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

   

    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", age=" + age + "'}'";
    }
    
    
    
}

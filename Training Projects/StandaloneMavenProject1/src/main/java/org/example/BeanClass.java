package org.example;

public class BeanClass {
    private String name;
    private long population;
public BeanClass(){}
    public BeanClass(String name, long population) {
        super();
        this.name = name;
        this.population = population;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public long getPopulation() {
        return population;
    }
    public void setPopulation(long population) {
        this.population = population;
    }

}

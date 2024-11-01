package ru.mirea.pkmn;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class AttackSkill implements Serializable {
    public static final long serialVersionUID = 1L;
    private String name;
    private String description;
    private String cost;
    private int damage;

    public AttackSkill(String name, String cost, int damage) {
        this.name = name;
        this.cost = cost;
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description= description;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    @Override
    public String toString(){
        return "\n  name = " + name + "\n" +
                "  text = " + description + "\n" +
                "  cost = " + cost + "\n" +
                "  damage = " + damage;
    }
}

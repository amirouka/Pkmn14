package ru.mirea.pkmn;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;
    private PokemonStage pokemonStage;
    private String name;
    private int hp;
    private EnergyType pokemonType;
    private Card evolvesFrom;
    private List<AttackSkill> skills;
    private EnergyType weaknessType;
    private EnergyType resistanceType;
    private String retreatCost;
    private String gameSet;
    private char regulationMark;
    private Student pokemonOwner;

    public Card() {
        skills = new ArrayList<>();
    }

    public Card(PokemonStage pokemonStage, String name, int hp, EnergyType pokemonType, Card evolvesFrom,
                List<AttackSkill> skills, EnergyType weaknessType, EnergyType resistanceType, String retreatCost,
                String gameSet, char regulationMark, Student pokemonOwner) {
        this.pokemonStage = pokemonStage;
        this.name = name;
        this.hp = hp;
        this.pokemonType = pokemonType;
        this.evolvesFrom = evolvesFrom;
        this.skills = skills;
        this.weaknessType = weaknessType;
        this.resistanceType = resistanceType;
        this.retreatCost = retreatCost;
        this.gameSet = gameSet;
        this.regulationMark = regulationMark;
        this.pokemonOwner = pokemonOwner;
    }

    public PokemonStage getPokemonStage() {
        return pokemonStage;
    }

    public void setPokemonStage(PokemonStage pokemonStage) {
        this.pokemonStage = pokemonStage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public EnergyType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(EnergyType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public Card getEvolvesFrom() {
        return evolvesFrom;
    }

    public void setEvolvesFrom(Card evolvesFrom) {
        this.evolvesFrom = evolvesFrom;
    }

    public List<AttackSkill> getSkills() {
        return skills;
    }

    public void addAttackSkill(AttackSkill attackSkill) {
        skills.add(attackSkill);
    }

    public EnergyType getWeaknessType() {
        return weaknessType;
    }

    public void setWeaknessType(EnergyType weaknessType) {
        this.weaknessType = weaknessType;
    }

    public EnergyType getResistanceType() {
        return resistanceType;
    }

    public void setResistanceType(EnergyType resistanceType) {
        this.resistanceType = resistanceType;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }

    public String getGameSet() {
        return gameSet;
    }

    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }

    public char getRegulationMark() {
        return regulationMark;
    }

    public void setRegulationMark(char regulationMark) {
        this.regulationMark = regulationMark;
    }

    public Student getPokemonOwner() {
        return pokemonOwner;
    }

    public void setPokemonOwner(Student pokemonOwner) {
        this.pokemonOwner = pokemonOwner;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Стадия: ").append(pokemonStage).append("\n");
        sb.append("Имя покемона: ").append(name).append("\n");
        sb.append("ХП: ").append(hp).append("\n");
        sb.append("Тип покемона: ").append(pokemonType).append("\n");
        if (evolvesFrom != null) {
            sb.append("Из какого покемона эволюционирует: ").append(evolvesFrom.getName()).append("\n");
        } else {
            sb.append("Из какого покемона эволюционирует: - \n");
        }
        sb.append("Способности атак: \n");
        for (AttackSkill attackSkill : skills) {
            sb.append(attackSkill.getCost()).append("/").append(attackSkill.getName()).append("/").append(attackSkill.getDescription()).append("/").append(attackSkill.getDamage()).append("\n");
        }
        if (weaknessType != null) {
            sb.append("Тип слабости: ").append(weaknessType).append("\n");
        } else {
            sb.append("Тип слабости: - \n");
        }
        if (resistanceType != null) {
            sb.append("Тип сопротивления: ").append(resistanceType).append("\n");
        } else {
            sb.append("Тип сопротивления: - \n");
        }
        sb.append("Цена побега: ").append(retreatCost).append("\n");
        sb.append("Название сета: ").append(gameSet).append("\n");
        sb.append("Отметка легальности: ").append(regulationMark).append("\n");
        sb.append("Владелец карты: ").append(pokemonOwner.getSurName()).append(" ").append(pokemonOwner.getFirstName()).append(" ").append(pokemonOwner.getFamilyName()).append(" ").append(pokemonOwner.getGroup()).append("\n");

        return sb.toString();
    }
}


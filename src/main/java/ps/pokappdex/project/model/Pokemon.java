package ps.pokappdex.project.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;


public class Pokemon implements Serializable {

    private String name;
    private int number;
    private Type type1;
    private Type type2;
    private String species;
    private Ability[] possibleAbilities = new Ability[3];
    private Movement[] learnset;
    private String height;
    private String weight;
    private Stats stats;
    private String[] evolutiveLine;

    public Pokemon(String name, int number, Type type1, Type type2, String species, Ability[] possibleAbilities, Movement[] learnset, String height, String weight, Stats stats, String[] evolutiveLine) {
        this.name = name;
        this.number = number;
        this.type1 = type1;
        this.type2 = type2;
        this.species = species;
        this.possibleAbilities = possibleAbilities;
        this.learnset = learnset;
        this.height = height;
        this.weight = weight;
        this.stats = stats;
        this.evolutiveLine = evolutiveLine;
    }

    public Pokemon(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public Type getType1() {
        return type1;
    }

    public Type getType2() {
        return type2;
    }

    public String getSpecies() {
        return species;
    }

    public Ability[] getPossibleAbilities() {
        return possibleAbilities;
    }

    public Movement[] getLearnset() {
        return learnset;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public Stats getStats() {
        return stats;
    }

    public String[] getEvolutiveLine() {
        return evolutiveLine;
    }
}

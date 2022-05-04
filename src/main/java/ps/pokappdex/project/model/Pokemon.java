package ps.pokappdex.project.model;

import java.io.Serializable;


public class Pokemon implements Serializable {

    private String name;
    private int number;
    private String type1;
    private String type2;
    private String species;
    private String[] possibleAbilities = new String[3];
    private Move[] learnset;
    private double height;
    private double weight;
    private int[] stats;
    private String[] evolutiveLine;

    public Pokemon() {
    }

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
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

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getPossibleAbilities() {
        return possibleAbilities;
    }

    public void setPossibleAbilities(String[] possibleAbilities) {
        this.possibleAbilities = possibleAbilities;
    }

    public Move[] getLearnset() {
        return learnset;
    }

    public void setLearnset(Move[] learnset) {
        this.learnset = learnset;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int[] getStats() {
        return stats;
    }

    public void setStats(int[] stats) {
        this.stats = stats;
    }

    public String[] getEvolutiveLine() {
        return evolutiveLine;
    }

    public void setEvolutiveLine(String[] evolutiveLine) {
        this.evolutiveLine = evolutiveLine;
    }
}

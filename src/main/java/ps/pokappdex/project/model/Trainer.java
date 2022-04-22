package ps.pokappdex.project.model;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private String password;
    private String email;
    private ArrayList<TrainerPokemon[]> teams;

    Trainer(){
    }
    public String getName(){
        return this.name;
    }

    public String getPassword(){
        return this.password;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<TrainerPokemon[]> getTeams() {
        return teams;
    }
}

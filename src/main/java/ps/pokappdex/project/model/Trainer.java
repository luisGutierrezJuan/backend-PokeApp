package ps.pokappdex.project.model;

import java.util.ArrayList;

public class Trainer {
    private String name;
    private String password;
    private String email;
    private ArrayList<TrainerPokemon[]> teams;

    public Trainer(){
    }

    public void setEmail(String email){
        this.email = email;
    }
    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
}

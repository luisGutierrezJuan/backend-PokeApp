package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Pokemon;


import java.util.ArrayList;

@Repository
public class PokedexRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Pokemon> getPokedex(){
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        for (String pokemonName: jdbcTemplate.queryForList("SELECT DISTINCT Pokemon_name FROM pokedex ORDER BY Pokedex_number", String.class)){
            pokedex.add(new Pokemon(pokemonName));
        }
        return pokedex;
    }

}

package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Ability;
import ps.pokappdex.project.model.Pokemon;
import ps.pokappdex.project.model.Stats;
import ps.pokappdex.project.model.Type;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class PokedexRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Pokemon> getPokedex(){
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        List<Map<String, Object>> pokelist = jdbcTemplate.queryForList("SELECT DISTINCT Pokemon_name, Pokedex_number, Primary_Type, Secondary_Type, Classification, Primary_Ability, Secondary_Ability, Hidden_Ability, Pokemon_Height, Pokemon_Weight, Health_Stat, Attack_Stat, Defense_Stat, Special_Attack_Stat, Special_Defense_Stat, Speed_Stat FROM pokedex ORDER BY Pokedex_number WHERE Pokemon_Name IN (SELECT DISTINCT Pokemon_Name FROM pokedex) ");
        int i = 0;
        for (Map row: pokelist){
            Pokemon obj = new Pokemon();

            String pokemonName = (String) row.get("Pokemon_name");
            pokemonName = pokemonName.replaceAll("\"", "");
            if (pokemonName.equals("Nidoran (Male)")) {
                pokemonName = pokemonName.replace(" (Male)", "-m");
            } else if (pokemonName.equals("Nidoran (Female)")) {
                pokemonName = pokemonName.replace(" (Female)", "-f");
            }

            obj.setName(pokemonName);
            obj.setNumber((Integer) row.get("Pokedex_number"));
            obj.setType1(((String) row.get("Primary_Type")).replaceAll("\"", ""));
            obj.setType2(((String) row.get("Secondary_Type")).replaceAll("\"", "").replace("NULL", "-"));
            obj.setSpecies(((String) row.get("Classification")).replaceAll("\"", ""));

            String[] possibleAbilities = new String[]{((String) row.get("Primary_Ability")).replaceAll("\"", ""), ((String) row.get("Secondary_Ability")).replaceAll("\"", "").replace("NULL", "-"), ((String) row.get("Hidden_Ability")).replaceAll("\"", "").replace("NULL", "-")};

            obj.setPossibleAbilities(possibleAbilities);
            obj.setHeight(((BigDecimal) row.get("Pokemon_Height")).doubleValue());
            obj.setWeight(((BigDecimal) row.get("Pokemon_Weight")).doubleValue());

            int hp = (Integer) row.get("Health_Stat");
            System.out.println(hp);
            int atk = (Integer) row.get("Attack_Stat");
            System.out.println(atk);
            int def = (Integer) row.get("Defense_Stat");
            System.out.println(def);
            int spa = (Integer) row.get("Special_Attack_Stat");
            System.out.println(spa);
            int spd = (Integer) row.get("Special_Defense_Stat");
            System.out.println(spd);
            int spe = (Integer) row.get("Speed_Stat");

            obj.setStats(new int[]{hp, atk, def, spa, spd, spe});

            pokedex.add(obj);
        }

        return pokedex;
    }

}

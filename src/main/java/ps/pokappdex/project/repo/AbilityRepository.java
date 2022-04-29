package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Ability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class AbilityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Ability> getAbilities(){
        ArrayList<Ability> abilitydex = new ArrayList<>();
        ArrayList<String> auxNames = new ArrayList<>();
        List<Map<String, Object>> pokelist = jdbcTemplate.queryForList("SELECT DISTINCT Primary_Ability, Primary_Ability_description, Secondary_Ability, Secondary_Ability_description, Hidden_Ability, Hidden_Ability_description FROM pokedex ORDER BY Primary_Ability, Hidden_Ability");
        for (Map row: pokelist){
            Ability obj1 = new Ability();
            Ability obj2 = new Ability();
            Ability obj3 = new Ability();

            String abilityName1 = (String) row.get("Primary_Ability");
            abilityName1 = abilityName1.replaceAll("\"", "");

            String abilityDescription1 = (String) row.get("Primary_Ability_Description");
            abilityDescription1 = abilityDescription1.replaceAll("\"", "");

            obj1.setName(abilityName1);
            obj1.setDescription(abilityDescription1);

            String abilityName2 = (String) row.get("Secondary_Ability");
            abilityName2 = abilityName2.replaceAll("\"", "");

            String abilityDescription2 = (String) row.get("Secondary_Ability_Description");
            abilityDescription2 = abilityDescription2.replaceAll("\"", "");

            obj2.setName(abilityName2);
            obj2.setDescription(abilityDescription2);

            String abilityName3 = (String) row.get("Hidden_Ability");
            abilityName3 = abilityName3.replaceAll("\"", "");

            String abilityDescription3 = (String) row.get("Hidden_Ability_Description");
            abilityDescription3 = abilityDescription3.replaceAll("\"", "");

            obj3.setName(abilityName3);
            obj3.setDescription(abilityDescription3);

            if (auxNames.contains(obj1.getName())) {
                if (auxNames.contains(obj2.getName())) {
                    if (auxNames.contains(obj3.getName())) {
                    } else {
                        abilitydex.add(obj3);
                        auxNames.add(obj3.getName());
                    }
                } else {
                    abilitydex.add(obj2);
                    auxNames.add(obj2.getName());
                }
            } else {
                abilitydex.add(obj1);
                auxNames.add(obj1.getName());
            }

        }
        abilitydex.remove(abilitydex.size()-1);
        Collections.sort(abilitydex,
                (a,b) -> (a.getName().compareTo( b.getName())));
        return abilitydex;
    }
}

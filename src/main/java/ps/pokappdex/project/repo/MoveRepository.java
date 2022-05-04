package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Ability;
import ps.pokappdex.project.model.Item;
import ps.pokappdex.project.model.Movement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Repository
public class MoveRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Movement> getMoves(){
        ArrayList<Movement> movedex = new ArrayList<>();
        List<Map<String, Object>> pokelist = jdbcTemplate.queryForList("SELECT DISTINCT name, description FROM moves ORDER BY name");
        for (Map row: pokelist){
            Movement obj1 = new Movement();
            String moveName = (String) row.get("name");
            moveName = moveName.replaceAll("-", " ");
            String[] parts = moveName.split("\\s+");
            moveName = "";
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
                if (i == parts.length - 1) {
                    moveName = moveName.concat(parts[i]);
                } else {
                    moveName = moveName.concat(parts[i] + " ");
                }
            }
            obj1.setName(moveName);

            String moveDescription = (String) row.get("description");
            if (moveDescription.equals("Dummy Data")) {
                continue;
            }
            obj1.setDescription(moveDescription);
            movedex.add(obj1);
        }
        return movedex;
    }
}

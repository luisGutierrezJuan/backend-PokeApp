package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Ability;
import ps.pokappdex.project.model.Item;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<Item> getItems(){
        ArrayList<Item> itemdex = new ArrayList<>();
        List<Map<String, Object>> pokelist = jdbcTemplate.queryForList("SELECT DISTINCT name, description, image_url FROM items ORDER BY name");
        System.out.println(pokelist.size());
        for (Map row: pokelist){
            Item obj1 = new Item();

            String itemName = (String) row.get("name");
            itemName = itemName.replaceAll("-", " ");
            String[] parts = itemName.split("\\s+");
            itemName = "";
            for (int i = 0; i < parts.length; i++) {
                parts[i] = parts[i].substring(0, 1).toUpperCase() + parts[i].substring(1);
                if (i == parts.length - 1) {
                    itemName = itemName.concat(parts[i]);
                } else {
                    itemName = itemName.concat(parts[i] + " ");
                }
            }
            obj1.setName(itemName);

            String itemDescription = (String) row.get("description");
            obj1.setDescription(itemDescription);

            String itemImage = (String) row.get("image_url");
            obj1.setImage(itemImage);

            itemdex.add(obj1);
        }
        return itemdex;
    }
}

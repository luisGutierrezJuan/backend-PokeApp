package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Trainer;

import java.util.List;


@Repository
public class  UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean existe(String user){
        List<String> trainerName=jdbcTemplate.queryForList("SELECT Name FROM Usuarios WHERE Name="+user, String.class);
        return trainerName.size() > 0;
    }
    public void add(Trainer trainer){
        jdbcTemplate.update("INSERT INTO Usuarios (Name, userPassword, email) values("+trainer.getName()+
                ", "+trainer.getPassword()+", "+trainer.getEmail()+")");
    }
}

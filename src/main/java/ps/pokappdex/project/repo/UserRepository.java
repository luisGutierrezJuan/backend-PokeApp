package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Trainer;


@Repository
public class  UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean userExists(String name){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        return !namedParameterJdbcTemplate.queryForList("SELECT Name FROM Usuarios WHERE Name=:name", namedParameters, String.class).isEmpty();
    }

    public boolean addUser(Trainer trainer){
        jdbcTemplate.update("INSERT INTO Usuarios (Name, userPassword, email) values(?,?,?)", trainer.getName(), trainer.getPassword(), trainer.getEmail());
        return userExists(trainer.getName());
    }
}

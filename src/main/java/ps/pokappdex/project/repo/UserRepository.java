package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Trainer;

import java.util.HashMap;
import java.util.Map;


@Repository
public class  UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public boolean logUser(Trainer trainer){
        MapSqlParameterSource m=new MapSqlParameterSource();
        m.addValue("name", trainer.getName());
        SqlParameterSource namedParameters = m.addValue("password",trainer.getPassword());
        return !namedParameterJdbcTemplate.queryForList("SELECT Name FROM Usuarios WHERE Name=:name AND userPassword=:password", namedParameters, String.class).isEmpty();
    }

    public boolean userExists(String name){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        return !namedParameterJdbcTemplate.queryForList("SELECT Name FROM Usuarios WHERE Name=:name", namedParameters, String.class).isEmpty();
    }

    public boolean addUser(Trainer trainer){
        jdbcTemplate.update("INSERT INTO Usuarios (Name, userPassword, email) values(?,?,?)", trainer.getName(), trainer.getPassword(), trainer.getEmail());
        return userExists(trainer.getName());
    }

    public Trainer getEmailByName(String name){
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("name", name);
        Trainer tr = new Trainer();
        tr.setEmail(namedParameterJdbcTemplate.queryForList("SELECT email FROM Usuarios WHERE Name=:name", namedParameters, String.class).get(0));
        return tr;
    }
    public boolean deleteUser(String name){
        Object[] args = new Object[] {name};
        int r=jdbcTemplate.update("DELETE FROM Usuarios WHERE Name =?", args);
        return true;
    }
    public void updateUser(String name){

    }
}

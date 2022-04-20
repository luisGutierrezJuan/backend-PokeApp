package ps.pokappdex.project.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ps.pokappdex.project.model.Trainer;


@Repository
public class  UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Trainer addTrainer(Trainer trainer){
        return trainer;
    }
}

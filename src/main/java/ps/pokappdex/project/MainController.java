package ps.pokappdex.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ps.pokappdex.project.model.Pokemon;
import ps.pokappdex.project.model.Trainer;
import ps.pokappdex.project.repo.PokedexRepository;
import ps.pokappdex.project.repo.UserRepository;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/controller")
public class MainController {

    @Autowired
    private PokedexRepository pokedexRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/getPokedex")
    public ArrayList<Pokemon> getPokedex(){
        return pokedexRepository.getPokedex();
    }


    @PostMapping("/login")
    public ResponseEntity<Trainer> login(@RequestBody String user){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Trainer newTrainer = objectMapper.readValue(user, Trainer.class);
            return new ResponseEntity<>(newTrainer, HttpStatus.OK);
        } catch (Exception e ) {
            System.out.println(e);
        }
        return null;
    }


}

package ps.pokappdex.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ps.pokappdex.project.model.*;
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

    @GetMapping("/getNatures")
    public ArrayList<Nature> getNatures() {
        return NatureGenerator.createNatures();
    }

    @GetMapping("/getTypeTable")
    public TypeTable getTypeTable() {
        TypeTable tt = new TypeTable();
        return tt;
    }

    @GetMapping("/getTypeDamages")
    public float[] getTypeDamages(String t1, String t2) {
        return TypeTable.calculateTypes(t1, t2);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Trainer trainer){
        //return new ResponseEntity<>(trainer, HttpStatus.OK);
        return userRepository.userExists(trainer.getName());
    }

    @PostMapping("/register")
    public ResponseEntity<Trainer> register(@RequestBody Trainer trainer){
        if(!userRepository.userExists(trainer.getName()) && userRepository.addUser(trainer)) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        }
        return null;
    }

}

package ps.pokappdex.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ps.pokappdex.project.model.*;
import ps.pokappdex.project.repo.*;

import java.util.ArrayList;

@RestController
@RequestMapping(path = "/controller")
public class MainController {

    @Autowired
    private PokedexRepository pokedexRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AbilityRepository abilityRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private MoveRepository moveRepository;

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

    @GetMapping("/getAbilities")
    public ArrayList<Ability> getAbilities() {
        return abilityRepository.getAbilities();
    }

    @GetMapping("/getItems")
    public ArrayList<Item> getItems() {
        return itemRepository.getItems();
    }

    @GetMapping("/getMoves")
    public ArrayList<Move> getMoves() {
        return moveRepository.getMoves();
    }


    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody Trainer trainer){
        //return new ResponseEntity<>(trainer, HttpStatus.OK);
        return new ResponseEntity<>(userRepository.logUser(trainer),HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<Trainer> register(@RequestBody Trainer trainer){
        if(!userRepository.userExists(trainer.getName()) && userRepository.addUser(trainer)) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        }
        return null;
    }

    @PostMapping("/getEmailByName")
    public ResponseEntity<Trainer> getEmailByName(@RequestBody String name){
        if(userRepository.userExists(name)) {
            return new ResponseEntity<>(userRepository.getEmailByName(name), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<boolean> deleteUser(@RequestBody String name){

    }
}

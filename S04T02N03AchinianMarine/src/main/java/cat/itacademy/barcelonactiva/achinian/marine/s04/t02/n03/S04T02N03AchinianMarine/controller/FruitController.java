package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.controller;

import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.domain.Fruit;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;


    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit fruit) {
        Fruit createdFruit = fruitService.add(fruit);
        return new ResponseEntity<>(createdFruit, HttpStatus.CREATED);
    }
    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getOneFruit(@PathVariable String id) {
        Optional<Fruit> fruit = fruitService.getOne(id);
        return fruit.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        List<Fruit> fruits = fruitService.getAll();
        return ResponseEntity.ok().body(fruits);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateFruit(@PathVariable String id, @RequestBody Fruit fruit) {
            Fruit updatedFruit = fruitService.update(fruit);
            return ResponseEntity.ok().body(updatedFruit);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFruit(@PathVariable String id) {
        if (fruitService.getOne(id).isPresent()) {
            fruitService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.services;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.domain.Fruit;

import java.util.List;
import java.util.Optional;

public interface FruitService {
    Fruit add(Fruit fruit);
    Optional<Fruit> getOne(String id);
    List<Fruit> getAll();
    Fruit update(Fruit fruit);
    void delete(String id);
}

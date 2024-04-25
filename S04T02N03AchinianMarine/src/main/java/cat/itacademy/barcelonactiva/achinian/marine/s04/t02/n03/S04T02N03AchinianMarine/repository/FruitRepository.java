package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.repository;

import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FruitRepository extends MongoRepository<Fruit, String> {
}

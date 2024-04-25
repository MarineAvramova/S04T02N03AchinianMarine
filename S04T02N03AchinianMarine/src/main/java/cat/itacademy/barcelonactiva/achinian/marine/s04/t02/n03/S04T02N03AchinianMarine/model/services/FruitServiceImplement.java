package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.services;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.domain.Fruit;
import cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImplement implements FruitService{


    private final FruitRepository fruitRepository;


    @Autowired
    public FruitServiceImplement(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;

    }

    @Override
    public Fruit add(Fruit fruit) {

     return  fruitRepository.save(fruit);
    }

    @Override
    public Optional<Fruit> getOne(String id) {
        return fruitRepository.findById(id);
    }

    @Override
    public List<Fruit> getAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit update(Fruit fruit) {
        if(fruit != null && fruitRepository.existsById(fruit.getId())) {
           return fruitRepository.save(fruit);
        }else throw new RuntimeException("Fruit not found with id " + fruit.getId());

    }

    @Override
    public void delete(String id) {
     fruitRepository.deleteById(id);
    }
}

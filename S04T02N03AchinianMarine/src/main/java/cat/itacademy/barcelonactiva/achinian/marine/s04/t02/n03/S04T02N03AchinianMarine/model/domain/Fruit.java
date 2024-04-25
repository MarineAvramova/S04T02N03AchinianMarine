package cat.itacademy.barcelonactiva.achinian.marine.s04.t02.n03.S04T02N03AchinianMarine.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fruits")
public class Fruit {

    @Id
    private String id;
    private String name;
    private int quantityKG;

    public Fruit() {
    }

    public Fruit(String name, int quantityKG) {
        this.name = name;
        this.quantityKG = quantityKG;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantityKG() {
        return quantityKG;
    }

    public void setQuantityKG(int quantityKG) {
        this.quantityKG = quantityKG;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantityKG=" + quantityKG +
                '}';
    }
}

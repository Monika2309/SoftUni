package exercisesForExam.goldDigger.zoo.entities.animals;

public abstract class BaseAnimal implements Animal {

    private String name;
    private String kind;
    private double kg;
    private double price;


    public BaseAnimal(String name, String kind, double kg, double price) {
        setName(name);
        setKind(kind);
        this.kg = kg;
        setPrice(price);
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new NullPointerException("Animal name cannot be null or empty.");
        }
        this.name = name;
    }

    public void setKind(String kind) {
        if (kind == null || kind.trim().isEmpty()){
            throw new NullPointerException("Animal kind cannot be null or empty.");
        }
        this.kind = kind;
    }

    public void setPrice(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException("Animal price cannot be below or equal to 0.");
        }
        this.price = price;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getKg() {
        return kg;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setKg(double kg) {
        this.kg = kg;
    }
}

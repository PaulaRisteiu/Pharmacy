package domain;

public class Drug {
    private int id;
    private String name;
    private String producer;
    private double price; // price > 0
    private boolean recipe;

    public Drug() {
    }

    public Drug(int id, String name, String producer, double price, boolean recipe) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.price = price;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isRecipe() {
        return recipe;
    }

    public void setRecipe(boolean recipe) {
        this.recipe = recipe;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "idDrug=" + id +
                ", name='" + name + '\'' +
                ", producer='" + producer + '\'' +
                ", price=" + price +
                ", recipe=" + recipe +
                '}';
    }
}

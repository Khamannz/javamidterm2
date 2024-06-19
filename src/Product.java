public class Product {
    private int id;
    private String name;
    private double pricePerUnit;
    private boolean activeForSell;

    public Product() {}

    public Product(int id, String name, double pricePerUnit, boolean activeForSell) {
        this.id = id;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.activeForSell = activeForSell;
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

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public boolean isActiveForSell() {
        return activeForSell;
    }

    public void setActiveForSell(boolean activeForSell) {
        this.activeForSell = activeForSell;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pricePerUnit=" + pricePerUnit +
                ", activeForSell=" + activeForSell +
                '}';
    }
}
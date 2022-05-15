package htwberlinwebtech.Kalotracker.web.api;

public class Food {

    private long id;
    private String name;
    private int carbs;
    private int fat;
    private int proteins;
    private int kalories;

    public Food(long id, String name, int carbs, int fat, int proteins, int kalories) {
        this.id = id;
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.proteins = proteins;
        this.kalories = kalories;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    public int getProteins() {
        return proteins;
    }

    public int getKalories() {
        return kalories;
    }

    public void setKalories(int kalories) {
        this.kalories = kalories;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }
}

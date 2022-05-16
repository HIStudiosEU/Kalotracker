package htwberlinwebtech.Kalotracker.web.api;

public class FoodManipulationRequest {

    private String name;
    private int carbs;
    private int fat;
    private int proteins;
    private int kalories;

    public FoodManipulationRequest(String name, int carbs, int fat, int proteins, int kalories) {
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.proteins = proteins;
        this.kalories = kalories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCarbs() {
        return carbs;
    }

    public void setCarbs(int carbs) {
        this.carbs = carbs;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProteins() {
        return proteins;
    }

    public void setProteins(int proteins) {
        this.proteins = proteins;
    }

    public int getKalories() {
        return kalories;
    }

    public void setKalories(int kalories) {
        this.kalories = kalories;
    }
}

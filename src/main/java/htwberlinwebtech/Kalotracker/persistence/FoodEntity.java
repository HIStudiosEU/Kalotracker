package htwberlinwebtech.Kalotracker.persistence;

import javax.persistence.*;

@Entity(name = "foods")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "carbs", nullable = false)
    private int carbs;

    @Column(name = "fat", nullable = false)
    private int fat;

    @Column(name = "proteins", nullable = false)
    private int proteins;

    @Column(name = "kalories", nullable = false)
    private int kalories;

    public FoodEntity(String name, int carbs, int fat, int proteins, int kalories) {
        this.name = name;
        this.carbs = carbs;
        this.fat = fat;
        this.proteins = proteins;
        this.kalories = kalories;
    }

    protected FoodEntity() {
    }

    public Long getId() {
        return id;
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

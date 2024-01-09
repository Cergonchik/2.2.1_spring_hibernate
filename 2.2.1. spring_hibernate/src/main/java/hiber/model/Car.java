package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "car_id")
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "series")
    private int series;
    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private User user;

    public Car() {

    }

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public int getSeries() {
        return series;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        final Car car = (Car) o;
        if (!Objects.equals(car.getId(), getId())) {
            return false;
        }
        if (!Objects.equals(car.getModel(), getModel())) {
            return false;
        }
        if (!Objects.equals(car.getSeries(), getSeries())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return (int) (3 * getId() + 7 * Integer.hashCode(getSeries()) +
                getModel().hashCode()) >> 3;
    }


}

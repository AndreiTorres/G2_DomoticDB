package domotic.persistence.model;

import javax.persistence.*;

@Entity
public class Espacio {

    @Id
    @GeneratedValue
    private long espacioId;

    private String espacioName;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Area area;

    public Espacio() {}

    public Espacio(String espacioName, Area area) {
        this.espacioName = espacioName;
        area.addEspacio(this);
        this.area = area;
    }

    public long getEpacioId() {
        return espacioId;
    }

    public String getEspacioNameName() {
        return espacioName;
    }

    public void setEspacioName(String espacioName) {
        this.espacioName = espacioName;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Espacio{" +
                "espacioId=" + espacioId +
                ", espacioName='" + espacioName + '\'' +
                '}';
    }
}
package domotic.persistence.model;


import javax.persistence.*;

@Entity
public class DeviceSpecs {

    @Id
    @GeneratedValue
    private long deviceSpecsId;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Brand brand;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Model model;

    private boolean hasWifi;

    private boolean hasBluetooth;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Type type;

    @OneToOne(mappedBy = "deviceSpecs")
    private Device device;

    private float temp;

    private String screen;

    private int data;

    public DeviceSpecs(){}

    public DeviceSpecs(boolean hasWifi, boolean hasBluetooth, float temp) {
        this.hasWifi = hasWifi;
        this.hasBluetooth = hasBluetooth;
        this.temp = temp;
    }

    public DeviceSpecs(boolean hasWifi, boolean hasBluetooth, String screen) {
        this.hasWifi = hasWifi;
        this.hasBluetooth = hasBluetooth;
        this.screen = screen;
    }

    public DeviceSpecs(boolean hasWifi, boolean hasBluetooth, int data) {
        this.hasWifi = hasWifi;
        this.hasBluetooth = hasBluetooth;
        this.data = data;
    }
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public void setHasBluetooth(boolean hasBluetooth) {
        this.hasBluetooth = hasBluetooth;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

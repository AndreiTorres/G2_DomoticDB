package domotic.persistence.model;


import javax.persistence.*;

@Entity
public class Model {

    @Id
    @GeneratedValue
    private long modelId;

    private String modelName;

    @OneToOne(mappedBy = "model")
    private DeviceSpecs deviceSpecs;

    public Model() {}

    public Model(String modelName) {
        this.modelName = modelName;
    }

    public long getModelId() {
        return modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModel() {
        return modelName;
    }

    public void setModel(String model) {
        this.modelName = model;
    }

    public DeviceSpecs getDeviceSpecs() {
        return deviceSpecs;
    }

    public void setDeviceSpecs(DeviceSpecs deviceSpecs) {
        this.deviceSpecs = deviceSpecs;
    }
}

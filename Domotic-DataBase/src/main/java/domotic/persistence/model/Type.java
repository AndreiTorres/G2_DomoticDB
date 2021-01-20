package domotic.persistence.model;

import javax.persistence.*;

@Entity
public class Type {

    @Id
    @GeneratedValue
    private long typeId;

    private String typeName;

    @OneToOne(mappedBy = "type")
    private DeviceSpecs deviceSpecs;

    public Type() {}

    public Type(String typeName) {
        this.typeName = typeName;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return typeName;
    }

    public void setType(String typeN) {
        this.typeName = typeN;
    }
}

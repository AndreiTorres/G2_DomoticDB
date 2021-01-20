package domotic.persistence.model;

import javax.persistence.*;

@Entity
public class Brand {

    @Id
    @GeneratedValue
    private long brandId;

    private String brandName;

    @OneToOne(mappedBy = "brand")
    private DeviceSpecs deviceSpecs;

    public Brand() {}

    public Brand(String brandName) {
        this.brandName = brandName;
    }

    public long getBrandId() {
        return brandId;
    }

    public void setBrandId(long brandId) {
        this.brandId = brandId;
    }

    public String getBrand() {
        return brandName;
    }

    public void setBrand(String brandNam) {
        this.brandName = brandNam;
    }
}

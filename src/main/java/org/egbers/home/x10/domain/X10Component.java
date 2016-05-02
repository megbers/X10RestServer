package org.egbers.home.x10.domain;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.ALWAYS;

@Entity
@Table(name = "component", catalog = "home_automation")
@JsonSerialize(include = ALWAYS)
public class X10Component {
	public static final Integer LIGHT_MODULE = 0;
	public static final Integer LIGHT_SWITCH = 1;
	public static final Integer APPLIANCE_MODULE = 2;
	public static final Integer OUTLET_MODULE = 3;
	
	private Long id;
	private String houseCode;
	private Integer unitCode;
	private String commonName;
	private String iconLocation;
	private Integer type;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "house_code")
	public String getHouseCode() {
		return houseCode;
	}

	public void setHouseCode(String houseCode) {
		this.houseCode = houseCode;
	}

	@Column(name = "unit_code")
	public Integer getUnitCode() {
		return unitCode;
	}

	public void setUnitCode(Integer unitCode) {
		this.unitCode = unitCode;
	}

	@Column(name = "common_name")
	public String getCommonName() {
		return commonName;
	}

	public void setCommonName(String commonName) {
		this.commonName = commonName;
	}

	@Column(name = "icon_location")
	public String getIconLocation() {
		return iconLocation;
	}

	public void setIconLocation(String iconLocation) {
		this.iconLocation = iconLocation;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

    @Override
    public String toString() {
        return "X10Component{" +
                "id=" + id +
                ", houseCode='" + houseCode + '\'' +
                ", unitCode=" + unitCode +
                ", commonName='" + commonName + '\'' +
                ", iconLocation='" + iconLocation + '\'' +
                ", type=" + type +
                '}';
    }
}

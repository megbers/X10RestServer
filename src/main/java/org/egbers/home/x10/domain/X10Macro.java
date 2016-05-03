package org.egbers.home.x10.domain;


import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;

import static org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion.ALWAYS;

@Entity
@Table(name = "macro", catalog = "home_automation")
@JsonSerialize(include = ALWAYS)
public class X10Macro {
    private Long id;
    private String commonName;
    private String macroString;
    private String cronExpression;
    private String iconLocation;

    public X10Macro(String cronExpression, String macroString) {
        this.cronExpression = cronExpression;
        this.macroString = macroString;
    }

    public X10Macro() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "macro_string")
    public String getMacroString() {

        return macroString;
    }

    public void setMacroString(String macroString) {
        this.macroString = macroString;
    }

    @Column(name = "cron")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Column(name = "common_name")
    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getIconLocation() {
        return iconLocation;
    }

    public void setIconLocation(String iconLocation) {
        this.iconLocation  = "img/macro_icon.jpg";//= iconLocation;
    }
}

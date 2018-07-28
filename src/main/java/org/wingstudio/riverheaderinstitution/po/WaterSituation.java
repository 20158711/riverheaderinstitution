package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class WaterSituation {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Short id;

    @Setter @Getter
    @Column(unique = true,length = 20)
    private String situationDesc;

    @OneToMany(mappedBy = "waterSituation")
    @Getter
    private Set<River> rivers=new HashSet<>();

    @Override
    public String toString() {
        StringBuffer riversBuffer=new StringBuffer();
        if (!CollectionUtils.isEmpty(rivers)){
            rivers.forEach(e->riversBuffer.append(e.getRiverArea()+"\t"));
        }
        return "WaterSituation{" +
                "id=" + id +
                ", situationDesc='" + situationDesc + '\'' +
                ", rivers=[" + riversBuffer.toString() +
                "]}";
    }
}

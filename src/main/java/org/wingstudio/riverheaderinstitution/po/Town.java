package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Town {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Integer id;

    @Setter @Getter
    @Column(length = 20,nullable = false,unique = true)
    private String townName;

    @OneToMany(mappedBy = "town")
    @Getter
    private Set<River> rivers=new HashSet<>();

    @Override
    public String toString() {
        StringBuffer riversBuffer=new StringBuffer();
        if (!CollectionUtils.isEmpty(rivers)){
            rivers.forEach(e->riversBuffer.append(e.getRiverArea()+"\t"));
        }
        return "Town{" +
                "id=" + id +
                ", townName='" + townName + '\'' +
                ", rivers=[" + riversBuffer.toString() +
                "]}";
    }
}

package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class Institution {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date updateTime;

    @Column(length = 50)
    private String institutionFrom;

    @Column(length = 100,unique = true)
    private String institutionTitle;

    @Lob
    @Column(nullable = false)
    private String institutionBody;

    @Override
    public String toString() {
        return "Institution{" +
                "id=" + id +
                ", updateTime=" + updateTime +
                ", institutionFrom='" + institutionFrom + '\'' +
                ", institutionTitle='" + institutionTitle + '\'' +
                ", institutionBody='" + institutionBody + '\'' +
                '}';
    }
}

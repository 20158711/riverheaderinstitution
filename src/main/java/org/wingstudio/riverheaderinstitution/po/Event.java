package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import org.wingstudio.riverheaderinstitution.enums.EventStatusEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Event {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long id;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @Setter @Getter
    private User uploadUser;

    @Setter @Getter
    private Date uploadTime;

    @ManyToOne(cascade = {CascadeType.REFRESH})
    @Setter @Getter
    private ProblemCategory problemCategory;

    @OneToMany(mappedBy ="event")
    @Getter
    private Set<ProblemDeal> problemDeals=new HashSet<>();

    @Setter @Getter
    @Column(length = 200)
    private String problemDesc;

    @Setter @Getter
    private short status=EventStatusEnum.BEGIN.getCode();

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", uploadUser=" + uploadUser +
                ", uploadTime=" + uploadTime +
                ", problemCategory=" + problemCategory +
                ", problemDesc='" + problemDesc + '\'' +
                ", status=" + status +
                '}';
    }
}

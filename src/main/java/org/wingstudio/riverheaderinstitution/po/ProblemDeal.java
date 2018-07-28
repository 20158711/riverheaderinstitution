package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
public class ProblemDeal {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private Event event;

    @ManyToOne(cascade = CascadeType.REFRESH)
    private User dealUser;

    private Date pullTime;

    private Date pushTime;

    @Column(length = 200)
    private String pushDesc;

    private byte pushCode;

}

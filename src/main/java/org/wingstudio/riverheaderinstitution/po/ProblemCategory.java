package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ProblemCategory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Short id;

    @Setter @Getter
    @Column(length = 100,nullable = false,unique = true)
    private String problemCategory;

    @OneToMany(mappedBy = "problemCategory")
    @Getter
    private Set<Event> events;

    @Override
    public String toString() {
        StringBuffer eventsBuffer = new StringBuffer();
        if (events != null)
            events.forEach(e -> eventsBuffer.append(e.getProblemDesc() + "\t"));
        return "ProblemCategory{" +
                "id=" + id +
                ", problemCategory='" + problemCategory + '\'' +
                ", events=[" + eventsBuffer.toString() +
                "]}";
    }
}

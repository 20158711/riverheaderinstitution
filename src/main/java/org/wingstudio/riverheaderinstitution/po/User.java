package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter @Getter
    private Long id;

    @Column(length = 20,nullable = false)
    @Setter @Getter
    private String username;

    @Column(length = 30,nullable = false)
    @Setter @Getter
    private String tel;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "user_to_category"
    )
    @Setter @Getter
    private Set<UserCategory> categorys=new HashSet<>();

    public void addUserCategory(UserCategory category){
        categorys.add(category);
    }

    public void removeCategory(UserCategory category){
        if(categorys.contains(category)){
            categorys.remove(category);
        }
    }

    @OneToMany(cascade = {CascadeType.REFRESH}
    ,mappedBy = "uploadUser")
    @Getter
    private Set<Event> events;

    @OneToMany(cascade = CascadeType.REFRESH,
    mappedBy = "dealUser")
    @Getter
    private Set<ProblemDeal> problemDeals=new HashSet<>();

    @OneToMany(mappedBy = "header")
    @Getter
    private Set<River> headRivers=new HashSet<>();

    @Override
    public String toString() {

        StringBuffer stringBuffer=new StringBuffer();
        if(!CollectionUtils.isEmpty(categorys))
            categorys.forEach(e->stringBuffer.append(e.getCategoryName()+"\t"));
        StringBuffer eventsBuffer=new StringBuffer();
        if (!CollectionUtils.isEmpty(events))
            events.forEach(e->eventsBuffer.append(e.getProblemDesc()+"\t"));

        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                ", categorys["+stringBuffer.toString() +
                ", events["+eventsBuffer.toString()+
                "]}";
    }
}

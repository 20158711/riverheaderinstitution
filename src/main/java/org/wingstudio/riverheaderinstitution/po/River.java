package org.wingstudio.riverheaderinstitution.po;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
public class River {

    @Id
    @Column(length = 20)
    private String id;

    @ManyToOne
    private RiverType type;     //水域类型

    @ManyToOne
    private Town town;          //所属镇

    @Column(nullable = false)
    private Double latitude;    //纬度

    @Column(nullable = false)
    private Double longitude;   //经度

    @Column(length = 20,nullable = false)
    private String riverName;   //水域名称

    @Column(length = 30,nullable = false)
    private String position;    //所在位置

    @ManyToOne(cascade = CascadeType.REFRESH)
    private RiverFunction function; //水域功能

    private Integer riverNumber=1;     //数量

    private Integer riverArea=0;  //水域面积(单位:平方米)

    private Integer riverAvgDeep=0;  //平均水深(单位:cm)

    private Integer riverCubage=0;   //水域容积

    private Integer involveHouseholds=0;  //涉及户数

    private Integer involvePopulation=0;  //涉及人口

    @ManyToOne(cascade = CascadeType.REFRESH)
    private WaterSituation waterSituation;   //水质情况

    @Column(length = 30,nullable = false)
    private String supplyWaterFrom;     //补给水源

    @Column(length = 30,nullable = false)
    private String drainageWaterTo;     //排水受体

    @Column(length = 100,nullable = false)
    private String existProblem;        //存在问题

    private boolean isSamples;          //是否取样

    @ManyToOne(cascade = CascadeType.REFRESH)
    private User header;                //负责人

    @Column(length = 50,nullable = false)
    private String management;          //管理体制

    private Integer investment=0;         //第年投资(10元/平方米计算)

    @Override
    public String toString() {
        return "River{" +
                "id='" + id + '\'' +
                ", type=" + type +
                ", town=" + town +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", riverName='" + riverName + '\'' +
                ", position='" + position + '\'' +
                ", function=" + function +
                ", number=" + riverName +
                ", riverArea=" + riverArea +
                ", riverAvgDeep=" + riverAvgDeep +
                ", riverCubage=" + riverCubage +
                ", involveHouseholds=" + involveHouseholds +
                ", involvePopulation=" + involvePopulation +
                ", situation=" + waterSituation +
                ", supplyWaterFrom='" + supplyWaterFrom + '\'' +
                ", drainageWaterTo='" + drainageWaterTo + '\'' +
                ", existProblem='" + existProblem + '\'' +
                ", isSamples=" + isSamples +
                ", header=" + header +
                ", management='" + management + '\'' +
                ", investment=" + investment +
                '}';
    }
}

package org.wingstudio.riverheaderinstitution.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RiverVo implements Serializable {

    private String id;

    private String type;     //水域类型

    private String town;          //所属镇

    private Double latitude;    //纬度

    private Double longitude;   //经度

    private String riverName;   //水域名称

    private String position;    //所在位置

    private String function; //水域功能

    private Integer riverNumber=1;     //数量

    private Integer riverArea=0;  //水域面积(单位:平方米)

    private Integer riverAvgDeep=0;  //平均水深(单位:cm)

    private Integer riverCubage=0;   //水域容积

    private Integer involveHouseholds=0;  //涉及户数

    private Integer involvePopulation=0;  //涉及人口

    private String waterSituation;   //水质情况

    private String supplyWaterFrom;     //补给水源

    private String drainageWaterTo;     //排水受体

    private String existProblem;        //存在问题

    private boolean isSamples;          //是否取样

    private String headerName;          //负责人
    private String headerTel;
    private String headerUserCategory;

    private String management;          //管理体制

    private Integer investment=0;         //第年投资(10元/平方米计算)

}

package com.bai.config.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.annotation.Resource;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * order_info
 * @author 
 */
@ToString
@Resource
@Data
@EqualsAndHashCode
public class OrderInfo implements Serializable {
    /**
     * 订单编号
     */
    private Integer accountId;

    /**
     * 车牌号
     */
    private String carNumber;

    /**
     * 车辆所有人的id
     */
    private Integer userId;

    /**
     * 花费
     */
    private BigDecimal cost;

    /**
     * 驶入时间
     */
    private Date comeTime;

    /**
     * 驶出时间
     */
    private Date goTime;

    /**
     * 订单状态（1：已缴费；2：已创建但还未付费）
     */
    private Integer parkingState;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人id
     */
    private Integer createUserId;

    /**
     * 更改时间
     */
    private Date updateTime;

    /**
     * 更改人id
     */
    private Integer updateUserId;

    private static final long serialVersionUID = 1L;

}
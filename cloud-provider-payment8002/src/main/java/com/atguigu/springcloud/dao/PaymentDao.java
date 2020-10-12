package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author chenzhaoxing
 * @Date
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    public  int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}
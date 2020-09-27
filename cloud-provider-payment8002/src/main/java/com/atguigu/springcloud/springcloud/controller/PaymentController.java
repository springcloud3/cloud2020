package com.atguigu.springcloud.springcloud.controller;

import com.atguigu.springcloud.springcloud.entities.CommentResult;
import com.atguigu.springcloud.springcloud.entities.Payment;
import com.atguigu.springcloud.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author chenzhaoxing
 * @Date
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;


    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommentResult create(@RequestBody Payment payment){

        int result = paymentService.create(payment);
        log.info("*****插入结果：" + result);

        if (result>0){
            return new CommentResult(200,"插入数据库成功,serverport："+serverPort,result);
        }else{
            return new CommentResult(444,"插入数据库失败",null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommentResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果：" + payment + "\t" + "哈哈");

        if (payment != null){
            return new CommentResult(200,"查询成功,serverport："+serverPort, payment);
        }else{
            return new CommentResult(444,"没有对应记录,查询ID: " + id,null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
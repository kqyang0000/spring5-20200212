package com.kqyang.proxy;

/**
 * 一个生产者
 */
public class Producer implements IProducer {
    /**
     * 销售
     *
     * @param money
     */
    public void saleProduct(float money) {
        System.out.println("销售商品，并拿到钱" + money);
    }

    /**
     * 售后
     *
     * @param money
     */
    public void afterService(float money) {
        System.out.println("提供守候服务并拿到钱" + money);
    }
}

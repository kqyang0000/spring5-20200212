package com.kqyang.proxy;

/**
 * 生产厂家
 */
public interface IProducer {
    /**
     * 销售
     *
     * @param money
     */
    void saleProduct(float money);

    /**
     * 售后
     *
     * @param money
     */
    void afterService(float money);
}

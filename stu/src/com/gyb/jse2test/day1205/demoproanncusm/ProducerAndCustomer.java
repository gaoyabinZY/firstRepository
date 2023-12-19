package com.gyb.jse2test.day1205.demoproanncusm;

public class ProducerAndCustomer {

    public static void main(String[] args) {
        Product p = new Product();

        Producer producer = new Producer(p);
        Customer customer = new Customer(p);

        Thread pThread = new Thread(producer);
        Thread cThread = new Thread(customer);

        pThread.start();
        cThread.start();
    }
}

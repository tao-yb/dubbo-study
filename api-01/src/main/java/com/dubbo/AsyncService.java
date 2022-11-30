package com.dubbo;

public interface AsyncService {

    User query(String id) throws InterruptedException;

    User querySync(String id) throws InterruptedException;

}

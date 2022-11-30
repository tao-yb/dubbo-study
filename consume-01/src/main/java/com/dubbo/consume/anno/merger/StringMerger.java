package com.dubbo.consume.anno.merger;

import com.alibaba.dubbo.rpc.cluster.Merger;

public class StringMerger implements Merger<String> {
    @Override
    public String merge(String... strings) {
        return String.join("-",strings);
    }
}

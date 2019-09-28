package com.zkg.adapt;

import java.util.HashMap;
import java.util.Map;

/*
 * created by kgzhang 2019/1/6
 */
public class CloudFactory {

    static Map<String,CloudSDK> cloudSDKMap = new HashMap<>();

    static {
        cloudSDKMap.put("AWSSDK",new AWSSDKAdapter(new AWSSDK()));
        cloudSDKMap.put("ALISDK",new AliSDKAdapter(new AliSDK()));
    }

    public static CloudSDK create(String cloudStrategy){
        return cloudSDKMap.get(cloudStrategy);
    }
}

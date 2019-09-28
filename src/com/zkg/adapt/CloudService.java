package com.zkg.adapt;

/*
 * created by kgzhang 2019/1/6
 */
public class CloudService {

    private CloudSDK cloudSDK;

    public CloudService(String cloudStrategy) {
        this.cloudSDK = CloudFactory.create(cloudStrategy);
    }

    public void uploadFile(String fileName) {
        cloudSDK.putObject(fileName);
    }
}

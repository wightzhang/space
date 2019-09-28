package com.zkg.adapt;

/*
 * created by kgzhang 2019/1/6
 */
public class AWSSDKAdapter implements CloudSDK {
    private AWSSDK awssdk;

    public AWSSDKAdapter(AWSSDK awssdk) {
        this.awssdk = awssdk;
    }

    @Override
    public void putObject(String fileName) {
        awssdk.putObject(fileName);
    }
}

package com.zkg.adapt;

/*
 * created by kgzhang 2019/1/6
 */
public class AliSDKAdapter implements CloudSDK {

    private AliSDK aliSDK;

    public AliSDKAdapter(AliSDK aliSDK) {
        this.aliSDK = aliSDK;
    }

    @Override
    public void putObject(String fileName) {
        aliSDK.setBucket();
        aliSDK.uploadFile(fileName);
    }
}

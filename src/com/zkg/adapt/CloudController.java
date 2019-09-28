package com.zkg.adapt;

/*
 * created by kgzhang 2019/1/6
 */
public class CloudController {
    //private CloudService cloudService = new CloudService("");
    public void storeFileToCloud(String cloudStrategy){
        CloudService cloudService = new CloudService("");
        cloudService.uploadFile("张凯歌.zip");
    }

    public static void main(String[] args) {
        CloudService cloudService = new CloudService("ALISDK");
        cloudService.uploadFile("张凯歌.zip");
    }
}

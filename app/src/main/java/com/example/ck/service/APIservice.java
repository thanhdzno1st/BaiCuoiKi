package com.example.ck.service;

public class APIservice {
    private static String base_url="http://musictbp.atwebpages.com/Server/";
    public static Dataservice getService(){
        return APIRetrofitClient.getClient(base_url).create(Dataservice.class);
    }
}

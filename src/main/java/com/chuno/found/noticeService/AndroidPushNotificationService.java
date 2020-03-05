package com.chuno.found.noticeService;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

// firebase_server_key = firebase project > cloud messaging > server key

@Service
class AndroidPushNotificationsService {



    private static final String firebase_server_key="AAAAfJqWSXs:APA91bFiEwTicbYazpmPJjxdI6xw7yox-C_YHOY3LGtpWcQjzP8taGleEmPm8duVEgBqdyj-KJFU-_y_xw_00J83t1c1PO2vmifHh2GVRE602c16cIWd5Nicua8HtDWt1FtV7VIbNmIC";
    private static final String firebase_api_url="https://fcm.googleapis.com/fcm/send";


    @Async
    public CompletableFuture<String>send(HttpEntity<String> entity) {



        RestTemplate restTemplate = new RestTemplate();

        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();

        interceptors.add(new HeaderRequestInterceptor("Authorization",  "key=" + firebase_server_key));
        interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json;"));
        restTemplate.setInterceptors(interceptors);

        System.out.println("AndroidPushNotificationsService : "+entity);
        System.out.println("AndroidPushNotificationsService getBody : "+entity.getBody());
        System.out.println("AndroidPushNotificationsService getHeaders : "+entity.getHeaders());

        String firebaseResponse = null;


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization",firebase_server_key);
        headers.set("Content-Type","application/json");


        try{
            firebaseResponse = restTemplate.postForObject(firebase_api_url, entity, String.class);
            System.out.println("connection success: "+firebaseResponse);
        }catch (HttpClientErrorException e){
            System.out.println("this is e 0304: "+e);
        }



        System.out.println("return 직전 ");
        return CompletableFuture.completedFuture(firebaseResponse);
    }

}

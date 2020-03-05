package com.chuno.found.noticeService;

import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AndroidPushPeriodicNotifications {

    public static String PeriodicNotificationJson()  {
        LocalDate localDate = LocalDate.now();

        //실제로 이부분이 유저의 아이디가 들어갈 값. 아이디란 휴대폰을 말함
        String sampleData[] = {
               "c17n4M3G1EWsnAbllrE5Gm:APA91bH_VJGojamuwggMyta4TI6RwNUEWv6DloMCPGR_hdyPlIzFqUAl3Z1HMHdy4HlVJI2xxnM_sHum5cND3awQ1HpMqyqJlOvxPq03jH62jXSoEljX1NOZn9BdyF1jVcaoZBO9Ps_6",
"c7mYyrURofs:APA91bFpKeSvZWwkaNZ_uSZSSBZfVoECmCyMGgL10V8eMQ3uVp2PTQ79p_ti4YDtr3YArnoRItyATfGUVHlBlq2jOyS6a3S8_zModh62fkPa6njaKcTXkgODvZFaIfVFe9FMB08v2mqK",
                "d0RIHLIbqUv3mJd5HF1RXn:APA91bFoikg3ntb1fbtkY7pRhmYuqMVJX2xBlmMORrQBV6lAzhg-Y9Npvy-7ETClSGYMkOiYW_R1Xl8R8Ic-Tk6oy38NXdxBh9S_Y9laO7g23M--2SjA5bJv-kcTO7gSvsprY9zMQXJ0",
                "eS9GXdtjrEpggBKDYMK9hj:APA91bGgucW_RLKAXKsz-mj_Q-AWknCq63c5ChEpK7l8iQfGLYRBEuptbi2iftj_L1mvnvX7i7XVowDw8Y7OqDFTN7TjMw12TOQbub--Kji6klDnbupFj-XhrswtDyqMZeWgCpYouO1D",
                "eeVuNGDuTdI:APA91bGk-OBVXP3__Yu0hc0FF0f7om2tA9YCb8NmuvhgQmjLNgS_OGjU4o2xtyjpAnIuQL-09AzxkQVMVfRrXHV_BgKbHEECsE0_hc7fb6R9zpaNUAZ19IHDqlPiVORNB4eDswLG-qZt"
        };

        String sampleData2 ="eeVuNGDuTdI:APA91bGk-OBVXP3__Yu0hc0FF0f7om2tA9YCb8NmuvhgQmjLNgS_OGjU4o2xtyjpAnIuQL-09AzxkQVMVfRrXHV_BgKbHEECsE0_hc7fb6R9zpaNUAZ19IHDqlPiVORNB4eDswLG-qZt";
        //c7mYyrURofs:APA91bFpKeSvZWwkaNZ_uSZSSBZfVoECmCyMGgL10V8eMQ3uVp2PTQ79p_ti4YDtr3YArnoRItyATfGUVHlBlq2jOyS6a3S8_zModh62fkPa6njaKcTXkgODvZFaIfVFe9FMB08v2mqK
        //eeVuNGDuTdI:APA91bGk-OBVXP3__Yu0hc0FF0f7om2tA9YCb8NmuvhgQmjLNgS_OGjU4o2xtyjpAnIuQL-09AzxkQVMVfRrXHV_BgKbHEECsE0_hc7fb6R9zpaNUAZ19IHDqlPiVORNB4eDswLG-qZt

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<sampleData.length; i++){
            tokenlist.add(sampleData[i]);
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {

            array.put(sampleData[i]);
        }

        body.put("registration_ids", sampleData);

        JSONObject notification = new JSONObject();
        notification.put("title"," hi im dragonhee");
        notification.put("body"," thank you bye~");
        //notification.put("data","Today is "+localDate.getDayOfWeek().name()+"!");

        JSONObject data = new JSONObject();
        data.put("product","macbook");
        data.put("total","1");
        data.put("seller","jeffd23");



        body.put("notification", notification);
        body.put("data" , data);
        System.out.println("PeriodicNotificationJson body.toString"+ body.toString());

        return body.toString();
    }


}

package com.c174.tools;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.Map;
import java.util.UUID;

public class QrGeneration {

    public void generateQr(String path, String charset,
                           Map hashMap, int height,
                           int width){
        UUID uuid = UUID.randomUUID();
        String chain = uuid.toString();

        
    }

    @Scheduled(fixedRate = 300000)
    public void regeneratQr(){

    }
}

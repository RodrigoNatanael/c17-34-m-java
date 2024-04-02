package com.c174.controllers;

import com.c174.tools.QrGeneration;
import com.c174.tools.ResponseImg;
import com.google.zxing.WriterException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/get/{archName}")
    public ResponseEntity<?> testPoint(@PathVariable String archName) throws IOException, WriterException {
        Boolean response = QrGeneration.generateQr(archName+".png",200, 200);
        if (response) {
            System.out.println("salio bien");
            return new ResponseEntity<>("todo ok", HttpStatus.OK);
        }
        System.out.println("salio mal");
        return new ResponseEntity<>("todo mal", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/del")
    public ResponseEntity<?> testDelete() throws URISyntaxException {
        Boolean response = QrGeneration.deleteQr("test.png");
        if (response) {
            System.out.println("salio bien");
            return new ResponseEntity<>("todo ok", HttpStatus.OK);
        }
        System.out.println("salio mal");
        return new ResponseEntity<>("todo mal", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/take")
    public ResponseEntity<?> testTakeQr() throws IOException {
        String  response = QrGeneration.takeQr("test.png");
        if (response.isEmpty()) {
            System.out.println("salio mal");
            return new ResponseEntity<>("todo mal", HttpStatus.BAD_REQUEST);
        }
        System.out.println("salio bien");
        return new ResponseEntity<>(new ResponseImg(response), HttpStatus.OK);
    }
}

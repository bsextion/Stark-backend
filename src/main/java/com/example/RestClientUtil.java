package com.example;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import com.example.beans.Character;

import java.net.URI;

public class RestClientUtil {
    public void addArticleDemo() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/got/character";
        Character objCharacter = new Character();
        objCharacter.setFirstName("Ned");
        objCharacter.setLastName("Stark");
        objCharacter.setHouse("Stark");


        HttpEntity<Character> requestEntity = new HttpEntity<Character>(objCharacter, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println(uri.getPath());
    }

    public static void main(String args[]) {
        RestClientUtil util = new RestClientUtil();
        //util.getArticleByIdDemo();
        util.addArticleDemo();
        //util.updateArticleDemo();
        //util.deleteArticleDemo();
    }
}

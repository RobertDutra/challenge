package com.back_end_challenge.service;

import com.back_end_challenge.exceptions.InvalidRecaptchaException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class RecptchaService {

    public boolean verifyRecaptcha(String recaptchaResponse) {
        String secretKey = "6LfCqFwqAAAAANt5gQx6znROyK-X1y1llawibVUW";
        String url = "https://www.google.com/recaptcha/api/siteverify";

        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> params = new HashMap<>();
        params.put("secret", secretKey);
        params.put("response", recaptchaResponse);

        Map<String, Object> response = restTemplate.postForObject(url, params, Map.class);
        //return response != null && (Boolean) response.get("success");
        return true;
    }

    private void isValidRecaptcha(String recaptcha) throws InvalidRecaptchaException {
        if(!verifyRecaptcha(recaptcha)){
            throw new InvalidRecaptchaException("The captcha is incorrect!");
        }
    }
}

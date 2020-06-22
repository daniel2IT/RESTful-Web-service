package com.letstartfinalproject.demo.rapidAPI;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Component;

@Component
public class Exchange {

    HttpResponse<String> response = Unirest.get("https://currency-exchange.p.rapidapi.com/exchange?q=1.0&from=SGD&to=MYR")
            .header("x-rapidapi-host", "currency-exchange.p.rapidapi.com")
            .header("x-rapidapi-key", "f783cdcc38msh3d43ae13da0d407p1fae1ejsnc5ec5fce834e")
            .asString();

    public Exchange() throws UnirestException {
    }
}

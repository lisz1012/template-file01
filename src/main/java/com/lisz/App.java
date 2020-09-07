package com.lisz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {
    public static void main( String[] args ) throws Exception {
        SpringApplication.run(App.class, args);
        new MyApp().createHtml();
    }
}

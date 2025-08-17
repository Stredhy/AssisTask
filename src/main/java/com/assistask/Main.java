package com.assistask;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


/*
    Styles color

    --first: #120907;
    --second: #141b3d;
    --third: #344f8b;
    --fourth: #6a82e1;
    --fifth: #a0b4e9;

    |-> Alerts
    --first: #400932;
    --second: #940a39;
    --third: #eaa8eb;
    --fourth: #f8c6ed;
    --fifth: #f8e9ed;
    
 */

@SpringBootApplication
public class Main{
    private static ConfigurableApplicationContext springContext;
    
    public static void main(String[] args) {
        springContext = SpringApplication.run(Main.class,args);
        
        Application.launch(JavaFXApp.class, args);
    }

}
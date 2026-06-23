package com.portale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PortaleApplication {

    // main = punto d'ingresso classico di un'app Java.
    // args sono gli argomenti passati da linea di comando (qui non li uso,
    // ma Spring li puo leggere per cambiare config al volo, es. --server.port=9090)
    public static void main(String[] args) {
        // avvia il backend - Spring si occupa di tutto il resto:
        // tira su Tomcat embedded, crea i bean, apre la connessione al DB
        SpringApplication.run(PortaleApplication.class, args);
    }
}

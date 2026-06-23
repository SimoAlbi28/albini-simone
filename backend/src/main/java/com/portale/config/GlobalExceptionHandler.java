package com.portale.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * gestore globale degli errori.

 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // logger di slf4j (e' la libreria di logging standard di spring boot)
    // gli passo "this.getClass()" cosi nei log appare il nome della classe
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * crea il body di risposta in formato standard, cosi il frontend sa
     * sempre cosa aspettarsi: { errore, messaggio, classeEccezione, timestamp }
     */
    private Map<String, Object> creaBody(String errore, String messaggio, Exception ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("errore", errore);
        body.put("messaggio", messaggio);
        // metto anche la classe dell'eccezione, e' utile per il debug
        body.put("classeEccezione", ex.getClass().getSimpleName());
        body.put("timestamp", LocalDateTime.now().toString());
        return body;
    }

    /**
     * errori di validazione sui DTO (@NotBlank, @Email, @Size, ecc.)
     * ritorno un 400 con la mappa "campo -> messaggio errore"
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> gestisciValidazione(
            MethodArgumentNotValidException ex) {

        // raccolgo tutti gli errori di campo in una mappa
        Map<String, String> erroriCampi = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(fe ->
                erroriCampi.put(fe.getField(), fe.getDefaultMessage())
        );

        // log a console - WARN perche e' colpa del client, non un bug nostro
        log.warn("Validazione fallita: {}", erroriCampi);

        // body di risposta arricchito - oltre al riepilogo metto anche
        // la mappa dei campi cosi il frontend puo evidenziarli uno per uno
        Map<String, Object> body = creaBody(
                "Dati non validi",
                "Uno o piu campi non rispettano i vincoli di validazione",
                ex);
        body.put("campi", erroriCampi);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    /**
     * eccezioni che il service lancia esplicitamente (es. quando una
     * proposta non esiste lancio ResponseStatusException(404, "..."))
     */
    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<Map<String, Object>> gestisciResponseStatus(ResponseStatusException ex) {

        log.warn("Errore di stato {}: {}", ex.getStatusCode(), ex.getReason());

        Map<String, Object> body = creaBody(
                ex.getStatusCode().toString(),
                ex.getReason() != null ? ex.getReason() : "Errore",
                ex);

        return ResponseEntity.status(ex.getStatusCode()).body(body);
    }

    /**
     * argomenti non validi passati a un metodo
     * (es. id null dove serve un id valorizzato)
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String, Object>> gestisciIllegalArgument(IllegalArgumentException ex) {

        log.warn("Argomento non valido: {}", ex.getMessage());

        Map<String, Object> body = creaBody(
                "Richiesta non valida",
                ex.getMessage() != null ? ex.getMessage() : "Argomento non valido",
                ex);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    /**
     * fallback generico - qualunque altra eccezione finisce qui.
     * stampo lo stack trace completo a console (livello ERROR) cosi vedo
     * subito a quale riga e' esplosa la cosa
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> gestisciGenerico(Exception ex) {

        // log.error con due argomenti: il primo e' il messaggio, il secondo
        // e' l'eccezione stessa - slf4j stampa anche lo stack trace
        log.error("Errore non gestito sul backend: {}", ex.getMessage(), ex);

        Map<String, Object> body = creaBody(
                "Errore interno del server",
                ex.getMessage() != null ? ex.getMessage() : "Si e' verificato un errore imprevisto",
                ex);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}

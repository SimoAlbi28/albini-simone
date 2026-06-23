# Documento Tecnico
## Mini-portale eventi culturali "Trezzano Events"

**Corsista**: Simone Albini
**Data**: 23/06/2026
**Percorso**: Fullstack Developer 
**Link prototipo Figma**: https://www.figma.com/design/rcjLFDwtnQilzUQwybHrhk/WorkSpaceNow?node-id=0-1&t=UsiuEIQ2kQJ2ZNY5-1

---

## 1. Contesto e obiettivo
Qualche settimana fa sono stato contattato dal Capo dell'azienda WorkSpaceNow (MI), che è un azienda che gestisce gli spazi di coworking, e mi ha spiegato la loro necessità di avere un sito moderno, fluido, intuitivo fatto apposta per adattarsi ad ogni tipo di dispositivo.


Da questa richiesta è nato il sito di **WorkSpaceNow**, un portale che ho progettato con tre obiettivi chiari:
- **visualizzare** tutti gli spazi disponibili in tutta Italia
- **gestire** le prenotazioni delle personone che vogliono lavorare in tranquillità

L'idea è che il portale sia il più possibile leggero, responsive e usabile anche da utenti non esperti e magari che hanno una certa età, quindi ho optato per un sito semplice ma efficace e intuitivo per ogni tipo di persona.

## 2. Tecnologie utilizzate

### Front-end (pnpm create vite@latest) -->
- **HTML5** — struttura semantica della pagina
- **CSS3** — personalizzazione stili, variabili
- **Bootstrap 5.3.3** layout responsive, componenti (navbar, card, form)
- **JavaScript** — gestione invio form, validazione proposta
- **Vite** — dev server e build tool

## 3. Architettura prevista client/server
Il progetto è pensato per avere una chiara separazione tra **front-end** e **back-end**. Nel tempo a disposizione sono riuscito a completare la parte front-end in tutti i suoi aspetti, mentre il back-end era previsto in scaletta ma non ho avuto il tempo materiale per implementarlo; 


Il front-end è una **Single Page statica** servita da Vite. 

## 4. Flusso di navigazione
1. L'utente arriva sulla landing page
2. Dalla navbar può cliccare **Sedi** / **Prenota** / **Contatti** per scorrere alla sezione
3. Visualizza le sedi disponibili nella sezione "Sedi Disponibili"
4. Per prenotare ci sarà la sezione "Prenotazioni"
5. Compila i campi (validazione client-side) e preme **Invia proposta**
6. Il front-end prepara i dati e tenta l'invio al back-end 
7. A seconda della risposta viene mostrato un **alert** verde (successo) o rosso (errore o server non disponibile)

## 5. Componenti dell'interfaccia
- **Navbar responsive** (collassa in menu hamburger sotto 992px)
- **Hero** con titolo grande e slogan
- **Card evento** con immagine, badge categoria colorato e testo
- **Form** con campi input/select/textarea, label associate, messaggi d'errore dedicati
- **Alert di feedback** mostrato dopo l'invio del form
- **Footer** a 3 colonne con informazioni varie sede ecc


## 6. Responsive design
La pagina si adatta a:
- **Mobile** 
- **Tablet** 
- **Desktop** 


## 7. Descrizione delle attività svolte
1. **Progettazione Figma** del prototipo con struttura a sezioni
2. **Pulizia del progetto base React - Vite** 
3. **Sviluppo HTML**: struttura semantica con header, main, section, footer
4. **Integrazione Bootstrap 5** per layout responsive e componenti
5. **CSS personalizzato** in `css/style.css` per override colori, hover card e focus accessibile
6. **Sviluppo JavaScript** in `js/app.js` per intercettare l'invio del form, validare i campi e predisporre la chiamata `fetch` verso il back-end, con gestione della risposta (successo / errore)
7. **Test responsive** su diverse larghezze via DevTools

> **Nota**: la prova prevedeva anche lo sviluppo di un back-end Spring Boot con persistenza JPA e Swagger. Avevo pianificato di realizzarlo dopo aver completato il front-end, ma il tempo a disposizione non mi ha permesso di arrivare a sviluppare anche quella parte. 

## 8. Istruzioni per avviare l'applicazione

### Front-end
Requisiti: **Node.js 18+** e **pnpm** (o npm).

```bash
pnpm install
pnpm dev
```

Per la build di produzione:
```bash
pnpm build
pnpm preview
```

## Risposte alle domande aperte

### 1. React e sviluppo dell'interfaccia


### 2. DevOps applicato al progetto

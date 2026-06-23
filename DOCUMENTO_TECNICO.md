# Documento Tecnico
## Mini-portale eventi culturali "Trezzano Events"

**Corsista**: Simone Albini
**Data**: 23/06/2026
**Percorso**: Fullstack Developer 
**Link prototipo Figma**: https://www.figma.com/design/rcjLFDwtnQilzUQwybHrhk/WorkSpaceNow?node-id=0-1&t=UsiuEIQ2kQJ2ZNY5-1
**Avvio Frontend**:pnpm dev
**Avvio backend**:cd backend1 --> mvn spring-boot:run
**Link DB**:http://localhost:8080/h2-console/login.do?jsessionid=5c139becf781651c9e14c23166a337d2
---

![alt text](image-1.png)

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

Per quanto riguarda DevOps userei GitHub appunto per riuscire a gestire meglio l'intero progetto organizzando meglio il codice e riuscendo a separare tramite le branch le varie categorie di modifiche.
Ad esempio se in futuro dovessi andare a fare ulteriori modifiche, creerei delle branch apposta (git checkout -b nome-branch) per mantenere "immune" per il momento la branch main, e andando comunque a modificare il codice partendo proprio da quella branch.
Ogni modifica che andrò a fare sarà seguita da una commit che specifica la modifica eseguita, e quando una branch sarà pronta per la merge alla branch main, allora li farò la pull request per riuscire a "mergiare" il tutto.
una volta confermata la merge, tornerò nel progetto su vsCode e farò la pull dei cambiamenti che si saranno a quel punto sostati sulla branch principale(main).
A mio parere la creazione delle branch aiuta soprattutto in lavori dove sul codice lavora piu di una persona, perchè almeno c'è molta meno probabilità che vengano fuori dei conflitti perchè magari sta lavorando più di una persona sullo stesso codice, e cosi facendo le modifiche si sovrastano creando appunto conflitti di codice.
Inoltre sfrutterei le github actions per migliorare dal punto di vista organizzativo e automatizzare delle parti di codice.
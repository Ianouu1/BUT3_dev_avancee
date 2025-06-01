# BUT3_dev_avancee

## Versions du projet

Les différentes versions du projet peuvent être retrouvées à travers les branches suivantes :

- **20-05-rendu1** (V5)
- **web_xml** (V4)
- **MVC_2_WITH_INTERFACE** (V3)
- **MVC2** (V2)
- **master** (V1)

---

# Questions qui seront posées pendant l'oral de dernière séance :

## 1️⃣ Qu'est-ce qu'un framework ?

Un framework est un ensemble de bibliothèques et d'outils qui facilite le développement d'applications en fournissant
une structure de base et des fonctionnalités réutilisables.

### 📄 TLDR

> Un framework permet d'écrire du code à notre place. (En réutilisant des classes et des méthodes déjà écrites)

## 2️⃣ Quelle est la différence entre un modèle MVC et MVC2 ?

1. Dans un modèle MVC (⚠️MVC1 = pléonasme), on utilise autant de servlet que de boutons.
2. Dans un modèle MVC2, il y a une servlet qui gère tous les boutons.

⚠️ Pour un framework, il faut utiliser un modèle MVC2. (pour éviter d'avoir à ajuster le nombre de servlet à chaque
ajout de bouton)

### Informations complémentaires

- Un modèle MVC sera plus rapide qu'un modèle MVC car il ira droit au but
- Le modèle MVC est vieux, MVC2 plus récent.

|          | MVC                                                              | MVC2                                                                                                         |
|----------|------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------|
| Couches  | 3                                                                | 5                                                                                                            |
| Couche 1 | Vue + Contrôleur : La vue sait vers service rediriger la requête | Vue (Page Web) : HTML, JSP                                                                                   |
| Couche 2 | Modèle (cf. MVC2)                                                | Contrôleur (Reçoit les requêtes, redirige vers le bon service) : Servlet                                     |
| Couche 3 | Persistance (cf. MVC2)                                           | Service (Uniquement le processus métier, les "verbes"/"actions") : Ajouter un client, Supprimer un client... |
| Couche 4 | ---                                                              | Modèle (Représentation des données, classes Java qui représentent les données) : LoginAction, ActionUn...    |
| Couche 5 | ---                                                              | Persistance (Lien entre les modèles (classes) et la base de données)                                         |

### Exemple avec un service de login en MVC2

1. Vue : formulaire avec username/password
2. Contrôleur : Servlet (unique) qui reçoit la requête, instancie LE service de login parmi les autres services
3. Service : Contient la logique métier :
    - ajouterLogin()
    - isValid()
    - changePassword()
    - findAll()
4. Modèle : classe Login
    - Attributs : String nom, String password
    - Getters, Setters
5. Persistance (anciennement DAO, maintenant appelée repository) qui permet de gérer l'accès aux données :
    - insertLogin(Login login)
    - findIdByNom (String nom)
    - ... (toutes les méthodes qui vont faire le lien entre les modèles et la BD)

## 3️⃣ Qu'est-ce qu'un URL mapping ?

Permet de mettre en relation des URL avec les contrôleurs / faire des **redirections**. L'URL mapping fais le lien entre
le monde extérieur/intérieur

(MAPPING = mettre en relation)

## 4️⃣ Quelle est la différence entre la configuration par annotations et la configuration xml ?

- Annotation = disperse les routes dans différents fichiers
- XML = centralise les routes dans un seul fichier

### Quand est-ce que sont résolus les XML et les annotations ?

À l'initialisation du serveur

## 5️⃣ Qu'est-ce que déployer une application ?

Mise en production, rendre l'application accessible pour d'autres personnes

## 6️⃣ Comment déployer une application sur tomcat ?

1. (Install tomcat)
2. (Ouvre les ports du serveur)
3. faire un .war (web archive) qui contient déjà plus de trucs (des images, page web, fichier de config)
4. le mettre dans le fichier application de tomcat

### Random knowledge

- On utilise .jar pour les applications qui ne nécessite pas de serveur (Tomcat)
- On utilise .war pour les applications qui nécessitent un serveur (Tomcat)
- On peut .jar <=> .zip

## 7️⃣ Où est-ce que le programmeur définit le mapping ?

Dans un fichier XML (services.xml dans le cas présent)

### Additional knowledge

- XML : Fichier texte qui permet de structurer les données
- On favorise les bases de données XML, car elles sont plus rapide que les base de données "en table" : SQL
- (Un fichier XML est un modèle DICK)

## 8️⃣ Comment le programme utilise le fichier xml ? qu'est-ce qu'il en fait ?

Le programme **lis le fichier XML** et **remplis une hashmap** :

- Clé = l'URL-pattern, ce qu'il y a dans la page HTML
- Valeur = Une classe Action qui identifie l'action à réaliser

Cette Hashmap permet de **faire le lien entre la page HTML et le serveur**

## 9️⃣ Quel est le design-pattern au cœur du modèle MVC ?

- C'est une Factory (usine à classe) : Rentre un String ==> me donne une classe
- Factory = Design-pattern qui associe instance de la classe à un string

### Retenir

MVC2 = C'est une Factory car un String du monde extérieur associe une classe du monde intérieur

## 1️⃣0️⃣ Quelles sont les particularités des actions du modèle MVC2

- Autant d'actions dans le modèle MVC2 qu'il y avait dans le modèle MVC2 (et autant de servlets accessoirement)
- Une action = un truc à faire sur un click
- Les actions seront appelés selon une Hashmap, qui va faire le lien entre la page HTML et l'action à réaliser.
- Les actions implémentent la même interface
- Toutes les actions implémentent une interface `Action` avec une méthode `perform(request, response)` → retourne un
  string (URL de suite en .jsp)

## 1️⃣1️⃣ Quelle est le rôle de la servlet en MVC2

1. Le controller récupère l'URL d'appel
2. Grâce à l'URL d'appel, la hashmap trouve l'action à instancier
3. La servlet instancie l'action grâce à la Factory
4. Elle appelle la méthode `perform(request, response)` de l'action, qui retourne un String (l'URL de suite)

## 1️⃣2️⃣ Quels sont les 2 design-patterns utilisés dans un framework MVC2

1. Factory
2. Singleton (paterne qui permet d'instancier une casse qu'une seule fois)

## 1️⃣3️⃣ Qu'est-ce qu'un design-pattern ?

Méthode pour résoudre un problème d'architecture récurrent.

### Exemple

#### Modes de livraisons d'Amazon

- Aujourd'hui : Camion
- Demain : Drones (? Peut être)
- Dans 10 ans : de nouveaux modes de livraisons

#### On observe

- Il faut un mode de livraison (obligatoire)
- Un seul peut être utilisé à la fois
- Des nouveaux modes de livraison peuvent être ajoutés

Ainsi, on peut créer un design-pattern qui permet de gérer les modes de livraison d'Amazon, et d'en rajouter de nouveaux
sans modifier le code existant

## 1️⃣4️⃣ Qu'est-ce qu'une Servlet ?

Une servlet est un composant Java côté serveur qui permet de traiter des requêtes HTTP et de générer des réponses
dynamiques, généralement dans une application web.

Définition simple :
Une servlet est une classe Java qui s’exécute dans un serveur d’applications (comme Tomcat) et qui répond aux requêtes
HTTP, souvent via une URL.

---

## Histoires pour tester la compréhension

### Méthodologie

1. Identifier les noms (modèle)
2. Identifier les verbes (service)
3. Identifier les interfaces (quand on veut regrouper des noms)

---

### Les élèves mangent des repas

- Dans Modèle : on a les classes `élève`, `repas` (Un nom = une classe)
- Dans Service : on a le service `mange` (un verbe = une méthode)

**PK y'a pas de DAO ?** ==> car on sauvegarde pas dans la BD

#### NB

Si j'avais rajouté "je veux que mes élèves soient sauvegardées dans une BD"
Dans repository ==> package repository avec une methode InsertEleve, deleteEleve..

---

### Le magasin vend des articles, les articles sont des ordinateurs, chaises, tables. Je veux que le tout soit organisés dans une BD

- Dans Modèle (noms = classe) :
    - Interface `Article` ("les articles", quand on veut dire "les" on veut les regrouper == Interface)
    - Classe `Magasin`
    - Classe `Ordinateur`
    - Classe `Chaise`
    - Classe `Table`
- Dans service (verbes = méthode) :
    - `Vends(Magasin, Article)`
- Dans Repository (quand je dois enregistrer/manipuler des données dans une BD) :
    - `MagasinDAO` (pour manipuler les magasins)
    - `ArticleDAO` (pour manipuler les articles)
    - `OrdinateurDAO` (pour manipuler les ordinateurs)
    - `ChaiseDAO` (pour manipuler les chaises)
    - `TableDAO` (pour manipuler les tables)
        - ==> Insert/Delete/FindByID

---

### Un site de gestion d'université

- Site de gestion d'université
- Une université à des étudiants
- Chaque étudiant à un seul et un seul cursus. Il existe 3 cursus possible CursusSciences, CursusLettres, CursusDroit
- L'étudiant peut se loguer pour consulter son cursus, consulter ses informations personnelles
- Le tout est sauvegardé dans une bdd

- Dans Modèle (noms = classe) :
    - Interface `Cursus` ("les cursus", regroupement logique)
    - Classe `Universite`
    - Classe `Etudiant`
    - Classe `CursusSciences`
    - Classe `CursusLettres`
    - Classe `CursusDroit`
    - Classe `Login` (séparé d’Etudiant pour des raisons de sécurité)
- Dans Service (verbes = méthode) :
    - `GestionEtudiant`
    - `GestionCursus`
    - `GestionLogin`
- Dans Contrôleur (une interface par action) :
    - `ConsultCursus`
    - `ConsulterInfoPerso`
    - `Login`
- Dans Repository (quand je dois enregistrer/manipuler des données dans une BD) :
    - `UniversiteRepository` (pour manipuler les universités)
    - `EtudiantRepository` (pour manipuler les étudiants)
    - `CursusDAO` (interface commune pour manipuler les cursus)
    - `CursusSciencesRepository` (pour manipuler les cursus sciences)
    - `CursusLettresRepository` (pour manipuler les cursus lettres)
    - `CursusDroitRepository` (pour manipuler les cursus droit)
        - ==> Insert/Delete/FindByID
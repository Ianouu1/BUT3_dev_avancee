# BUT3_dev_avancee

## Versions du projet

Les différentes versions du projet peuvent être retrouvées à travers les branches suivantes :

- **web_xml** (V4)
- **MVC_2_WITH_INTERFACE** (V3)
- **MVC2** (V2)
- **master** (V1)

(lien de mon google docs perso du cours du 25/03 : https://docs.google.com/document/d/1q-WCj3XiBPIFcV2f7FvaTGEg_ZFOX2a-Pkrg3MJVks0/edit?tab=t.0)
# Questions qui pourraient être posées pendant l'oral de dernière séance :
1) Qu'est-ce qu'un framework ?

Ca permet d'écrire du code à notre place
2) Quelle est la différence entre un modèle MVC et MVC2 ?

Un modele MVC (On dit MVC pas MVC1), il y a autant de servlet que de boutons
Un modèle MVC2, il y a une servlet qui gère tout

Pour un framework, il faut un unique servlet qui gère tout

Si on veut qu'il écrive le code pour nous il nous faut un unique servlet 

Le code est plus rapide en MVC car straight to the point

Le modèle MVC est vieux, MVC2 plus récent.
MVC 2 ++> modele a 5 couche VS modèle & 3 couches pour MVC

MVC2 :
- Vue (page)
- Controleur (qui fait larrivée de la vue)
- Service (uniquemetn le processus métier, les "verbes", les "actions" : ajouter un client, supprimer un client...)
- Modèle (Entité, classes de java)
- Persistance (qui fait le lien entre les modèles et la base de donnée)

Prenons l'exemple d'un service de login :
Dans un service de login j'ai la vue(osef)
Dans le modèle j'ai la classe login avec String nom, String password, getters, setters
Dans la couche de persistance (avant DAO, maintenant on l'appelle repository) : on a un login home/loginDAO : attribut un login, méthode inserlogin, findloginbyID ==> toute les méthodes uqi fvotn fair ele lien entre les modele et la base de données
La couche service a comem méthode (classe service login) : méthode ajouter un login, isvalid, changepassword, findall..
La classe controller a une méthode par click de la vue

==> En gros
la classe vue à le droit d'appeler que le controlleur
Le controlleur a comme attribut le service
Le service a comme attribut le repository

<!> SERA REPOSÉE DANS 15 JOURS

3) Qu'est-ce qu'un URL mapping ?

Mot important : REDIRIGER

MAPPING : mettr een relation

Mettre en relation l'URL et les controlleurs

Dans la forme
Action cacahuete, a l'iterieur on a un controlleur ControllerDeLogin : URL mapping ais le lien entre le monde extérieur/intérieur

4) Quelle est la différence entre la configuration par annotations et la configuration xml ?

l'anotation gener eun fichier xxml : simplification de la configuration basique des serveurs

Par contre la cnfiguration par xml, on peut faire bcp plus de choses

99% on utilise les 2 :
On fait un bon par annotation et le ssubitilités on le fait dans le fichier XML

#### Quand est-ce que sont résolus les XML et les annotations ?
Dans l'initialisation du serveur

5) Qu'est-ce que déployer une application ? 

Mise en production, le rendre accessible par les autres.

6) Comment déployer une application sur tomcat ?

1 - Install tomcat
2 - ouvre les ports du serveur
3 - faire un .war (web archive) qui contient déjà plus de trucs (des images, page web, fichier de config)
4 - le mettre dans le fichier application de tomcat

(btw on peut .jar <=> .zip)

7) Où est-ce que le programmeur définis le mapping ?

Dans un fichier XML (web.xml dans le cas présent)
#### Qu'est-ce qu'un fichier XML
Fichier texte qui permet de structurer les données

On favorise les bases de données XML, car elles sont plus rapide que les base de données "en table" : SQL

Un fichier XML est un modèle DICK.

8) Comment le programme utilise le fichier xml ? qu'est-ce qu'il en fait ?

Le programme lis le fichier xml et va remplir une hashmap dans laquelle la clé est l'url pattern et l'action est le nom de la chose à faire.

Dans la hashmap y'a la clé et la valeur : 
- la clé : c'est l'url pattern, ce qu'il ya dans la page HTML
- Value : une classe d'action, qui est un mot clé qui identifie l'action à faire 

La Hashmap permet de faire le lien entre la page HTML et le serveur

On cherche ce qui arrive depuis la page HTML et on a un mot clé qui nous permet de fire ce qu'il faut faire quand on arrive depuis cet url pattern.

Les classes d'acitons concerne les trucs à faire selon l'url pattern

9) Quel est le design pattern au coeur du modèle MVC ?

C'est une Factory (usine à classe) : Rentre un String ==> Me donne une classe

Factory = DDesign Pattern qui associe instance de la classe à un string

MVC2 :
C'est une Factory car un String du monde extérieur associe une classe du monde intérieur

10) Quelles sont les particularités des actions du modèle MVC2

Il y a autant d'actions dans le modèle MVC2, qu'il y avait avant de servlet dans le modèle MVC.

Une action = un truc à faire sur un click

Les actions seront appelés selon la Hashmap, qui va faire le lien entre la page HTML et l'action à réaliser.

Les actions ont la particularité d'implémenter toutes la même interface

Les actions ont toutes au moins une méthode qui a la même tête que la méthode d'une servlet CAD elle prends en argument une requete, une response pour ce qui va partir et retourne une string (étant l'url de suite)

En gros l'action ajoute, insère un nouveau login => Elle a une méthode qui prends en arg la requ/lesposne qui va retourne une string "ok login" qui est une url de suite.

Le return de la méthode d'action est généralement une .jsp qui continue le programme.

11) Quest-ce que contient la String retournée par une action

La .jsp par laquelle il faut continuer (qui contient l'url de suite : déjà partiellement répondue dans la question précédente)

12) Quelle est l'algo de la servlet du MVC2

Le controlleur récupère l'url d'appel

A partir de l'url dappel par la hashmap va déterminé l'action qui correspond à l'url

Elle instancie l'action

Elle appelle la méthode de l'action qui correspond aux choses à faire

La méthode retourne une String, elle forwarde la requete vers la jsp qui correspond à l'url de suite

13) Quels sont les 2 design patterns utilisés dans un framework MVC2

1 - Factory
2 - Singleton (paterne qui permet d'instancier une casse qu'une seule fois)

## Histoires pour tester la compréhension :

### Les élèves mangent des repas.

On a un modèle : qui a la classe élève, repas (Un nom = une classe)
Dans service : service gestion de repas : mange (un verbe = une méthode)

PK y'a pas de DAO ? ==> car on sauvegarde pas dans la BD

Si j'aurais rajouté "je veux que mes élèves soient sauvegardées dans une BD"
Dans repository ==> package repository avec une methode InsertEleve,deleteEleve..

### Le magasin vends des articles, les articles sont des ordinateurs, chaises, tables. Je veux que le tout soit organisés dans une BD

"les articles" ==> Interface article (quand on veut dire "les" on veut les regrouper, et donc c'est une interface)

(noms = Modèle) (Si je veux les regrouper : Interface)
Modèle : class Magasin, INTERFACE Article, class Ordinateur, class Chaise, class Table

(Quand je veux les enregistrer)
Repository : MagasinDAO, ArticleDAO, OrdinateurDAO, ChaiseDAO, TableDAO
==> Insert/Delete/FindByID

(Verbes = Service)
Service : vends(Magasin, Article)

## Qu'est-ce qu'un Design Pattern ?

Façon d'organiser des classes 
> Comment organiser les classes pour résoudre un problème récurrent

Une méthode pour résoudre un problème d'architecture récurrent

Exemple de pattern :
Amazon à un mode de livraison : il va surement en avoir d'autre dans le futur 
> - Drones
> - Camion (actuel)
> - ...

Il y en a un seul, il est obligatoire et il y en aura d'autre à l'avenir

Pattern de Stratégie : résout le problème de y'en a un il est obligatoire et y'en aura d'autres plus tard.

### Définition Servlet :
Une servlet est un composant Java côté serveur qui permet de traiter des requêtes HTTP et de générer des réponses dynamiques, généralement dans une application web.

Définition simple :
Une servlet est une classe Java qui s’exécute dans un serveur d’applications (comme Tomcat) et qui répond aux requêtes HTTP, souvent via une URL.



---
# Ce qui a été fait dans la séance du 20/05 

## Trouver package, classes, interfaces et méthodes
- Site de gestion d'université
- Une université à des étudiants 
- Chaque étudiant à un seul et un seul cursus. Il existe 3 cursus possible CursusSciences, CursusLettres, CursusDroit
- L'étudiant peut se loguer pour consulter son cursus, consulter ses informations personnelles 
- Le tout est sauvegardé dans une bdd

- > Modèle :
  > - classe Universite
  > - classe Etudiant
  > - classe CursusSciences
  > - classe CursusLettres
  > - classe CursusDroit
  > - interface Cursus
  > - classe Login (Pour des raisons de sécurité, login != etudiant)


- > - Repository :
  > - UniversiteRepository
  > - EtudiantRepository
  > - CursusDAO
  > - CursusSciencesRepository
  > - CursusLettresRepository
  > - CursusDroitRepository


- > - Service :
  > - GestionEtudiant
  > - GestionCursus
  > - GestionLogin

- > - Controlleur :
  > Une interface par action
  > - ConsultCursus
  > - ConsulterInfoPerso
  > - Login

Peut-être chopper une meilleure correction.

## Coding : 
1 - Quand on appuie sur le bouton OK et que les champs sont vides : redirige sur une page "ils sont vides, veuillez ressaisir les champs"
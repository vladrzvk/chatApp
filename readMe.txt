Mon application avec pleins de service :
techno SPRING & ANGULAR & POSTGRES

Chapitre 1) chat en ligne :
O) Plan :

fonctionnalitées :

- chat en ligne (avec des lignes de commandes en option + UI pour interagir dans le chat + envoie d'image / gif )

- une base de donnée POSTGRESQL pour stocker des informations relatives à l'utilisateurs, le compte de l'utilisateur, les actions effectuer

- compte utilisateur possible de créer sur le site + un service OAUTH => (google / github / facebook)

- API => regarder du contenu (youtube / twitch / wikipedia )

- un aspect securité avec spring


-------------------------------------------------------------------
Partie 1: Diagramme relationnel
 créer les classes utilisateurs, messages, client( regroupant les informations collectés sur l'utilisateurs s'il utiliser un OAUTH)
 créer les interfaces relatives aux classes crées : DAO, REST (verifier si un utilisateur existe, ajouter un utilisateur, supprimer un utilisateur, update un utilisateur,  envoyer un message (savegarde bdd),
 créer une route pour l'index ( page initial)

Partie 2:
connecter la base de donnée :
creer un groupe d'utilisateur sur la bd
ajouter la base de donnée via l'IDE avec la JDA Structure

modele de la base de donnée :
table utilisateur:

id (autoincremented) username

1. Add dependency for PostgreSQL JDBC Driver
2. Configure Data Source Properties
3. Connect to PostgreSQL Database with Spring JDBC
4. Connect to PostgreSQL Database with Spring Data JPA

(https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples)



Partie 3:
ajouter un front en angular

Partie 4:
Creer le chat

Partie 5:
ajouter les Oauth

Partie 6:
ajouter une API

Partie 7:
gérer la securité de l'application

Partie 8 : evolutions
-confirmation de compte via envoie de mail


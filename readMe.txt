Mon application avec pleins de service :
techno SPRING & ANGULAR & POSTGRES

Chapitre 1) chat en ligne :
O) Plan :

fonctionnalitées :

- chat en ligne (avec des lignes de commandes en option + UI pour interagir dans le chat + envoie d'image / gif )

- compte utilisateur possible de créer sur le site + un service OAUTH => (google / github / facebook)

- une base de donnée POSTGRESQL pour stocker des informations relatives à l'utilisateurs, les messages envoyés etc

- API d'un service à implémenter => regarder du contenu (youtube / twitch / wikipedia )

- (un aspect securité avec spring ?)


-------------------------------------------------------------------

Partie 1: Diagramme relationnel

 créer un modele pour message et utilisateur
utilisateur - ONE-TO-MANY - MESSAGE (inc)
 un utlisateur peut être associé a plusieurs messages mais un message est associé a un utilisateur

 (evolution : un salon est associé à plusieurs messages, plusieurs utilisateurs)

PARTIE 2 : Repository & Controller

 créer les interfaces pour les utilisateurs & les messages dans repository et l'extends JpaRepository
creer la classe controller { @{crossorigin, RestController, Request mapping} ,
 DAO


Partie 3:

connecter la base de donnée au projet
creer un groupe d'utilisateur sur la bd
ajouter la base de donnée via l'IDE avec la JDA Structure
Ajouter JPA/Hibernate préconfig pour postgres



1. Add dependency for PostgreSQL JDBC Driver
2. Configure Data Source Properties
3. Connect to PostgreSQL Database with Spring JDBC
4. Connect to PostgreSQL Database with Spring Data JPA

(https://www.codejava.net/frameworks/spring-boot/connect-to-postgresql-database-examples)



Partie 4:
ajouter un front en angular

Partie 5:
Creer le chat

Partie 6 : evolutions
- message privé
- compte de moderation
-confirmation de compte via envoie de mail
- gerer les recherches par date

Partie 7:
ajouter une API pour un service

Partie 8:
gérer la securité de l'application



Partie 9:
ajouter les Oauth



# Akdemia GP4E - Business & Web Service

Ce projet consiste en la réalisation d'une solution backend robuste et évolutive pour la gestion académique, comprenant deux modules principaux : le module `Business` et le module `Web Service`. Les deux modules ont été développés en Java, en utilisant le framework Spring, et se concentrent sur la gestion efficace des données académiques.

## Table des matières

1. [Description du projet](#description-du-projet)
2. [Technologies utilisées](#technologies-utilisées)
3. [Installation](#installation)
4. [Utilisation](#utilisation)
5. [Architecture](#architecture)
6. [Cahier des charges](#cahier-des-charges)
7. [Contribuer](#contribuer)
8. [Licence](#licence)

## Description du projet

`akdemia-gp4e-business` gère toute la logique métier et les règles d'affaires associées à la gestion des entités académiques telles que les étudiants, les enseignants, les cours et les résultats.

`akdemia-gp4e-ws` est un web service exposé pour permettre aux clients de l'application (front-end ou applications tierces) d'interagir avec la logique métier à travers une API RESTful.

## Technologies utilisées

Les deux modules ont été construits en utilisant les technologies suivantes :

- **Java 11**
- **Spring Boot** : pour la configuration et la gestion des composants d'application.
- **Spring Data JPA** : pour l'intégration avec la base de données.
- **Spring Security** : pour la gestion de l'authentification et de l'autorisation.
- **H2 Database** (pour les tests en mémoire) ou **PostgreSQL** (pour les environnements de production).
- **Maven** : pour la gestion des dépendances et la compilation.
- **Swagger** : pour la documentation de l'API REST.

## Installation

### Prérequis

- Java 11 ou plus récent
- Maven 3.x
- PostgreSQL (ou une autre base de données relationnelle)

### Étapes d'installation

1. Clonez les deux dépôts GitHub du projet :
   ```bash
   git clone https://github.com/alinfor/akdemia-gp4e-business.git
   git clone https://github.com/alinfor/akdemia-gp4e-ws.git

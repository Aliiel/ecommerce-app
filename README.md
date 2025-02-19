# ecommerce-app
# 🛒 Projet E-Commerce

## 📖 Description
Application E-Commerce permettant aux utilisateurs de consulter une liste de produits, d'afficher les détails d'un produit, de gérer un panier et de finaliser leur commande. Une gestion simplifiée du compte utilisateur est également prévue.

## 🏗️ Architecture du Projet
Le projet est divisé en deux parties :
- **BackEnd** : 
    - Java : Spring Boot
- **FrontEnd** : Développé en **React**, avec les librairies suivantes :
    - **Formik** (gestion des formulaires)
    - **Yup** (validation des données)
    - **Axios** (requêtes HTTP)
    - D'autres librairies pourront être ajoutées selon les besoins.

---

## 🎯 Fonctionnalités

### 🏠 Page d'accueil
- Affichage de la liste des produits
- (Optionnel) Filtrage des produits selon leur type

### 🔍 Page Détails d'un produit
- Affichage des informations détaillées d'un produit
- Ajout du produit au panier avec choix de la quantité

### 🛍️ Page Panier
- Modification du panier :
    - Modifier la quantité d'un produit
    - Supprimer un produit du panier
- Validation du panier
- (Optionnel) Simulation d'un paiement bancaire

### 👤 Gestion de Compte
- Connexion d'un utilisateur
- Création de compte
- (Optionnel) Modification du compte utilisateur

---

## 📌 Modèle de Produit
Chaque produit devra contenir au minimum les attributs suivants :
- **Nom** (`name`)
- **Prix** (`price`)
- **Type** (`type`)

---

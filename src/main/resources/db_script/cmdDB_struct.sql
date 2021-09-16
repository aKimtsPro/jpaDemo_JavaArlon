DROP DATABASE IF EXISTS cmdDB;
CREATE DATABASE cmdDB;

use cmdDB;

CREATE TABLE client (
    client_id INT PRIMARY KEY AUTO_INCREMENT,
    client_prenom VARCHAR(50) NOT NULL,
    client_nom VARCHAR(50) NOT NULL,
    client_adresse VARCHAR(255) NOT NULL,
    client_email VARCHAR(100) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE commande (
    commande_id CHAR(5) PRIMARY KEY,
    date_creation DATETIME NOT NULL,
    date_confirm DATETIME,
    client_id INT,
    CONSTRAINT fk_cmd_client FOREIGN KEY (client_id) REFERENCES client(client_id)
) ENGINE=InnoDB;

CREATE TABLE categorie (
    categorie_id CHAR(3) PRIMARY KEY,
    nom VARCHAR(20) NOT NULL,
    description VARCHAR(500)
) ENGINE=InnoDB;

CREATE TABLE produit (
    produit_id INT PRIMARY KEY AUTO_INCREMENT,
    marque VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prix DECIMAL(10,2) NOT NULL CHECK (prix > 0)
) ENGINE=InnoDB;

CREATE TABLE contenu_cmd (
    commande_id CHAR(5),
    produit_id INT,
    qtt INT NOT NULL DEFAULT 0,
    CONSTRAINT pk_contenu_cmd PRIMARY KEY (commande_id, produit_id),
    CONSTRAINT fk_contenu_cmd_commande FOREIGN KEY (commande_id) REFERENCES commande(commande_id),
    CONSTRAINT fk_contenu_cmd_produit FOREIGN KEY (produit_id) REFERENCES produit(produit_id)
) ENGINE=InnoDB;

CREATE TABLE produit_categorie (
    produit_id INT,
    categorie_id CHAR(3),
    CONSTRAINT pk_prod_cat PRIMARY KEY (produit_id, categorie_id),
    CONSTRAINT fk_prod_cat_categorie FOREIGN KEY (categorie_id) REFERENCES categorie(categorie_id),
    CONSTRAINT fk_prod_cat_produit FOREIGN KEY (produit_id) REFERENCES produit(produit_id)
) ENGINE=InnoDB;
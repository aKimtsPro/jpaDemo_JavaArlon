
use cmdDB;

INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Abbie','Kravits','Abbie.Kravits@email.com', '1 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Elmira','Lattie','Elmira.Lattie@email.com', '2 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Carilyn','Tristram','Carilyn.Tristram@email.com', '3 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Rhea','Jethro','Rhea.Jethro@email.com', '4 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Kore','Kylander','Kore.Kylander@email.com', '5 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Dede','Cecile','Dede.Cecile@email.com', '6 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Dione','Malvino','Dione.Malvino@email.com', '7 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Amalie','Anton','Amalie.Anton@email.com', '8 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Dorice','Stephie','Dorice.Stephie@email.com', '9 rue ok, 1111 ville');
INSERT INTO client(client_prenom, client_nom, client_email, client_adresse) VALUES ('Sara-Ann','Karl','Sara-Ann.Karl@email.com', '10 rue ok, 1111 ville');

INSERT INTO produit(marque, nom, prix) VALUES ('Alva','pasteque',7.79);
INSERT INTO produit(marque, nom, prix) VALUES ('Proust','madelene',2.41);
INSERT INTO produit(marque, nom, prix) VALUES ('McClimans','shampooing',3.65);
INSERT INTO produit(marque, nom, prix) VALUES ('Ventre','livre de cuisine',8.92);
INSERT INTO produit(marque, nom, prix) VALUES ('Graig','lame de rasoir',4.19);
INSERT INTO produit(marque, nom, prix) VALUES ('Gaynor','pack soda',3.31);
INSERT INTO produit(marque, nom, prix) VALUES ('Kiyoshi','seitan',2.55);
INSERT INTO produit(marque, nom, prix) VALUES ('Connelly','pate',3.53);
INSERT INTO produit(marque, nom, prix) VALUES ('Chapland','lame de rasoir',4.68);
INSERT INTO produit(marque, nom, prix) VALUES ('Auberbach','biscuit',2.91);

INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('R34D5', '2015-01-05',  '2015-01-08', 1 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('89OB1', '2021-09-15',  '2021-10-01', 1 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('AA8TY', '2017-11-07',  NULL, 3 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('R870I', '2018-10-22',  '2018-10-25', 3 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('5TP9X', '2019-06-19',  '2019-07-18', 3 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('W87PP', '2020-09-25',  NULL, 4 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('75MNZ', '2021-08-04',  NULL, 5 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('1197M', '2020-02-08',  '2020-04-08', 6 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('91OR0', '2021-03-22',  '2021-04-01', 7 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('T4CVB', '2021-09-19',  NULL, 8 );
INSERT INTO commande(commande_id, date_creation, date_confirm, client_id) VALUES ('7E7L3', '2016-10-12',  '2016-10-18', 8 );

INSERT INTO categorie (categorie_id, nom, description) VALUES ('div','divertissement','livre, musique, bd, ...');
INSERT INTO categorie (categorie_id, nom, description) VALUES  ('hgn','higiene', null);
INSERT INTO categorie (categorie_id, nom, description) VALUES  ('snk','snack', 'les trucs bons mais pas bon');
INSERT INTO categorie (categorie_id, nom, description) VALUES  ('fel','fruit et legume', NULL);
INSERT INTO categorie (categorie_id, nom, description) VALUES  ('fcl','feculent', 'pates, riz, semoules, ...');
INSERT INTO categorie (categorie_id, nom, description) VALUES  ('prt','proteine', 'viande, poisson, ...');

INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('R34D5', 5, 2 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('89OB1', 1, 5 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('89OB1', 9, 9 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('R870I', 10, 1 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('R870I', 2, 1 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('R870I', 5, 2 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('5TP9X', 7, 3 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('W87PP', 2, 1 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('1197M', 8, 1 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('91OR0', 6, 2 );
INSERT INTO contenu_cmd (commande_id, produit_id, qtt) VALUES ('7E7L3', 6, 3 );

INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (1,'fel');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (2,'snk');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (3,'hgn');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (4,'div');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (5,'hgn');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (6,'snk');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (7,'prt');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (8,'fcl');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (9,'hgn');
INSERT INTO produit_categorie(produit_id, categorie_id) VALUES (10,'snk');
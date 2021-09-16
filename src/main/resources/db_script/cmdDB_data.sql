
use cmdDB;

INSERT INTO client(client_prenom, client_nom, client_adresse, client_email) VALUES
    ("Abbie","Kravits","Abbie.Kravits@email.com", "1 rue ok, 1111 ville"),
    ("Elmira","Lattie","Elmira.Lattie@email.com", "2 rue ok, 1111 ville"),
    ("Carilyn","Tristram","Carilyn.Tristram@email.com", "3 rue ok, 1111 ville"),
    ("Rhea","Jethro","Rhea.Jethro@email.com", "4 rue ok, 1111 ville"),
    ("Kore","Kylander","Kore.Kylander@email.com", "5 rue ok, 1111 ville"),
    ("Dede","Cecile","Dede.Cecile@email.com", "6 rue ok, 1111 ville"),
    ("Dione","Malvino","Dione.Malvino@email.com", "7 rue ok, 1111 ville"),
    ("Amalie","Anton","Amalie.Anton@email.com", "8 rue ok, 1111 ville"),
    ("Dorice","Stephie","Dorice.Stephie@email.com", "9 rue ok, 1111 ville"),
    ("Sara-Ann","Karl","Sara-Ann.Karl@email.com", "10 rue ok, 1111 ville");


INSERT INTO produit(marque, nom, prix)
VALUES
    ("Alva","pasteque",7.79),
    ("Proust","madelene",2.41),
    ("McClimans","shampooing",3.65),
    ("Ventre","livre de cuisine",8.92),
    ("Graig","lame de rasoir",4.19),
    ("Gaynor","pack soda",3.31),
    ("Kiyoshi","seitan",2.55),
    ("Connelly","pate",3.53),
    ("Chapland","lame de rasoir",4.68),
    ("Auberbach","biscuit",2.91);

INSERT INTO commande(commande_id, date_creation, date_confirm, client_id)
VALUES
    ("R34D5", "2015-01-05",  "2015-01-08", 1 ),
    ("89OB1", "2021-09-15",  "2021-10-01", 1 ),
    ("AA8TY", "2017-11-07",  NULL, 3 ),
    ("R870I", "2018-10-22",  "2018-10-25", 3 ),
    ("5TP9X", "2019-06-19",  "2019-07-18", 3 ),
    ("W87PP", "2020-09-25",  NULL, 4 ),
    ("75MNZ", "2021-08-04",  NULL, 5 ),
    ("1197M", "2020-02-08",  "2020-04-08", 6 ),
    ("91OR0", "2021-03-22",  "2021-04-01", 7 ),
    ("T4CVB", "2021-09-19",  NULL, 8 ),
    ("7E7L3", "2016-10-12",  "2016-10-18", 8 );

INSERT INTO categorie (categorie_id, nom, description)
VALUES
    ("div","divertissement","livre, musique, bd, ..."),
    ("hgn","higiene", null),
    ("snk","snack", "les trucs bons mais pas bon"),
    ("fel","fruit et legume", NULL),
    ("fcl","feculent", "pates, riz, semoules, ..."),
    ("prt","proteine", "viande, poisson, ...");

INSERT INTO contenu_cmd (commande_id, produit_id, qtt)
VALUES
    ("R34D5", 5, 2 ),
    ("89OB1", 1, 5 ),
    ("89OB1", 9, 9 ),
    ("R870I", 10, 1 ),
    ("R870I", 2, 1 ),
    ("R870I", 5, 2 ),
    ("5TP9X", 7, 3 ),
    ("W87PP", 2, 1 ),
    ("1197M", 8, 1 ),
    ("91OR0", 6, 2 ),
    ("7E7L3", 6, 3 );

INSERT INTO produit_categorie(produit_id, categorie_id)
VALUES
    (1,"fel"),
    (2,"snk"),
    (3,"hgn"),
    (4,"div"),
    (5,"hgn"),
    (6,"snk"),
    (7,"prt"),
    (8,"fcl"),
    (9,"hgn"),
    (10,"snk");
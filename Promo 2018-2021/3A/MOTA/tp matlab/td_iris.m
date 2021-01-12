%% Q1. Chargement du document source
Iris = load('iris.txt');

%% TODO: doc ?
Y = Iris(:, 1) + 1;
%%

% On extrait la 4eme et 5eme colonne (pétales, sépales)
X = Iris(:, 4:5);

figure; subplot(1, 2, 1);
plot(X(Y==1, 1), X(Y==1, 2), 'r.', 'MarkerSize', 12)
hold on
plot(X(Y==2, 1), X(Y==2, 2), 'b.', 'MarkerSize', 12)
plot(X(Y==3, 1), X(Y==3, 2), 'g.', 'MarkerSize', 12)
 

%% Q2. Création de 3 clusters en utilisant l'algorithme K-means
Yp = kmeans(X, 3);

subplot(1,2,2);
 plot(X(Y==1, 1), X(Y==1, 2), 'r.', 'MarkerSize', 12)
hold on
plot(X(Y==2, 1), X(Y==2, 2), 'b.', 'MarkerSize', 12)


%% Q3. Création de la matrice de confusion
CF = confusionmat(Y, Yp)

% Résultat possible
% CF =
% 
%      0     0    50
%      2    48     0
%     46     4     0
% 
% Signifie qu'il a reconnu:
% - 50 échantillon de la classe 1 dans la classe 3
% - 2 échantillons de la classe 2 comme classe 1 et 48 de la classe 2 comme la classe 2
% - 46 échantillons de la classe 3 comme la classe 1 et 4 échantillons de la classe 3 comme la classe 2
% Cela s'explique par le fait que K-means ne sait pas dans quelle catégorie
% classer les échantillons reçus et donc les répartis "aléatoirement", il
% faut initialiser les centres des groupes pour spécifier les clusters

%% Q4. modification des conditions initiales
C1 = [0 0; 0 0; 0 0] ;
C2 = [0 0; 2.5 5; 5 10] ;
C3 = [0 0; 2.5 1.5; 5 2.5] ;

Yp1 = kmeans(X,3, 'Start', C1, 'EmptyAction', 'drop');
CF1 = confusionmat(Y, Yp1)
% K-means affectera tous les échantillons à la classe 1, et rien aux autres
% On a donc les 50 de la bonne classe, et 100 de la mauvaises. On a la
% classe 1 qui contient toutes les donénes et les deux autres classes qui
% sont vide.
% Accuracy = 50 + 0 + 0 / 150 = 33% d'accuracy
% (on calcule la somme des diagonales / nombre d'échantillons)

Yp2 = kmeans(X,3, 'Start', C2, 'EmptyAction', 'drop');
CF2 = confusionmat(Y, Yp2)

Yp3 = kmeans(X,3, 'Start', C3, 'EmptyAction', 'drop');
CF3 = confusionmat(Y, Yp3)

% Affichage
figure; subplot(3, 1, 1);

plot(X(Yp1 == 1, 1), X(Yp1 == 1,2), 'r.', 'MarkerSize', 12)
hold on
plot(X(Yp1 == 2, 1), X(Yp1 == 2,2), 'b.', 'Markersize', 12)
plot(X(Yp1 == 3, 1), X(Yp1 == 3,2), 'g.', 'Markersize', 12)

subplot(3, 1, 2);
plot(X(Yp2 == 1,1), X(Yp2 == 1, 2), 'r.', 'MarkerSize', 12)
hold on
plot(X(Yp2 == 2, 1), X(Yp2 == 2, 2), 'b.', 'Markersize', 12)
plot(X(Yp2 == 3, 1), X(Yp2 == 3, 2), 'g.', 'Markersize', 12)

subplot(3, 1, 3);
plot(X(Yp3 == 1, 1), X(Yp3 == 1, 2), 'r.', 'MarkerSize', 12)
hold on
plot(X(Yp3 == 2, 1), X(Yp3 == 2, 2), 'b.', 'Markersize', 12)
plot(X(Yp3 == 3, 1), X(Yp3 == 3, 2), 'g.', 'Markersize', 12)

%% Procédure

% En haut de la fenetre:
%   APPS > Classification Learner

% Ensuite dans la nouvelle fenêtre:
%   New Session > From File

% Dans la fenetre d'import: "Import Selection"

% Sélectionner ensuite les données à catégoriser / prédire et dans "Response" la vérité (le vrai référentiel)
% Faire "Start Session"

% En haut, séléctionner le type d'arbre souhaité (Fine = précis; coarse = grossier)
% Une fois choisi, cliquer sur "Train"
%   Fine: permet jusque 100 niveaux
%   Coarse: permet seulement 4 niveaux
%     => Fine augmente la précision

% En haut de la fenetre: "Confusion Matrix" pour afficher la matrice de confusion
% En cochant à droite on peut afficher la réponse ou la précision en plus
% (sur les colonnes => précision; sur les lignes => réponse)

% En haut à droite: "Export Model"
% Exportera le model souhaité dans le workspace

%% Affichage des arbres
view(t_fine.ClassificationTree, 'Mode', 'graph')
view(t_coarse.ClassificationTree, 'Mode', 'graph')

% Validation croisée sur "3 folds" == Validation 2/3 1/3
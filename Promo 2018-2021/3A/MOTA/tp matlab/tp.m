%% Extraction des données

logo = imread('logoCHU-NB.jpg');
hote = dicomread('crane.dcm');

% Affichage image hote
% imshow(hote, []);

%% 1.1 Capacité d'insertion de l'image hôte

% LSB -> Least significant bit
[long, larg] = size(hote);
nb_pixels_hote = long * larg;

% 1 car noir et blanc, 3 si RGB
nb_canaux = 1;

% 1 seul car LSB, si on utilise les deux derniers, alors 2
nb_bits_utilises = 1;

% Calcul de la capacité
capacite_hote_octets = nb_pixels_hote * nb_canaux * nb_bits_utilises;
capacite_hote_octets = capacite_hote_octets / 8;  % Conversion de bits en octets

% Calcul de la taille du message à cacher
[long, larg] = size(logo);
nb_pixels_a_cacher = long * larg;

% Calcul de la place nécessaire pour ce message
nb_bits_necessaires_pour_cacher = nb_pixels_a_cacher * 8;

% Conclusion:
% Comme nb_bits_necessaires_pour_cacher >> nb_pixels_hote, on ne peut pas
% encoder chacun des pixels de notre secret dans notre hote
% -> Il y a plus de bits à cacher que de pixels disponibles

%% 1.2 Nombre de bits utiles dans l'image hote

% On applique LSB sans consigne particulière, on utilisera donc *le*
% dernier bit pour cacher des informations
% Chaque pixel étant codé sur 8 bits, on a donc 1 bit disponible par pixel
% Ainsi le nombre de bits utiles est:
nb_bits_utiles = nb_pixels_hote;
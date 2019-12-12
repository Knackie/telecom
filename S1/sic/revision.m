% Génération d'un sinus et ajout d'un bruit blanc Gaussien

        fe = 8000;      % Fréquence d'échantillonnage
        N = 8192;       % Nombre de points de la séquence

        % Axe des temps
        t = (1:N)/fe;
        
        % Génération du sinus
        f0 = 1200;
        sinus = sin(2*pi*f0*t);
        
        % Génération du bruit
        sigma = 0.25;   % variance du bruit
        moy = 0;        % moyenne
        bruit = moy + sigma*randn(1,N);
        
        signal = sinus + bruit;         % les 2 vecteurs sont de même longueur
        
         % Génération d'un sinus de fréquence 50Hz modulé à 2000Hz

        fe = 8000;      % Fréquence d'échantillonnage
        N = 8192;       % Nombre de points de la séquence

        % Axe des temps
        t = (1:N)/fe;
        
        % Génération du sinus
        f0 = 50;
        sinus = sin(2*pi*f0*t);
        
        % Génération de la porteuse
        fp = 2000;
        % elle doit être de la même longueur que le signal
        % a priori, on ne connait pas N.
        t_porteuse = (1:length(sinus))/fe;
        porteuse = cos(2*pi*fp*t_porteuse);
        
% on multiplie terme à terme les 2 signaux      
        signal = sinus .* porteuse;     % les 2 vecteurs sont de même longueur
        
         % Visualisation du sinus et du bruit
% Allure temporelle des signaux
        figure(1);clf       % créé ou sélectionne la figure 1 et l'efface
        subplot(2,1,1)    % sépare la figure en 2 graphiques et place dans le premier cadre
        plot(axe_t,sinus,'b'); hold on; plot(axe_t,bruit,'r')
        title('Allure temporelle du sinus et du bruit');
        xlabel('temps (sec)'); legend('sinus','bruit')
        subplot(2,1,2)  % place le tracé dans le deuxième graphique
        plot(axe_t,signal)
        title('Allure temporelle du signal'); xlabel('temps (sec)')
% Allure fréquentielle du signal
        tfsinus = fft(sinus);
        tfsignal = fft(signal);
                % conversion en dB du module
        tfsinus_dB = 20 * log10(abs(tfsinus));
        tfsignal_dB = 20 * log10(abs(tfsignal));
        
        % Axe des fréquences
        axe_f = (0:N-1)*Fe/N;

        % On créé un 2ème fenêtre
        figure(2); clf
        plot(axe_f,tfsinus_dB,'b',axe_f,tfsignal_dB,'r')        
        title('Spectre des signaux')            % Donne un titre au graphique
        legend('sinus pur','sinus bruité')      % Annote les courbes
        xlabel('Fréquence (Hz)'); ylabel('dB')  % Annote les axes
        
        % On rassemble les graphiques dans la figure(3) avec une géométrie différente
        figure(3); clf
        subplot(2,2,1)
        plot(axe_t,sinus,'k',axe_t,bruit,'k--')
        title('Allure temporelle du sinus et du bruit');  
        xlabel('temps (sec)'); legend('sinus','bruit')
        
        subplot(2,2,2)
        plot(axe_t,signal,'k')
        title('Allure temporelle du signal'); xlabel('temps (sec)')

        subplot(2,1,2)
        plot(axe_f,tfsinus_dB,'k',axe_f,tfsignal_dB,'k--')
        title('Spectre des signaux'); legend('sinus pur','sinus bruité');
        xlabel('Fréquence (Hz)'); ylabel('dB')
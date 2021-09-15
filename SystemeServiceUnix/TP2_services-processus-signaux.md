# TP 02 : Services, processus signaux
 - PermitRootLogin :
Spécifie si root peut se connecter par ssh. L'argument est « yes », « without-password », « forced-commands-only » ou « no ». Par défaut « yes ».
Si cette option est réglée à « without-password », l'authentification par mot de passe est désactivée pour root.

Si cette option est réglée à « forced-commands-only », les connexions de root sont autorisées avec une authentification par clef publique, mais seulement si l'option command est spécifiée (ce qui peut être utile pour effectuer des sauvegardes à distance même si les connexions de root sont normalement interdites). Toutes les autres méthodes d'authentification sont désactivées pour root.

Si cette option est réglée à « no », root n'est pas autorisé à se connecter.

## 1.2  Exercice : Authentification par clef / Génération de clefs

C'est une mauvaise idée d'utiliser une passphrase car 

sur cmder non connecté au ssh
faire ssh-keygen pour récuperer clef ssh

donc ajout manuellement de la clef dans le fichier authorized.keys


## 1.3  Exercice : Authentification par clef / Connection serveur

cd /root
mkdir .ssh
nano authorized_keys
copie de la clef

 mv .ssh/Authorized_keys .ssh/authorized_keys
  cat toto > .ssh/authorized_keys
   cat .ssh/authorized_keys

changement dans le fichier pour without-password
reboot
restart













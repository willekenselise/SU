# TP 02 : Services, processus signaux
 - PermitRootLogin :
Spécifie si root peut se connecter par ssh. L'argument est « yes », « without-password », « forced-commands-only » ou « no ». Par défaut « yes ».
Si cette option est réglée à « without-password », l'authentification par mot de passe est désactivée pour root.

Si cette option est réglée à « forced-commands-only », les connexions de root sont autorisées avec une authentification par clef publique, mais seulement si l'option command est spécifiée (ce qui peut être utile pour effectuer des sauvegardes à distance même si les connexions de root sont normalement interdites). Toutes les autres méthodes d'authentification sont désactivées pour root.

Si cette option est réglée à « no », root n'est pas autorisé à se connecter.
## SEcure Shell : SSH
### 1.2  Exercice : Authentification par clef / Génération de clefs

C'est une mauvaise idée d'utiliser une passphrase car ce n'est pas assez sécurisé les personnes se connectant peuvent voir le mot de passe écrit. Il faut mieux utiliser une clef car même si les personnes peuvent la voir ils ne pourront pas l'utiliser.

sur cmder non connecté au ssh
faire ssh-keygen pour récuperer clef ssh

donc ajout manuellement de la clef dans le fichier authorized.keys

![image](https://user-images.githubusercontent.com/37480026/133572313-154fd68a-b432-4ad5-882f-1cecfb2fe7aa.png)


### 1.3  Exercice : Authentification par clef / Connection serveur

cd /root
mkdir .ssh
nano authorized_keys
copie de la clef

 mv .ssh/Authorized_keys .ssh/authorized_keys
  cat toto > .ssh/authorized_keys
   cat .ssh/authorized_keys

changement dans le fichier sshd_config pour without-password
![image](https://user-images.githubusercontent.com/37480026/133575695-114fb261-9971-4d27-ac4d-e50462294ec6.png)

Changement des autorisations pour le fichier
avec chmod 700 ~/.ssh -Rf
![image](https://user-images.githubusercontent.com/37480026/133575357-80f4a7b6-900f-4dcc-93d3-da5e0d99b061.png)

### 1.4 Authentification par clef

reboot
restart

![image](https://user-images.githubusercontent.com/37480026/133575196-7c70ae85-3ddd-49bd-9e9b-bd11c2be2d80.png)

### 1.5 Sécuriser

Les attaques ssh sont : "Les attaques dites « bruteforce SSH » sont des tentatives de connexions SSH effectuant une succession d'essais pour découvrir un couple utilisateur/mot de passe valide afin de prendre le contrôle de la machine. Il s'agit d'une attaque très répandue et toute machine exposée sur Internet se verra attaquer plusieurs fois par jour"

Des solutions possibles :
- Limiter la fréquence des nouvelles connexions, au moyen du module xt_recent de netfilter.
- Limiter le nombre d'authentifications par connexion, dans la configuration du service SSH.
- Changer le port
- Authentification par clef ssh (ne permet pas le connnexion sur d'autres machines et les robots continueront de tenter la connexion)

## Processus

### Etude des processis UNIX
- man ps

root@serveur1:~# ps aux
USER         PID %CPU %MEM    VSZ   RSS TTY      STAT START   TIME COMMAND
root           1  0.0  1.0  98200 10112 ?        Ss   16:49   0:02 /sbin/init
root           2  0.0  0.0      0     0 ?        S    16:49   0:00 [kthreadd]
root           3  0.0  0.0      0     0 ?        I<   16:49   0:00 [rcu_gp]
root           4  0.0  0.0      0     0 ?        I<   16:49   0:00 [rcu_par_gp
...

- TIME correspond à la durée de traitement du processus
- Le premier processus lancé est /sbin/init
- La machine a été démarré à  16:49
- le nombre approximatif de processus 1003 avec la commande ps -e

- PPID 
root@serveur1:~# ps -ef
UID          PID    PPID  C STIME TTY          TIME CMD
root           1       0  0 16:49 ?        00:00:02 /sbin/init
root           2       0  0 16:49 ?        00:00:00 [kthreadd]
root           3       2  0 16:49 ?        00:00:00 [rcu_gp]
root           4       2  0 16:49 ?        00:00:00 [rcu_par_gp]
root           6       2  0 16:49 ?        00:00:00 [kworker/0:0H-events_highpri]
root           9       2  0 16:49 ?        00:00:00 [mm_percpu_wq]


- installation apt install psmisc
- pstree

systemd─┬─cron
        ├─dbus-daemon
        ├─login───bash───man───pager
        ├─rsyslogd───3*[{rsyslogd}]
        ├─sshd───sshd───bash───pstree
        ├─systemd───(sd-pam)
        ├─systemd-journal
        ├─systemd-logind
        ├─systemd-timesyn───{systemd-timesyn}
        └─systemd-udevd
 
 top puis ?
 
 - le plus gros est  systemd 
 
UTIL.     PR  NI    VIRT    RES    SHR S  %CPU  %MEM    TEMPS+ COM.
root      20   0   98200  10112   7768 S   0,0   1,0   0:02.60 systemd

avec la touche < et > et x pour selectionner

La commande pour :
- changer la couleur est z et Z pour personnaliser la couleur
- mettre en avant la colonne de tri : x
- changer la colonne de tri > et <


installation de htop avec apt-get install htop

![image](https://user-images.githubusercontent.com/37480026/133588583-02f403cc-1de9-45f3-9fbc-e7419bbea5db.png)

Les avantages / Les inconvénients

nano date.sh
#!/bin/sh
while true; do sleep 1; echo -n ’date ’; date +%T; done

- pour executer bash -x name.sh

root@serveur1:~# bash -x date.sh
+ true
+ sleep 1
+ echo -n ’date ’
’date ’+ date +%T
18:50:39
+ true
+ sleep 1
+ echo -n ’date ’
’date ’+ date +%T
18:50:40
+ true
+ sleep 1
^C

root@serveur1:~# bash -x date-toto.sh
+ true
+ sleep 1
+ echo -n ’toto ’
’toto ’+ date --date ’5 hour ago’ +%T
date: opérande supplémentaire « ago’ »
Saisissez « date --help » pour plus d'informations.
+ true
+ sleep 1
+ echo -n ’toto ’
’toto ’+ date --date ’5 hour ago’ +%T
date: opérande supplémentaire « ago’ »
Saisissez « date --help » pour plus d'informations.
+ true
+ sleep 1
^C


-  ls | cat
affiche les fichiers de type cat 
- ls -l | cat > liste
liste les fichiers du nom liste

-ls -l | tee liste
liste les fichiers contenu avec des informations tel que la date, l'heure de création, et les accès
root@serveur1:~# ls -l | tee liste
total 16
-rwxr-xr-x 1 root root  71 13 sept. 18:46 date.sh
-rw-r--r-- 1 root root  94 13 sept. 18:47 date-toto.sh
-rw-r--r-- 1 root root 209 13 sept. 19:06 liste
-rw-r--r-- 1 root root 567 13 sept. 16:50 toto




-  ls -l | tee liste | wc -l
affiche 5


###  Journal système rsyslog

installation de rsyslog avec apt install rsyslog

PID est le 395




 
 

      
        




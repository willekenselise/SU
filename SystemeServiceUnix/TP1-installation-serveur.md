# TP 01 : Installation Serveurs


## 1) Installation Machine virtuelle

Avec VirtualBox création d'une machine Linus Debian stable 
(version figée où seules les mises à jour sont des correctifs de sécurité)

- configuration du réseaux (ip: 134.157.46.205)
                       (masque: 255.255.255.128) 
              adresse du proxy: http://proxy.ufr-info-p6.jussieu.fr:3128
- pour les partitions du disque : 5G /
                                  2G /tmp
                                  500M /var/log
                                  200M swap
 - installation 
 
 - (ne pas oublier d'enlever le mini.iso)

## 2) Configuration SSH

- pour la configuration

- connexion au compte administrateur (root)
- faire apt update pour mettre à jour 
- et d'installer le serveur ssh avec apt install openssh-server

Pour autoriser la connexion root SSH sur Debian :
cd /etc/ssh
-> pour se placer dans le repertoire

nano sshd_config 
// SSHD est le serveur, SSH est le client
-> pour ouvrir le fichier de configuration ssh

Le paramètre PermitRootLogin permet de contrôler l'autorisation racine ssh.
-> Modification de sa valeur en décommentant (supprimer #) et en passant sa valeur sur yes
-> enregistrer les changements

service sshd restart
-> redemmarage du serveur ssh p

cmder
-> installation d'un cmder (un emulateur de console) et changer le mode d'accès pour en pont (bridge)
-> connexion avec cmder+

-> pour se conneter au ssh :
- ssh root@ip134.157.46.205

- dpkg -l | wc -l
-> nombre de paquets sur la machine (326 paquets dans mon cas)

- df -h
-> permet de savoir ce que la racone représente en place utilisé ( 1.1Go dans mon cas)

pour reset IP pour en avoir une fixe :
-  ip  /etc/network/interfaces

source /etc/network/interfaces

allow-hotplug enp0s3
iface enp0s3 inet static
  aDDress 134.157.46.209/24
  gateway 134.157.46.252
  
 










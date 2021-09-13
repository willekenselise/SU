PermitRootLogin :

Spécifie si root peut se connecter par ssh(1). L'argument est « yes », « without-password », « forced-commands-only » ou « no ». Par défaut « yes ».
Si cette option est réglée à « without-password », l'authentification par mot de passe est désactivée pour root.

Si cette option est réglée à « forced-commands-only », les connexions de root sont autorisées avec une authentification par clef publique, mais seulement si l'option command est spécifiée (ce qui peut être utile pour effectuer des sauvegardes à distance même si les connexions de root sont normalement interdites). Toutes les autres méthodes d'authentification sont désactivées pour root.

Si cette option est réglée à « no », root n'est pas autorisé à se connecter.


C'est une mauvaise idée d'utiliser une passphrase car 





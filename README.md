# OptimisationEmballage

J'ai implémenté une solution avec une interface en jsf qui permet de saisir la suite des articles à emballer et renvoie le resultat de l'emballage.
Pour cette solution j'ai :
- impléménté 4 packages : - com.emballage.app : qui contient une classe main si on veut lancer l'appli comme une appli java
               - com.emballage.model : qui contient mes entités (carton et emballage) :
                      -carton : constitué d'une liste d'article , taille du carton (tailleCarton) et une tailleMax (taille maximale du carton)
                      - emballage : constitué d'une liste d'articles à emballer, liste de cartons, nb de carton, libelle de l'emballage (suite des articles séparé par '/')
               - com.emballage.exceptions : qui contient l'exception lancé si on saisie une liste de caractère ou si la liste est vide
               - com.emballage.services : qui contient l'interface de mon service 
               - com.emballage.services.impl : qui contient l'implémentation de mon service
- une classe de test qui teste le résultat de mon service
- la page xhtml qui illustre mon interface
- des fichiers properties pour afficher les libelles et message de l'exception
- des fichiers de configs : log4j.properties (pour configurer les logs), applicationContext.xml, faces-config.xml, pom.xml, web.xml


              
               

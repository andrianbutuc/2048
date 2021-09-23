# Projet Remise 1

## Divers

- Git : gitignore en ordre
- Readme : ajouter la commande maven pour exécuter le programme
- Javadoc : en ordre
- Couverture de test : couverture suffisante

## Analyse de code

Commence par jeter un œil aux remarques générées par Intelliji dans la page index.html

Reviens-vers moi si il y a des remarques que tu ne comprends pas ou que tu ne trouves pas appropriées

## Controller

Aucune remarque.

## View

- Lors des réécriture la javadoc n'est pas obligatoire, sauf si le comportement de la méthode est différent de celui décrit dans l'interface.

## Model

- Facade : en ordre
- Gestion du tableau de jeu : 
  - la classe `Case` a-t-elle une utilité ou un tableau d'entier est-il plus pertinent ?
- Gestion du jeu, la classe `Game` : 
  - les méthodes `isWon` ou `isLost` peuvent utiliser le board et pas une copie du board.
  - si aucune case ne bouge, aucune valeur aléatoire n’apparaît. par exemple si il n'y a qu'en ligne du bas les valeur 0 2 0 2, et que le joueur demande un déplacement vers le bas, il n'y aucun changement sur le board
  - 

## Méthodes et paramètres d'entrées

Attention les méthodes qui utilisent directement leurs paramètres d'entrées, doivent contrôler leurs validités, elles en sont responsables. 






# Raytracer

Projet universitaire : 

Ce projet a été réalisé dans le cadre de la SAE S3.A.01. Le but était de créer une librairie générant des images avec raytracing. D'abord, il y a lecture d'un fichier descriptif de la scène, ensuite, l'image est générée en utilisant différentes méthodes et classes. Enfin, l'image est créée et disponible au téléchargement. Le calcul des pixels se fait par calculs de vecteurs et de points, en prenant en compte la caméra, les lumières et les différentes formes. Le projet a été réalisé en Java. L'implémentation de patrons de conception était centrale : états, singletons, décorateurs, builders... Le fichier de description possède sa propre syntaxe, celui-ci est lu par un Scanner, puis les informations sont retranscrites pour créer l'image.

# Outil utilisés :
 - Java

# Rapport

## Diagramme de classes

![image.png](./image.png)
(Diagramme de classes)

---

## Patrons de conception

Pour ce projet, nous avons eu recours à plusieurs patrons de conception java.

Le premier utilisé était Le Builder (constructeur), il est un modèle permettant dans notre cas de créer une scène étape par étape.

<span dir="">![](https://lh7-us.googleusercontent.com/_MHRyYz5ez4Cgvq9R-oRvx1piA7V5y54N9Vw-hX7SnTVXgCdYCPyJnkClVjSK41o31kAaKeiAbC7k-bG22M9S7IQAB3z1D4Dv7xL5gpT2LUMqVbjj8l9At7OIfQ7Tdiu0z72yZKHtgQ1Z_wq-48YHKc){width="602" height="165"}</span>

(Schéma du builder)

---

Pour le deuxième nous avons utilisé la stratégie, un patron de conception qui permet entre autres de rendre interchangeables des algorithmes ayant des rôles similaires. Nous l'avons utilisé pour la classe Lambert, Normal et l'interface ICalcul

![](https://lh7-us.googleusercontent.com/6EYT3vctZNiFjTbgPjKhL-02BXLHq-7VONZHKfUiREJKDsqn_YQn7tGok945ZQFa0yllVB2lRJioC5lwKkdyMMmgEMKEbUQnc2KC4Ab2P_xCTn7hhH18Ftgpkxmp9JlcvV8gfybO-0KDAsWpNSX7s90){width="602" height="308"}

(Schéma de la stratégie)

---

Par la suite nous avons opté pour l'état (state) qui modifie le comportement d'un objet lorsque son état interne change, comme si l'objet changeait de classe, dans notre cas nous l'avons utilisé pour les ombres

![](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/r3-04/cours/-/raw/main/figures/patrons/state.png)

(Schéma de l'état)

---

### Travail réalisé :

* Développement de la classe Parser
  * Ouvrir un fichier et lire son contenu
  * Stocker les infos du fichier
  * Fermer le fichier
  * Utiliser/Traiter le contenu du fichier
* Compléter la classe principale pour générer l'image
* Corriger la classe Scene
* Corriger la classe Triangle pour implémenter IObjetScene
* Corriger la classe Sphere pour implémenter IObjetScene
* Corriger la classe Plan pour implémenter IObjetScene
* Correction de IObjetScene pour qu'elle soit utilisée dans RayThrower
* Faire la classe ColorUnie
* Faire l'interface IColorStrategy
* Faire la classe ColorDamier
* Corriger l'affichage des formes
* Corriger le problème de l'intersection des formes
* Implanter la formule de lambert
* Apparition des objets plan et triangles dans l'affichage
* Permettre le calcul de la couleur d'un point sur un objet qu'il soit uni ou en damier
* Réflexion formule d'intersection
* Affichage d'une sphère
* Affichage de deux sphères
* Affichage de trois sphères de différentes tailles
* Réglage du fond noir dérrière les formes
* Finalisation du Lanceur de rayon
* Debug de la classe Point (paramètre en int)
* Correction du parser pour prendre en compte les valeurs négatifs
* Réglage du bug des couleurs

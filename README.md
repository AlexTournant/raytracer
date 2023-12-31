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

## Répartition des tâches

### **BALLET Dylan :**

**Création des classes :**

* Triplet
* DirectionalLight
* PonctualLight
* Ajout d’une méthode multiplyVector dans Triplet
* Modification de la classe Triangle
* Traduction des classes en anglais
* Création du diagramme des classes
* Création des commentaires en anglais
* Création de la JavaDoc
* Création d’issues avec Maël
* Création du rapport

---

### **DEMORY Maël :**

**Création des classes :**

* Plan
* Triangle
* Sphere
* Scene
* SceneBuilder
* Shadow
* Implémentation du patron de construction
* Génération d’une image totalement noire
* Calcul du vecteur direction d pour un pixel (i, j)
* Calcul de l’intersection d’un rayon avec une sphère
* Base du lanceur de rayon
* Calcul de l’intersection avec un plan
* Développement de la méthode Raytracing
* Développement des méthodes permettant de gérer les intersections d'un rayon avec une sphère, un plan et un triangle
* Choix du patron de conception pour les ombres et implémentation
* Correction des alertes SonarLint
* Réalisation de la structure du projet (Issue board, jalons, labels).
* Réalisation des merge requests au sein du projet.

---

### FOURNIER Corentin :

**Création des classes :**

* Point
* Color
* Vector
* RayThrower (Début)
* Trouver le bon patron de conception pour le damier et l’anticrénelage.
* Rectification d'oublis dans Color
* Rectification problème dans Triplet
* Gestion des issues 
* Réflexion sur anticrénelage et implémentation du pseudo code

---

### TOURNANT Alex

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

# StudentFollower

## Contexte et problématique
Les étudiants de l’IUT ont obligation de présence aux cours, TD et TP. Afin de
contrôler les absences, les enseignants sont tenus de compléter à chaque séance
les feuilles de présence et de les remettre au secrétariat. L’enseignant doit
penser à récupérer au secrétariat les feuilles des groupes qu’il suit, à ne pas
oublier les feuilles dans son bureau lors des séances d’enseignement, à
compléter les feuilles en prenant garde de remplir les bonnes colonnes et enfin
ne pas oublier de les rapporter au secrétariat dans un délai raisonnable. La
secrétaire pédagogique saisit alors les absences dans Scodoc. C’est une
procédure qui prend du temps et qui peut entrainer des erreurs et des oublis.
La lourdeur de la procédure fait qu’il n’est pas envisageable par exemple de
noter des étudiants qui arrivent systématiquement en retard. En plus des
absences et retards, les enseignants ont également besoin de prendre des notes
sur des étudiants pour se souvenir d’une bonne participation ou d’un
comportement déplacé. Tous ces éléments sont importants pour prendre des
décisions avisées lors des jurys de fin de semestre.
Le département informatique dispose d’un système d’information qui regroupe les
noms, prénoms, groupes, emploi du temps de chaque groupe et enseignant. Chaque
enseignant dispose d’un emploi du temps qui lui est propre avec les intitulés,
groupes et numéros de salles des groupes qu’il suit. Vous pouvez supposer que
vous disposez de ces différentes informations pour votre application.

## Objectifs
L’objectif de ce projet est de réaliser une application pour smart phone qui
permette aux enseignants de saisir le plus rapidement possible les informations
ci-dessus, tout en minimisant les erreurs (le critère de rapidité est
essentiel). La saisie des retards doit être particulièrement rapide pour ne pas
perturber les séances de TD ou TP.
L’interface a pour principal objectif de saisir les informations ci-dessus et
dans une moindre mesure de les consulter. La consultation détaillée des
informations pourrait se faire en utilisant une autre application. Une
consultation sommaire d’informations doit cependant être possible (par exemple
voir les absences et retards lors des dernières séances de TD ou TP). 

## Utilisateurs
 Les utilisateurs de l’application sont les enseignants du département
 informatique. N’hésitez pas à les interroger sur leurs besoins, façon de gérer
 les absences etc... Mettez les au coeur de votre conception centrée
 utilisateurs.

## Résultats attendus
 L’application sera développée en utilisant Java Swing. L’utilisation de GUI
 builders tels que NetBeans n’est pas autorisée pour le rendu final (un des
 objectifs du projet est que maitrisiez les composants, gestionnaires de
 placement et la gestion des événements). Vous pourrez seulement utiliser des
 GUI builders pour réaliser le prototypage haute fidélité de votre interface.
 Pour vous rapprocher de la taille d’un écran de smart phone, vous pourrez
 utiliser une fenêtre de taille 320×480 pixels, en mode portrait ou paysage. On
 supposera que l’écran est mono-point (ne permet de détecter qu’un seul doigt
 en contact, représenté par le curseur de la souris).
 Les données de l’interface pourront être codées en dur: il n’est pas
 indispensable de gérer une base de données avec les étudiants, salles,
 enseignants etc... Vous pouvez supposer que vous avez obtenu des informations
 d’une base de données et que l’application est dans un certain état suite au
 traitement de ces informations (à préciser dans le compte rendu).
 L’application doit contenir suffisamment d’informations pour pouvoir réaliser
 des évaluations avec des utilisateurs.
 L’application devra contenir les noms des étudiants suivants (nécessaire pour
 les évaluations croisées): "Paul Durant", "Pierre Dupond", "Claire Martin",
 "Jacques Richard", "Jeanne Robin".

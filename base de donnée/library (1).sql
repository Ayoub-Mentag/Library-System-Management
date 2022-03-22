-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 11 jan. 2022 à 21:03
-- Version du serveur : 10.4.22-MariaDB
-- Version de PHP : 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `library`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `admin` varchar(5) NOT NULL,
  `password` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`admin`, `password`) VALUES
('admin', '1234');

-- --------------------------------------------------------

--
-- Structure de la table `book`
--

CREATE TABLE `book` (
  `code` int(5) NOT NULL,
  `titre` varchar(40) NOT NULL,
  `auteur` varchar(40) NOT NULL,
  `edition` varchar(10) NOT NULL,
  `nbExemplaire` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `book`
--

INSERT INTO `book` (`code`, `titre`, `auteur`, `edition`, `nbExemplaire`) VALUES
(5, 'titre2', 'Auteur1', 'premier', 20),
(8, 'titre5', 'Auteur', 'premier', 15),
(9, 'titre9', 'Auteur9', 'premier', 15),
(10, 'titre9', 'Auteur9', 'premier', 15);

-- --------------------------------------------------------

--
-- Structure de la table `emprunteur`
--

CREATE TABLE `emprunteur` (
  `id_etudiant` int(50) NOT NULL,
  `id_livre` int(50) NOT NULL,
  `date_retour` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `member`
--

CREATE TABLE `member` (
  `id_member` int(5) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `prenom` varchar(40) NOT NULL,
  `nom` varchar(40) NOT NULL,
  `nCart` varchar(10) NOT NULL,
  `adresse` varchar(40) NOT NULL,
  `ville` varchar(40) NOT NULL,
  `pays` varchar(40) NOT NULL,
  `email` varchar(30) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `profession` varchar(20) NOT NULL,
  `anne_etude` date NOT NULL,
  `specialite` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `member`
--

INSERT INTO `member` (`id_member`, `user_name`, `password`, `prenom`, `nom`, `nCart`, `adresse`, `ville`, `pays`, `email`, `telephone`, `profession`, `anne_etude`, `specialite`) VALUES
(4, 'ayoub2022', '123', 'ayoub', 'mentag', 'a123', 'sale', 'sale', 'maroc', 'ayoubmentag21@gmail.com', '0612341565', 'etudiant', '2022-01-05', 'developpement'),
(5, 'khelloufi', '123', 'mohammed', 'khelloufi', 'a12345', 'sale', 'sale', 'maroc', 'kheelloufi@gmail.com', '0612345678', 'etudiant', '2022-01-05', 'developpement'),
(6, 'Ayoub2030', '123', 'ayoub', 'mentag', 'A123a', 'sale', 'sale', 'maroc', 'ayoubmentag21@gmail.com', '061234565', 'Etudiant', '2022-01-09', 'developpement'),
(7, 'Adil', '123', 'Adil', 'Ghazi', 'A456', 'Sale', 'Sale', 'Maroc', 'adil@gmail.com', '06456878', 'Etudiant', '2022-01-09', 'Ingénierie');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `emprunteur`
--
ALTER TABLE `emprunteur`
  ADD PRIMARY KEY (`id_etudiant`,`id_livre`),
  ADD KEY `fk_livre` (`id_livre`);

--
-- Index pour la table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`id_member`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `book`
--
ALTER TABLE `book`
  MODIFY `code` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT pour la table `member`
--
ALTER TABLE `member`
  MODIFY `id_member` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emprunteur`
--
ALTER TABLE `emprunteur`
  ADD CONSTRAINT `emprunteur_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `member` (`id_member`),
  ADD CONSTRAINT `emprunteur_ibfk_2` FOREIGN KEY (`id_livre`) REFERENCES `book` (`code`),
  ADD CONSTRAINT `fk_etudiant` FOREIGN KEY (`id_etudiant`) REFERENCES `member` (`id_member`) ON DELETE CASCADE,
  ADD CONSTRAINT `fk_livre` FOREIGN KEY (`id_livre`) REFERENCES `book` (`code`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

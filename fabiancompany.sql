-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 16. Feb 2021 um 10:09
-- Server-Version: 10.4.13-MariaDB
-- PHP-Version: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `fabiancompany`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `employees`
--

CREATE TABLE `employees` (
  `id` int(10) UNSIGNED NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `department` varchar(50) NOT NULL,
  `salary` decimal(10,2) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `employees`
--

INSERT INTO `employees` (`id`, `firstname`, `lastname`, `department`, `salary`) VALUES
(1, 'Max', 'Mustermann', 'IT', '2300.30'),
(2, 'Maxine', 'Musterfrau', 'IT', '2300.80'),
(3, 'Roland', 'Dueringer', 'IT', '2300.20'),
(4, 'Markus', 'Ranz', 'IT', '1732.40'),
(5, 'Ross', 'Jones', 'MARKETING', '4923.90'),
(6, 'Fabian', 'Andiel', 'IT', '1800.30'),
(7, 'Josef', 'Ranz', 'DESIGN', '1400.23'),
(8, 'Sarah', 'Ross', 'DESIGN', '1600.43'),
(9, 'Lorenz', 'Maier', 'DESIGN', '1000.12'),
(10, 'Roland', 'Dueringer', 'IT', '2300.20'),
(11, 'Tom', 'Marketer', 'MARKETING', '8000.21'),
(12, 'Lorenz', 'Maier', 'DESIGN', '1000.12');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

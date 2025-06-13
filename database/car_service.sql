-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 13. Jun 2025 um 10:05
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `car_service`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `cars`
--

CREATE TABLE `cars` (
  `id` int(11) NOT NULL,
  `model` varchar(255) NOT NULL,
  `manufacturer` varchar(255) NOT NULL,
  `year_of_construction` varchar(4) NOT NULL,
  `chassis_number` varchar(17) NOT NULL,
  `fuel_type` varchar(50) NOT NULL,
  `kilometers` int(11) NOT NULL,
  `car_condition` varchar(50) NOT NULL,
  `wheel_type` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `cars`
--

INSERT INTO `cars` (`id`, `model`, `manufacturer`, `year_of_construction`, `chassis_number`, `fuel_type`, `kilometers`, `car_condition`, `wheel_type`) VALUES
(1, 'Model S', 'Tesla', '2020', '5YJSA1E26MF123456', 'Elektrisch', 15000, 'Neu', 'Aluminium'),
(2, 'Model 3', 'Tesla', '2021', '5YJ3E1EA7MF123457', 'Elektrisch', 10000, 'Neu', 'Aluminium'),
(3, 'Mustang', 'Ford', '2019', '1FA6P8TH7K5151234', 'Benzin', 30000, 'Gebraucht', 'Stahl'),
(4, 'Civic', 'Honda', '2018', '2HGFC2F59JH123456', 'Benzin', 25000, 'Gebraucht', 'Aluminium'),
(5, 'A4', 'Audi', '2022', 'WAUENAF48MN123456', 'Diesel', 5000, 'Neu', 'Aluminium'),
(6, 'Corolla', 'Toyota', '2020', 'JTDEPRAE3LJ123456', 'Hybrid', 15000, 'Gebraucht', 'Aluminium'),
(7, 'X5', 'BMW', '2023', '5UXCR6C59P1234567', 'Diesel', 2000, 'Neu', 'Aluminium'),
(8, 'E-Class', 'Mercedes-Benz', '2021', 'WDDZF4JB1KA123456', 'Benzin', 12000, 'Gebraucht', 'Stahl'),
(9, 'CX-5', 'Mazda', '2022', 'JM3KFBCM4N1234567', 'Benzin', 8000, 'Neu', 'Aluminium'),
(10, 'Impreza', 'Subaru', '2019', 'JF1GPAK61K1234567', 'Benzin', 40000, 'Gebraucht', 'Stahl'),
(11, 'Test', 'Test', 'Test', 'Test', 'Test', 2, 'Test', 'Test');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `closedorders`
--

CREATE TABLE `closedorders` (
  `id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `closedorders`
--

INSERT INTO `closedorders` (`id`, `car_id`, `customer_id`, `employee_id`, `description`) VALUES
(1, 1, 1, 1, 'Ölwechsel'),
(3, 2, 4, 3, 'Reifenwechsel'),
(4, 3, 2, 5, 'Inspektion'),
(7, 4, 3, 2, 'Bremsenservice'),
(10, 5, 5, 4, 'Klimaanlagenwartung');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `customers`
--

CREATE TABLE `customers` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `customers`
--

INSERT INTO `customers` (`id`, `name`, `email`, `phone`, `address`) VALUES
(1, 'Max Mustermann', 'max.mustermann@example.com', '+491234567890', 'Musterstraße 1, 12345 Musterstadt'),
(2, 'Erika Musterfrau', 'erika.musterfrau@example.com', '+491234567891', 'Beispielweg 2, 23456 Beispielstadt'),
(3, 'Hans Meier', 'hans.meier@example.com', '+491234567892', 'Hauptstraße 3, 34567 Hauptstadt'),
(4, 'Petra Schulz', 'petra.schulz@example.com', '+491234567893', 'Nebenstraße 4, 45678 Nebenstadt'),
(5, 'Lukas Huber', 'lukas.huber@example.com', '+491234567894', 'Ringstraße 5, 56789 Ringstadt'),
(6, 'Anna Fischer', 'anna.fischer@example.com', '+491234567895', 'Gartenweg 6, 67890 Gartendorf'),
(7, 'Julia Schneider', 'julia.schneider@example.com', '+491234567896', 'Waldweg 7, 78901 Waldstadt'),
(8, 'Michael Becker', 'michael.becker@example.com', '+491234567897', 'Seestraße 8, 89012 Seestadt'),
(9, 'Laura Hoffmann', 'laura.hoffmann@example.com', '+491234567898', 'Bergstraße 9, 90123 Bergdorf'),
(10, 'Robert Wagner', 'robert.wagner@example.com', '+491234567899', 'Talweg 10, 01234 Talstadt');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `department` varchar(100) NOT NULL,
  `position` varchar(100) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `employees`
--

INSERT INTO `employees` (`id`, `name`, `department`, `position`, `phone`, `email`) VALUES
(1, 'Hans Mueller', 'Karosserie', 'Lehrling', '1234', 'test@test.de'),
(2, 'Anna Schmidt', 'Mechanik', 'Geselle', '5678', 'anna.schmidt@example.com'),
(3, 'Peter Fischer', 'Elektrik', 'Meister', '9101', 'peter.fischer@example.com'),
(4, 'Maria Weber', 'Lackierung', 'Facharbeiter', '1121', 'maria.weber@example.com'),
(5, 'Thomas Becker', 'Verwaltung', 'Sachbearbeiter', '3141', 'thomas.becker@example.com'),
(6, 'Julia Hoffmann', 'Kundenservice', 'Leiterin', '5161', 'julia.hoffmann@example.com'),
(7, 'Michael Wagner', 'Einkauf', 'Einkäufer', '7181', 'michael.wagner@example.com'),
(8, 'Laura Schulz', 'IT', 'Administratorin', '9202', 'laura.schulz@example.com'),
(9, 'Robert Braun', 'Logistik', 'Fahrer', '1223', 'robert.braun@example.com'),
(10, 'Katharina Kaiser', 'HR', 'Personalreferentin', '3243', 'katharina.kaiser@example.com');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `car_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `employee_id` int(11) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Daten für Tabelle `orders`
--

INSERT INTO `orders` (`id`, `car_id`, `customer_id`, `employee_id`, `description`) VALUES
(1, 1, 1, 1, 'Reifenwechsel'),
(2, 1, 1, 1, 'Ölwechsel'),
(5, 2, 4, 3, 'Reifenwechsel'),
(6, 3, 2, 5, 'Bremsenprüfung'),
(8, 4, 3, 2, 'Klimaanlagenwartung'),
(9, 5, 5, 4, 'Inspektion');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `cars`
--
ALTER TABLE `cars`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `chassis_number` (`chassis_number`);

--
-- Indizes für die Tabelle `closedorders`
--
ALTER TABLE `closedorders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `car_id` (`car_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Indizes für die Tabelle `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indizes für die Tabelle `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indizes für die Tabelle `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `car_id` (`car_id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `closedorders`
--
ALTER TABLE `closedorders`
  ADD CONSTRAINT `closedorders_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`),
  ADD CONSTRAINT `closedorders_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `closedorders_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);

--
-- Constraints der Tabelle `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`car_id`) REFERENCES `cars` (`id`),
  ADD CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  ADD CONSTRAINT `orders_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `employees` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

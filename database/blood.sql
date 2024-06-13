-- phpMyAdmin SQL Dump
-- version 5.1.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 13, 2023 at 08:15 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `blood`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(20) NOT NULL,
  `pass` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `email`, `pass`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `blood`
--

CREATE TABLE `blood` (
  `id` int(11) NOT NULL,
  `bloodgrp` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `blood`
--

INSERT INTO `blood` (`id`, `bloodgrp`, `qty`) VALUES
(1, 'A+', 2),
(2, 'A-', 2),
(3, 'B+', 2),
(4, 'B-', 2),
(5, 'AB+', 3),
(6, 'AB-', 2),
(7, 'O+', 3),
(8, 'O-', 2);

-- --------------------------------------------------------

--
-- Table structure for table `donation`
--

CREATE TABLE `donation` (
  `id` int(11) NOT NULL,
  `aadhar` bigint(12) NOT NULL,
  `bloodgrp` varchar(10) NOT NULL,
  `qty` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `donation`
--

INSERT INTO `donation` (`id`, `aadhar`, `bloodgrp`, `qty`, `date`, `time`) VALUES
(1, 1234567890, 'A+', 1, '2023-04-30', '8:47'),
(2, 123456789012, 'O-', 1, '2022-04-06', '12.12'),
(3, 112233445566, 'AB+', 1, '2023-04-30', '8:57'),
(4, 123456789012, 'A+', 1, '2023-04-30', '8:59'),
(5, 123456789012, 'O+', 1, '2023-05-13', '11:34');

-- --------------------------------------------------------

--
-- Table structure for table `doner`
--

CREATE TABLE `doner` (
  `aadhar` bigint(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `bg` varchar(20) NOT NULL,
  `dob` int(11) NOT NULL,
  `gen` varchar(20) NOT NULL,
  `addr` text NOT NULL,
  `pin` int(11) DEFAULT 0,
  `mob` int(11) NOT NULL,
  `email` varchar(40) DEFAULT '-'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doner`
--

INSERT INTO `doner` (`aadhar`, `name`, `bg`, `dob`, `gen`, `addr`, `pin`, `mob`, `email`) VALUES
(1234567890, 'abcabcabc', 'A+', 111950, 'male', 'aaa - aa aaa aaaq', 0, 222222, '-'),
(112233445566, 'varshakirankondhalkar', 'AB+', 1342000, 'female', 'korhale - bmt pune mah', 412103, 96077075, 'varsha923@gmail.com'),
(123456789012, 'shambhurajeshashikantbhosale', 'A+', 111950, 'male', 'korhale bk-bmtpunemah', 12345, 111111111, 'shambhuraje@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `aadhar` int(12) NOT NULL,
  `name` varchar(20) NOT NULL,
  `dob` varchar(20) NOT NULL,
  `bg` varchar(20) NOT NULL,
  `refer` varchar(30) NOT NULL,
  `contact` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`aadhar`, `name`, `dob`, `bg`, `refer`, `contact`) VALUES
(12345, 'dajdsds', '1-1-2008', 'A+', 'dsfsdf', 346983726),
(11223344, 'varsha', '1-1-2008', 'AB+', 'abc', 128736127),
(12345678, 'abc', '1-1-2008', 'A+', 'abc', 123),
(1234567890, 'abc', '1-1-2008', 'A+', 'abc', 12345);

-- --------------------------------------------------------

--
-- Table structure for table `sell`
--

CREATE TABLE `sell` (
  `aadhar` int(12) NOT NULL,
  `bg` varchar(50) NOT NULL,
  `qty` int(11) NOT NULL,
  `date` date NOT NULL,
  `time` time NOT NULL,
  `amount` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sell`
--

INSERT INTO `sell` (`aadhar`, `bg`, `qty`, `date`, `time`, `amount`) VALUES
(1234567890, 'A+', 1, '2023-05-10', '20:12:45', 450),
(1234567890, 'A+', 2, '2023-05-10', '20:16:50', 900);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blood`
--
ALTER TABLE `blood`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `donation`
--
ALTER TABLE `donation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `aadhar` (`aadhar`);

--
-- Indexes for table `doner`
--
ALTER TABLE `doner`
  ADD PRIMARY KEY (`aadhar`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`aadhar`);

--
-- Indexes for table `sell`
--
ALTER TABLE `sell`
  ADD KEY `aadhar` (`aadhar`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blood`
--
ALTER TABLE `blood`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `donation`
--
ALTER TABLE `donation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `donation`
--
ALTER TABLE `donation`
  ADD CONSTRAINT `donation_ibfk_1` FOREIGN KEY (`aadhar`) REFERENCES `doner` (`aadhar`);

--
-- Constraints for table `sell`
--
ALTER TABLE `sell`
  ADD CONSTRAINT `sell_ibfk_1` FOREIGN KEY (`aadhar`) REFERENCES `patient` (`aadhar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

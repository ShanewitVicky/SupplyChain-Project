-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 17, 2018 at 04:45 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id6441472_200892`
--
CREATE DATABASE IF NOT EXISTS `id6441472_200892` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id6441472_200892`;

-- --------------------------------------------------------

--
-- Table structure for table `Products`
--

CREATE TABLE `Products` (
  `Product_Id` int(11) NOT NULL,
  `Product_Name` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Production_Date` date DEFAULT NULL,
  `Expiration_Date` date DEFAULT NULL,
  `Location` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `QR_String` varchar(400) COLLATE utf8_unicode_ci DEFAULT NULL,
  `User_ID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Products`
--

INSERT INTO `Products` (`Product_Id`, `Product_Name`, `Production_Date`, `Expiration_Date`, `Location`, `QR_String`, `User_ID`) VALUES
(33, 'Water', '0000-00-00', '0000-00-00', 'Rouen', 'Water,12/08/2018,01/09/2019,Rouen', 768000),
(34, 'Fire', '2018-08-12', '0000-00-00', 'Paris', 'Fire,2018/08/12,12/08/2019,Paris', 7680007),
(35, 'Beer', '2018-08-12', '2019-08-11', 'Lyon', 'Beer,2018/08/12,2019/08/11,Lyon', 7680012),
(36, 'Wine', '2018-08-12', '0000-00-00', 'Bordeaux', 'Wine,2018/08/12,2019/06/2030,Bordeaux', 768000),
(62, 'hshaa', '0000-00-00', '0000-00-00', 'hzhs', 'hshaa,4664,66767,hzhs,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(63, 'hahaha', '0000-00-00', '0000-00-00', 'hssb', 'hahaha,67679,6764,hssb,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(64, 'hshs', '0000-00-00', '0000-00-00', 'sgsg', 'hshs,4664,6464,sgsg,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(65, 'hshs', '0000-00-00', '0000-00-00', 'shsh', 'hshs,4664,4664,shsh,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(66, 'ggg', '0000-00-00', '0000-00-00', 'ffgg', 'ggg,665,555,ffgg,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(67, 'hdhd', '0000-00-00', '0000-00-00', 'shsh', 'hdhd,646,4646,shsh,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(68, 'hdhs', '0000-00-00', '0000-00-00', 'sgsg', 'hdhs,5665,6464,sgsg,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(69, 'gshs', '0000-00-00', '0000-00-00', 'shhs', 'gshs,566565,565664,shhs,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(70, 'gshsh', '0000-00-00', '0000-00-00', 'zbzbbz', 'gshsh,899897,7667,zbzbbz,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(71, 'jshsj', '0000-00-00', '0000-00-00', 'shsh', 'jshsj,4664,464,shsh,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(72, 'hzhsh', '0000-00-00', '0000-00-00', 'zhzhzh', 'hzhsh,767667,76676,zhzhzh,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(73, 'shshsh', '0000-00-00', '0000-00-00', 'Rouen', 'shshsh,464664,466464,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(74, 'shshsh', '0000-00-00', '0000-00-00', 'Rouen', 'shshsh,464664,466464,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(75, 'shshsh', '0000-00-00', '0000-00-00', 'Rouen', 'shshsh,464664,466464,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(76, 'shshsh', '0000-00-00', '0000-00-00', 'Rouen', 'shshsh,464664,466464,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(77, 'shshsh', '0000-00-00', '0000-00-00', 'Rouen', 'shshsh,464664,466464,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(78, '', '0000-00-00', '0000-00-00', '', ',,,,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(79, 'dhhdhd', '0000-00-00', '0000-00-00', 'Moscow', 'dhhdhd,646464,464643,Moscow,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(80, 'dhhdhd', '0000-00-00', '0000-00-00', 'eiffle tower', 'dhhdhd,646464,464643,eiffle tower,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(81, 'dhhdhd', '0000-00-00', '0000-00-00', 'tokyo', 'dhhdhd,646464,464643,tokyo,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(82, 'Rat', '2018-05-18', '2013-07-15', 'pondy', 'Rat,2018/05/18,2013/07/15,pondy,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(83, 'Rabbit', '0000-00-00', '0000-00-00', 'Chennai', 'Rabbit,12/08/2018,11/08/1992,Chennai,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(84, 'Plant', '2018-05-12', '2013-07-12', 'Madurai', 'Plant,2018/05/12,2013/07/12,Madurai,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(85, 'Pen', '2018-09-08', '2030-01-06', 'Goa', 'Pen,2018/09/08,2030/01/06,Goa,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(86, 'shhs', '2018-08-12', '2017-07-12', 'Cannes', 'shhs,2018/08/12,2017/07/12,Cannes,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(87, 'Toblerone', '1992-08-20', '2018-09-12', 'Ranchi', 'Toblerone,1992/08/20,2018/09/12,Ranchi,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(88, 'Pant', '2018-07-12', '2200-07-08', 'Trichy', 'Pant,2018/07/12,2200/07/08,Trichy,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(89, 'Shirt', '2018-07-08', '2018-08-07', 'Toronto', 'Shirt,2018/07/08,2018/08/07,Toronto,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(90, 'paint', '2018-08-07', '2018-07-08', 'Mumbai', 'paint,2018/08/07,2018/07/08,Mumbai,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(91, 'Belt', '2018-07-08', '2018-07-09', 'Rouen', 'Belt,2018/07/08,2018/7/09,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(92, 'plane', '2018-08-08', '2020-08-08', 'Firenze', 'plane,2018/08/08,2020/08/08,Firenze,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(93, 'hshs', '2018-08-08', '2018-08-08', 'Rouen', 'hshs,2018/08/08,2018/08/08,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(94, 'R', '2018-08-07', '2018-08-07', 'Rouen', 'R,2018/08/07,2018/08/07,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(95, 'R', '2018-08-05', '2018-08-08', 'Rouen', 'R,2018/08/05,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(96, 'rate', '2018-08-08', '2018-08-08', 'Rouen', 'rate,2018/08/08,2018/08/08,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(97, 'R', '2018-08-08', '2018-08-08', 'Rouen', 'R,2018/08/08,2018/08/08,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(98, 'Rouen', '2018-08-08', '2018-08-08', 'Rouen', 'Rouen,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(99, 'hshshs', '2018-08-08', '2018-08-08', 'Rouen', 'hshshs,2018/08/08,2018/08/08,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(100, 'Patty', '2018-08-08', '2018-08-08', 'Roueb', 'Patty,2018/08/08,2018/08/08,Roueb,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(101, 'shhsh', '2018-08-08', '2018-08-08', 'Rouen', 'shhsh,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(102, 'Rate', '2018-08-08', '2018-08-08', 'Rouen', 'Rate,2018/08/08,2018/08/08,Rouen,7680012,Sri,Srija,Sridaran,hdhd,dhhs,hshs', 7680012),
(103, 'ehehhe', '2018-08-08', '2018-08-08', 'rouen', 'ehehhe,2018/08/08,2018/08/08,rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(104, 'gsgshs', '2018-08-08', '2018-08-08', 'Rouen', 'gsgshs,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(105, 'hshdhs', '2018-08-08', '2018-08-08', 'Rouen', 'hshdhs,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(106, 'hshd', '2018-08-08', '2018-08-08', 'Rouen', 'hshd,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(107, 'Jdjdj', '2018-08-08', '2018-08-08', 'Rouen', 'Jdjdj,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(108, 'Shane', '2018-08-08', '2018-08-08', 'Rouen', 'Shane,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(109, 'hdhs', '2018-08-08', '2018-08-08', 'Rouen', 'hdhs,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(110, 'Shane', '2018-08-08', '2018-08-08', 'Rouen', 'Shane,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(111, 'Jdjdj', '2018-08-08', '2018-08-08', 'Rouen', 'Jdjdj,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(112, 'shhshs', '2018-08-08', '2018-08-08', 'Rouen', 'shhshs,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(113, 'shhssh', '2018-08-08', '2018-08-08', 'Rouen', 'shhssh,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007),
(114, 'Test', '2018-08-08', '2018-08-08', 'Rouen', 'Test,2018/08/08,2018/08/08,Rouen,7680007,Shane,Sivakumar,Vignesh,Shane@gmail.com,836728,Shanesri@gmail.com', 7680007);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `Usr_id` int(11) NOT NULL,
  `User_Name` varchar(100) DEFAULT NULL,
  `password` varchar(600) NOT NULL,
  `First_Name` varchar(100) NOT NULL,
  `Last_Name` varchar(100) NOT NULL,
  `Email_id` varchar(100) NOT NULL,
  `Phone_Number1` varchar(10) NOT NULL,
  `URL` varchar(10) DEFAULT NULL,
  `Address` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`Usr_id`, `User_Name`, `password`, `First_Name`, `Last_Name`, `Email_id`, `Phone_Number1`, `URL`, `Address`) VALUES
(7680007, 'Shane', 'EG+8X2xd0l3Q5BVxgY0ENb9vgtU=', 'Sivakumar', 'Vignesh', 'Shane@gmail.com', '836728', 'http://sha', 'Shanesri@gmail.com'),
(7680009, 'Shanehshs', 'EG+8X2xd0l3Q5BVxgY0ENb9vgtU=', 'dhsh', 'sjjs', 'hsns', 'jdjs', 'hssh', 'hssh'),
(7680011, 'Shane2', 'EG+8X2xd0l3Q5BVxgY0ENb9vgtU=', 'hshs', 'zhzh', 'jxhd', 'xhxj', 'xhhx', 'hxxh'),
(7680012, 'Sri', 'EG+8X2xd0l3Q5BVxgY0ENb9vgtU=', 'Srija', 'Sridaran', 'hdhd', 'dhhs', 'dhhd', 'hshs');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Products`
--
ALTER TABLE `Products`
  ADD PRIMARY KEY (`Product_Id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`Usr_id`),
  ADD UNIQUE KEY `User_Name` (`User_Name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Products`
--
ALTER TABLE `Products`
  MODIFY `Product_Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `Usr_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7680014;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

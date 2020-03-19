-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- 主機： localhost
-- 產生時間： 
-- 伺服器版本： 8.0.17
-- PHP 版本： 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `checkpoint`
--

-- --------------------------------------------------------

--
-- 資料表結構 `land`
--

CREATE TABLE `land` (
  `PLACE_NUMBER` int(50) NOT NULL,
  `LAND_PRICE` int(50) NOT NULL,
  `TOLLS` int(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- 傾印資料表的資料 `land`
--

INSERT INTO `land` (`PLACE_NUMBER`, `LAND_PRICE`, `TOLLS`) VALUES
(1, 300, 30),
(2, 500, 50),
(3, 600, 60),
(4, 450, 45),
(6, 550, 55),
(7, 600, 60),
(8, 500, 50),
(9, 400, 40),
(11, 900, 90),
(12, 800, 80),
(13, 900, 90),
(14, 900, 90),
(16, 1000, 100),
(17, 1200, 120),
(18, 1050, 105),
(19, 1100, 110);

--
-- 已傾印資料表的索引
--

--
-- 資料表索引 `land`
--
ALTER TABLE `land`
  ADD PRIMARY KEY (`PLACE_NUMBER`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

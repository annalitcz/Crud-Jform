-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2023 at 03:43 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--

CREATE TABLE `barang` (
  `kode_brg` int(11) NOT NULL,
  `nama_brg` varchar(255) NOT NULL,
  `stock_brg` int(11) NOT NULL,
  `harga_brg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

CREATE TABLE `faktur` (
  `nomor_faktur` int(11) NOT NULL,
  `tgl_faktur` date NOT NULL,
  `kode_plg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

CREATE TABLE `faktur_detail` (
  `kode_faktur` int(11) DEFAULT NULL,
  `nomor_faktur` int(11) NOT NULL,
  `kode_brg` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `harga_brg` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

CREATE TABLE `kwitansi` (
  `nomer_kwi` int(11) NOT NULL,
  `tgl_kwi` date NOT NULL,
  `nomor_faktur` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

CREATE TABLE `pelanggan` (
  `kode_plg` int(11) NOT NULL,
  `nama_plg` varchar(255) NOT NULL,
  `alamat_plg` varchar(255) NOT NULL,
  `hp_plg` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--

ALTER TABLE `barang`
  ADD PRIMARY KEY (`kode_brg`);

--

ALTER TABLE `faktur`
  ADD PRIMARY KEY (`nomor_faktur`),
  ADD KEY `kode_plg` (`kode_plg`);

--

ALTER TABLE `faktur_detail`
  ADD KEY `kode_faktur` (`kode_faktur`),
  ADD KEY `kode_brg` (`kode_brg`);

--

ALTER TABLE `kwitansi`
  ADD PRIMARY KEY (`nomer_kwi`),
  ADD KEY `nomor_faktur` (`nomor_faktur`);

--

ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kode_plg`);

--

ALTER TABLE `faktur`
  ADD CONSTRAINT `faktur_ibfk_1` FOREIGN KEY (`kode_plg`) REFERENCES `pelanggan` (`kode_plg`);

--

ALTER TABLE `faktur_detail`
  ADD CONSTRAINT `faktur_detail_ibfk_1` FOREIGN KEY (`kode_faktur`) REFERENCES `faktur` (`nomor_faktur`),
  ADD CONSTRAINT `faktur_detail_ibfk_2` FOREIGN KEY (`kode_brg`) REFERENCES `barang` (`kode_brg`);

--

ALTER TABLE `kwitansi`
  ADD CONSTRAINT `kwitansi_ibfk_1` FOREIGN KEY (`nomor_faktur`) REFERENCES `faktur` (`nomor_faktur`);

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


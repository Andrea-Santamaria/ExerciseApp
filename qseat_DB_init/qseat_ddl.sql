-- qseat.AnagraficaDipendenti definition
DROP TABLE IF EXISTS `AnagraficaDipendenti`;

CREATE TABLE `AnagraficaDipendenti` (
  `Email` varchar(100) NOT NULL,
  `NomeBreve` varchar(100) NOT NULL,
  `NomeEsteso` varchar(100) NOT NULL,
  `Nome` varchar(100) NOT NULL,
  `Cognome` varchar(100) NOT NULL,
  `Ruolo` varchar(100) NOT NULL,
  `InsertUpdateTimestamp` datetime DEFAULT NULL,
  `DataEntrata` date DEFAULT NULL,
  `DataUscita` date DEFAULT NULL,
  PRIMARY KEY (`Email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- qseat.AnagraficaPostazioni definition
DROP TABLE IF EXISTS `AnagraficaPostazioni`;

CREATE TABLE `AnagraficaPostazioni` (
  `IdPostazioneScrivania` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PrenotabileFlag` tinyint(1) NOT NULL,
  `Destinazione` varchar(100) NOT NULL,
  `Sede` varchar(100) NOT NULL,
  `Piano` varchar(100) NOT NULL,
  `InsertUpdateTimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`IdPostazioneScrivania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


-- qseat.StoricoPrenotazioni definition
DROP TABLE IF EXISTS `StoricoPrenotazioni`;

CREATE TABLE `StoricoPrenotazioni` (
  `Data` date NOT NULL,
  `CodPostazioneScrivania` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Risorsa` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `InsertUpdateTimestamp` datetime DEFAULT NULL,
  PRIMARY KEY (`Data`,`CodPostazioneScrivania`),
  KEY `StoricoPrenotazioni_FK` (`Risorsa`),
  KEY `StoricoPrenotazioni_FK_1` (`CodPostazioneScrivania`),
  CONSTRAINT `StoricoPrenotazioni_FK` FOREIGN KEY (`Risorsa`) REFERENCES `AnagraficaDipendenti` (`Email`),
  CONSTRAINT `StoricoPrenotazioni_FK_1` FOREIGN KEY (`CodPostazioneScrivania`) REFERENCES `AnagraficaPostazioni` (`IdPostazioneScrivania`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE DATABASE otpservice;
CREATE TABLE `otpverification` (
  `email` varchar(100) NOT NULL PRIMARY KEY,
  `otp` varchar(10) NOT NULL,
  `expireAt` datetime NOT NULL,
  `emailSentCount` int(11) NOT NULL DEFAULT 1,
  `failedAttemptCount` int(11) NOT NULL DEFAULT 0
)
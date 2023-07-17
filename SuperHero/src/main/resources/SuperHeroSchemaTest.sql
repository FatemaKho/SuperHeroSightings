DROP DATABASE IF EXISTS SuperHeroDBTest;

CREATE DATABASE SuperHeroDBTest;

USE SuperHeroDBTest;


CREATE TABLE location (
   locationId  INT NOT NULL AUTO_INCREMENT,
   locationName  VARCHAR(50) NOT NULL,
   locationDesc VARCHAR(50) NOT NULL,
   locationAddress VARCHAR(50) NOT NULL,
   locationLatitude VARCHAR(50) NOT NULL,
   locationLongitude  VARCHAR(50) NOT NULL,
   CONSTRAINT pk_location
      PRIMARY KEY (locationId)
      );

CREATE TABLE superpowers (
    superpowerId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    superpowerName VARCHAR(50) NOT NULL ,
    superpowerDesc VARCHAR(250) NOT NULL
);


CREATE TABLE superhuman (
  superhumanId INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  superhumanName VARCHAR(50) NOT NULL,
  superhumanDesc VARCHAR(50) NOT NULL,
  superhumanIsHero BOOLEAN NOT NULL,
  superpowerId INT NOT NULL,
  FOREIGN KEY (superpowerId) REFERENCES superpowers (superpowerId)
  );




CREATE TABLE sighting(
	sightingId INT PRIMARY KEY AUTO_INCREMENT,
    superhumanId INT  NOT NULL,
    dateSeen DATE NOT NULL,
    FOREIGN KEY (superhumanId) REFERENCES superhuman(superhumanId)
);

CREATE TABLE organizations(
	OrganizationId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    organizationName VARCHAR(50) NOT NULL,
    organizationDesc VARCHAR(255) NOT NULL,
    organizationAddress VARCHAR(50) NOT NULL,
    organizationContactInfo VARCHAR(50) NOT NULL,
    organizationIsHero BOOLEAN NOT NULL
);


CREATE TABLE superhumanOrganizations (
    superhumanId INT,
    organizationId INT,
    CONSTRAINT pk_superhumanOrganizations
    	PRIMARY KEY (superhumanId, organizationId),
    CONSTRAINT fk_superhumanOrganization_superhuman
    	FOREIGN KEY (superhumanId)
    	REFERENCES superhuman(superhumanId),
	CONSTRAINT fk_superhumanOrganization_organizations
    	FOREIGN KEY (organizationId)
    	REFERENCES organizations(organizationId)
);

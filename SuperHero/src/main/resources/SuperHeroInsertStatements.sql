INSERT INTO superpowers (superpowerId, superpowerName, superpowerDesc) VALUES
  (1, 'Flight', 'Ability to fly through the air.'),
  (2, 'Energy Projection', 'Ability to project powerful energy attacks.'),
  (3, 'Infinity Gauntlet', 'Holds all six Infinity Gems, granting immense power.'),
  (4, 'Reality Warping', 'Ability to warp reality and alter the fabric of existence.'),
  (5, 'Illusions', 'Mastery of creating lifelike illusions.'),
  (6, 'Storm Manipulation', 'Control over weather and natural elements.');
 INSERT INTO superhuman (superhumanName, superhumanDesc, superhumanIsHero, superpowerId) VALUES
  ('Superman', 'The Last Son of Krypton', 1, 1),  -- Superman has "Flight" (superpowerId = 1)
  ('Doctor Strange', 'Master of the Mystic Arts', 1, 2),  -- Doctor Strange has "Energy Projection" (superpowerId = 2)
  ('Thanos', 'The Mad Titan', 0, 3),  -- Thanos has "Infinity Gauntlet" (superpowerId = 3)
  ('Scarlet Witch', 'Reality Warping Witch', 0, 4),  -- Scarlet Witch has "Reality Warping" powers (superpowerId = 4)
  ('Loki', 'God of Mischief', 0, 5),  -- Loki has "Illusions" (superpowerId = 5)
  ('Thor', 'God of Thunder', 1, 6);  -- Thor has "Storm Manipulation" (superpowerId = 6)

-- Inserting Data into Organizations (2 Hero, 2 Villain)
-- True or 1 = Hero Organization
-- False or 0 = Villain Organization
INSERT INTO organizations (OrganizationId, organizationName, organizationDesc, organizationAddress, organizationContactInfo, organizationIsHero)
VALUES
	(1, 
    "The Tricksters", 
    "Quick-witted heroes that outsmart villains and protect the world",
    "Mischief City, NY",
    "384-497-8225",
    True),
    (2, 
    "The Viper Defenders", 
    "Deadly villains whose venomous tactics strike fear into the hearts of their adversaries",
    "Venomville, CA",
    "686-944-6247",
    False),
    (3, 
    "The Goliaths", 
    "Unwavering determination, and an unwavering commitment to protect the innocent and vanquish evil",
    "Metropolis, FL",
    "459-529-7755",
    True),
    (4, 
    "The Demon Allies", 
    "Malevolent supernatural beings united by their insidious desires for power, chaos, and the destruction of all that is good",
    "Shadowville, TX",
    "662-365-4310",
    False);
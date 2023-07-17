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
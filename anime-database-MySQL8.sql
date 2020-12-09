CREATE DATABASE IF NOT EXISTS anime
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS anime.anime (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS anime.dev_dojo_user (
    id BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    authorities VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(255) UNIQUE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO anime.anime (name) VALUES
    ('Death Note'), ('Steins Gate'), ('Diamond no Ace'),
    ('Naruto'), ('Dragon Ball Z'), ('Overlord'), ('Cowboy Bebop'),
    ('Drifters'), ('Hellsing'), ('Berserk'), ('Golden Kamuy'),
    ('God Eater'), ('Grand Blue'), ('One Piece'), ('Attack on Titan'), ('Fullmetal Alchemist');


INSERT INTO anime.dev_dojo_user (
    authorities, name, username, password) VALUES (
    'ROLE_ADMIN,ROLE_USER',
    'Israel Ferreira',
    'israelferreira',
    '{bcrypt}$2a$10$ETz6pjIECIP9fsbGChEVtumu0Sjv2rtg5vh8XTHPJyevcmmMPishi' /* password: springboot */
);

INSERT INTO anime.dev_dojo_user (
    authorities, name, username, password) VALUES (
    'ROLE_USER',
    'DevDojo Academy',
    'devdojo',
    '{bcrypt}$2a$10$QX7JJZ3AbVTqzb0SyaZhYuJ.nvtU9p36flxVwp1V0kQKlDMcS87RW' /* password: academy */
);


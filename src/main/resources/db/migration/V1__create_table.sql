CREATE TABLE planets (
    planet_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    climate VARCHAR(255) NOT NULL,
    terrain VARCHAR(255) NOT NULL,
    quantity INT NOT NULL
);
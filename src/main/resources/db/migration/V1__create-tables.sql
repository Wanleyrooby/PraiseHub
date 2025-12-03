DROP TABLE IF EXISTS louvor_tags;
DROP TABLE IF EXISTS louvores;


CREATE TABLE louvores (
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(100),
    tom VARCHAR(50),
    letra TEXT,
    duracao INT,
    horario_criacao DATETIME,
    horario_atualizacao DATETIME,
    PRIMARY KEY (id)
);


CREATE TABLE louvor_tags (
    louvor_id BIGINT NOT NULL,
    tag VARCHAR(255) NOT NULL,
    CONSTRAINT fk_louvor_tags_louvor
        FOREIGN KEY (louvor_id) REFERENCES louvores(id)
        ON DELETE CASCADE
);

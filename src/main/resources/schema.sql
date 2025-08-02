CREATE TABLE IF NOT EXISTS courses (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(4000) NOT NULL,
  duration INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE turma_participante (
    codigo SERIAL PRIMARY KEY,
    turma INT NOT NULL,
    funcionario INT NOT NULL,
    FOREIGN KEY (turma) REFERENCES turma(codigo) ON DELETE CASCADE,
    FOREIGN KEY (funcionario) REFERENCES funcionario(codigo)
);

CREATE TABLE turma (
    codigo SERIAL PRIMARY KEY,
    inicio DATE NOT NULL,
    fim DATE NOT NULL,
    local VARCHAR(200),
    curso INT NOT NULL,
    FOREIGN KEY (curso) REFERENCES courses(id) ON DELETE CASCADE
);
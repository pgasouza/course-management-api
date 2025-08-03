CREATE TABLE IF NOT EXISTS courses (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(100) NOT NULL,
  description VARCHAR(4000) NOT NULL,
  duration INT NOT NULL,
  created_at TIMESTAMP NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS employees (
  id SERIAL PRIMARY KEY,
  name VARCHAR(200) NOT NULL,
  cpf CHAR(11) NOT NULL,
  birth_date DATE NOT NULL,
  position VARCHAR(200) NOT NULL,
  admission_date DATE NOT NULL,
  active BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS training_sessions (
  id SERIAL PRIMARY KEY,
  start_date DATE NOT NULL,
  end_date DATE NOT NULL,
  location VARCHAR(200),
  course_id INT NOT NULL,
  FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS training_participants (
  id SERIAL PRIMARY KEY,
  training_id INT NOT NULL,
  employee_id INT NOT NULL,
  FOREIGN KEY (training_id) REFERENCES training_sessions(id) ON DELETE CASCADE,
  FOREIGN KEY (employee_id) REFERENCES employees(id)
);
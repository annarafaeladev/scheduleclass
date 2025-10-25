-- 🟦 Faixa
DROP TYPE IF EXISTS BELT_LEVEL;
CREATE TYPE BELT_LEVEL AS ENUM ('WHITE', 'BLUE', 'PURPLE', 'BROWN', 'BLACK', 'CORAL');

CREATE TABLE belt (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(10) NOT NULL,
    belt_level BELT_LEVEL NOT NULL DEFAULT 'WHITE',
    lessons_to_next INT DEFAULT 0 NOT NULL
);

-- Inserindo faixas na tabela belt
INSERT INTO belt (name, belt_level, lessons_to_next) VALUES
('Branca', 'WHITE', 30),
('Azul', 'BLUE', 45),
('Roxa', 'PURPLE', 60),
('Marrom', 'BROWN', 90),
('Preta', 'BLACK', 120),
('Coral', 'CORAL', 0); -- Última faixa, sem próximo grau


-- 📅 Plano (limite de aulas)
CREATE TABLE plan (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    monthly_limit INT, -- null = ilimitado
    price DECIMAL(10,2),
    description VARCHAR(255)
);

-- 🎯 Academia
CREATE TABLE academy (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(300) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 🥋 Instrutor / Administrador
CREATE TABLE instructor (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    phone VARCHAR(20) NOT NULL,
    is_owner BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (academy_id) REFERENCES academy(id)
);

-- 👤 Aluno
CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20) NOT NULL,
    belt_id BIGINT,
    belt_degree INT DEFAULT 0,
    total_bookings INT DEFAULT 0,
    plan_id BIGINT,
    active BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (academy_id) REFERENCES academy(id),
    FOREIGN KEY (belt_id) REFERENCES belt(id),
    FOREIGN KEY (plan_id) REFERENCES plan(id)
);

-- 🕐 Aula (horário, faixa, limite)
CREATE TABLE class_schedule (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL,
    instructor_id BIGINT NOT NULL,
    day_of_week VARCHAR(10), -- exemplo: 'MONDAY'
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    max_students INT NOT NULL,
    min_belt_degree INT,
    active BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (academy_id) REFERENCES academy(id),
    FOREIGN KEY (instructor_id) REFERENCES instructor(id)
);

-- 📆 Agendamento de aluno
CREATE TABLE booking (
    id BIGSERIAL PRIMARY KEY,
    class_id BIGINT NOT NULL,
    student_id BIGINT NOT NULL,
    booking_date DATE NOT NULL, -- data específica (ex: 2025-10-22)
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    canceled BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (class_id) REFERENCES class_schedule(id),
    FOREIGN KEY (student_id) REFERENCES student(id),
    UNIQUE (class_id, student_id, booking_date) -- evita duplicidade
);

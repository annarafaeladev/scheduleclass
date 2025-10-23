-- 🟦 Faixa
CREATE TABLE belt (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL, -- branca, azul, roxa, etc.
    order_level INT NOT NULL -- facilita comparação (ex: 1=branca, 2=azul...)
);

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
    address VARCHAR(200),
    phone VARCHAR(20),
    email VARCHAR(100),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 🥋 Instrutor / Administrador
CREATE TABLE instructor (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    is_owner BOOLEAN DEFAULT TRUE,
    FOREIGN KEY (academy_id) REFERENCES academy(id)
);

-- 👤 Aluno
CREATE TABLE student (
    id BIGSERIAL PRIMARY KEY,
    academy_id BIGINT NOT NULL,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    belt_id BIGINT,
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
    belt_min_level INT, -- exemplo: só acima da faixa azul
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

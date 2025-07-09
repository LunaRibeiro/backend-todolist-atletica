CREATE TYPE role_enum AS ENUM (
    'PRESIDÊNCIA',
    'MARKETING',
    'TESOURARIA',
    'ESPORTES',
    'SECRETARIA',
    'TODOS'
    );

CREATE TYPE status_enum AS ENUM (
    'PENDENTE',
    'CONCLUIDA',
    'ATRASADA'
    );

CREATE TABLE director (
   id BIGSERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   email VARCHAR(255) UNIQUE NOT NULL,
   password VARCHAR(255) NOT NULL,
   role role_enum NOT NULL,
   active BOOLEAN DEFAULT TRUE
);

CREATE TABLE task (
   id BIGSERIAL PRIMARY KEY,
   title VARCHAR(255) NOT NULL,
   description VARCHAR(255),
   due_date DATE NOT NULL,
   status status_enum NOT NULL DEFAULT 'PENDENTE',
   drive_link VARCHAR(255),
   responsible_id BIGINT REFERENCES director(id) ON DELETE SET NULL,
   created_at TIMESTAMP DEFAULT NOW()
);

CREATE TABLE task_target_roles (
    task_id BIGINT NOT NULL REFERENCES task(id) ON DELETE CASCADE,
    role role_enum NOT NULL,
    PRIMARY KEY (task_id, role)
);

CREATE TABLE task_users (
   task_id BIGINT NOT NULL REFERENCES task(id) ON DELETE CASCADE,
   user_id BIGINT NOT NULL REFERENCES director(id) ON DELETE CASCADE,
   PRIMARY KEY (task_id, user_id)
);
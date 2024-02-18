CREATE TABLE IF NOT EXISTS public.tb_clients
(
    id SERIAL PRIMARY KEY,
    address VARCHAR(255),
    contact_number VARCHAR(255),
    department VARCHAR(255),
    gender VARCHAR(255),
    name VARCHAR(255),
    skills VARCHAR(255),
    is_active BOOLEAN
);
CREATE TABLE card(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    number VARCHAR(16) NOT NULL,
    password VARCHAR(25) NOT NULL,
    balance DECIMAL NOT NULL
);
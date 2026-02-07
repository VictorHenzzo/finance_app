CREATE TYPE category_type AS ENUM ('INCOME', 'EXPENSE');

CREATE TABLE transaction_category (
    id UUID PRIMARY KEY,
    parent_id UUID NULL,
    name VARCHAR(150) NOT NULL,
    icon VARCHAR(100) NOT NULL,
    type category_type NOT NULL,

    CONSTRAINT fk_category_parent
        FOREIGN KEY (parent_id)
        REFERENCES transaction_category(id)
);

CREATE INDEX idx_transaction_category_parent
    ON transaction_category(parent_id);


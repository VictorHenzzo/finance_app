CREATE TABLE user_account (
    id UUID PRIMARY KEY,
    user_id UUID REFERENCES users(id) NOT NULL,
    financial_institution_id UUID REFERENCES financial_institution(id) NOT NULL,
    balance DECIMAL(19, 2) NOT NULL DEFAULT 0
);
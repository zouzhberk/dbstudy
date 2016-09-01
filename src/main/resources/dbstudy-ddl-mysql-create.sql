
CREATE TABLE StockPrice (
    id BIGINT NOT NULL,
    close DOUBLE NOT NULL,
    stock_id BIGINT NOT NULL,
    date BIGINT DEFAULT NULL,
    description VARCHAR(255) DEFAULT NULL,
    PRIMARY KEY(id));
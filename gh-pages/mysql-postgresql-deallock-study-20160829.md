RDBMS Deadlock Study
===================

```SQL

CREATE TABLE ambari.cluster_version (
  id BIGINT NOT NULL,
  repo_version_id BIGINT NOT NULL,
  cluster_id BIGINT NOT NULL,
  state VARCHAR(32) NOT NULL,
  start_time BIGINT NOT NULL,
  end_time BIGINT,
  user_name VARCHAR(32),
  PRIMARY KEY (id));

CREATE TABLE dbstudy.StockPrice (
    id BIGINT NOT NULL,
    close DOUBLE NOT NULL,
    stock_id BIGINT NOT NULL,
    date BIGINT DEFAULT NULL,
    PRIMARY KEY(id));
```
MySQL

ISOLATION LEVEL

    READ UNCOMMITED

    READ COMMITED

    REPEATABLE READ

    SERIALIZABLE

PostgreSQL



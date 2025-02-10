CREATE KEYSPACE springcloud
WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE User_data (
                           Name text,
                           id uuid,
                           address text,
                           PRIMARY KEY (id)
);

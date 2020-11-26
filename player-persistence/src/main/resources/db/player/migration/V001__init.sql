CREATE TABLE team
(
    id         uuid          NOT NULL,
    name       varchar       NOT NULL UNIQUE,
    commission numeric(2, 1) NOT NULL,
    CONSTRAINT team_pkey PRIMARY KEY (id),
    CONSTRAINT team_commission_range_check CHECK (commission >= 0 AND commission <= 10)
);

CREATE TABLE player
(
    id      uuid    NOT NULL,
    name    varchar NOT NULL UNIQUE,
    age     int     NOT NULL,
    team_id uuid,
    CONSTRAINT player_pkey PRIMARY KEY (id),
    CONSTRAINT player_age_range_check CHECK (age >= 18 AND age < 60),
    CONSTRAINT player_team_id_fkey
        FOREIGN KEY (team_id) REFERENCES team
);

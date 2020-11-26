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
    id            uuid    NOT NULL,
    name          varchar NOT NULL UNIQUE,
    birthday      date    NOT NULL,
    contract_date date,
    team_id       uuid,
    CONSTRAINT player_pkey PRIMARY KEY (id),
    CONSTRAINT player_birthday_check CHECK (birthday < now()),
    CONSTRAINT player_contract_date_check CHECK (team_id IS NULL OR contract_date IS NOT NULL),
    CONSTRAINT player_team_id_fkey
        FOREIGN KEY (team_id) REFERENCES team
);

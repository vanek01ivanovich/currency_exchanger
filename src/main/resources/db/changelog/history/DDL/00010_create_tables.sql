CREATE TABLE IF NOT EXISTS CurrencyExchangeRate.Currencies (
    ID SERIAL,
    CurrencyName VARCHAR(50),
    Valid BOOLEAN NOT NULL DEFAULT TRUE,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS CurrencyExchangeRate.ExchangeRateHistory (
    ID SERIAL,
    Success BOOLEAN NOT NULL,
    BaseCurrency VARCHAR(50) NOT NULL,
    RateDate TIMESTAMP NOT NULL,
    Rates TEXT NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE IF NOT EXISTS CurrencyExchangeRate.ExchangeRates (
    ID SERIAL,
    Currency VARCHAR(50) NOT NULL,
    Rate NUMERIC NOT NULL,
    BaseCurrency VARCHAR(50) NOT NULL,
    RateDate TIMESTAMP NOT NULL,
    FK_RateHistoryResponseId INT,
    PRIMARY KEY(ID),
    CONSTRAINT FK_ExchangeRateHistory_ID_ExchangeRate_FK_RateHistoryResponseId
        FOREIGN KEY(ID)
            REFERENCES CurrencyExchangeRate.ExchangeRateHistory(ID)
);


/*todo add indexes*/

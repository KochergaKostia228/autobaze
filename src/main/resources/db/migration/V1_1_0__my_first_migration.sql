
CREATE TABLE IF NOT EXISTS Drivers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    experience INT NOT NULL,
    earnings money DEFAULT 0
);

CREATE TABLE IF NOT EXISTS Cars (
    id SERIAL PRIMARY KEY,
    capacity INT NOT NULL,
    current_load INT DEFAULT 0,
    broken BOOLEAN DEFAULT FALSE
);

CREATE TABLE IF NOT EXISTS Requests (
    id SERIAL PRIMARY KEY,
    destination VARCHAR(255) NOT NULL,
    cargo_amount INT NOT NULL,
    cargo_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS Trips (
    id SERIAL PRIMARY KEY,
    driver_id INTEGER,
    car_id INTEGER,
    request_id INTEGER,
    status VARCHAR(50) NOT NULL,
    earnings money DEFAULT 0,
    trip_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    FOREIGN KEY (driver_id) REFERENCES Drivers(id) ON DELETE CASCADE,
    FOREIGN KEY (car_id) REFERENCES Cars(id) ON DELETE CASCADE,
    FOREIGN KEY (request_id) REFERENCES Requests(id) ON DELETE CASCADE

);

CREATE TABLE IF NOT EXISTS RepairRequests (
    id SERIAL PRIMARY KEY,
    car_id INTEGER,
    description TEXT NOT NULL,
    request_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    completed BOOLEAN DEFAULT FALSE,

    FOREIGN KEY (car_id) REFERENCES Cars(id) ON DELETE CASCADE
);
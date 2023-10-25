DROP TABLE IF EXISTS
CREATE TABLE CORDLESSDRILL(
    CordlessDrill_id INT AUTO_INCREMENT PRIMARY KEY,
    CordlessDrill_brand VARCHAR(50) NOT NULL,
    CordlessDrill_model VARCHAR(50) NOT NULL,
    CordlessDrill_isTaken BIT NOT NULL
);


CREATE TABLE WORKER(
    Worker_id INT AUTO_INCREMENT PRIMARY KEY,
    Worker_name VARCHAR(50) NOT NULL,
    Worker_currentTools VARCHAR(50)
);



CREATE SCHEMA IF NOT EXISTS tracking;

CREATE TABLE IF NOT EXISTS tracking.tracking (
    tracking_id SERIAL PRIMARY KEY,
    user_id INT,
    job_id INT,
    application_date DATE,
    status VARCHAR(20),
    interview BOOLEAN,
    interview_date TIMESTAMP,
    final_status VARCHAR(20)
);
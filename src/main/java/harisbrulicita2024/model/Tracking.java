package harisbrulicita2024.model;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "tracking", name = "tracking")
public class Tracking extends PanacheEntityBase {

    @Id
    public Long tracking_id;

    public Long user_id;
    public Long job_id;
    public LocalDate application_date;
    public String status;
    public Boolean interview;
    public LocalDateTime interview_date;
    public String final_status;

    public Tracking() {
    }

    public Tracking(Long tracking_id, Long user_id, Long job_id, LocalDate application_date, String status, Boolean interview, LocalDateTime interview_date, String final_status) {
        this.tracking_id = tracking_id;
        this.user_id = user_id;
        this.job_id = job_id;
        this.application_date = application_date;
        this.status = status;
        this.interview = interview;
        this.interview_date = interview_date;
        this.final_status = final_status;
    }

    // Getteri i setteri
    public Long getTracking_id() {
        return tracking_id;
    }

    public void setTracking_id(Long tracking_id) {
        this.tracking_id = tracking_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getJob_id() {
        return job_id;
    }

    public void setJob_id(Long job_id) {
        this.job_id = job_id;
    }

    public LocalDate getApplication_date() {
        return application_date;
    }

    public void setApplication_date(LocalDate application_date) {
        this.application_date = application_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getInterview() {
        return interview;
    }

    public void setInterview(Boolean interview) {
        this.interview = interview;
    }

    public LocalDateTime getInterview_date() {
        return interview_date;
    }

    public void setInterview_date(LocalDateTime interview_date) {
        this.interview_date = interview_date;
    }

    public String getFinal_status() {
        return final_status;
    }

    public void setFinal_status(String final_status) {
        this.final_status = final_status;
    }
}

package harisbrulicita2024.service;

import harisbrulicita2024.model.Tracking;
import harisbrulicita2024.repository.TrackingRepository;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import jakarta.transaction.Transactional;

import java.util.List;

import static io.quarkus.hibernate.reactive.panache.PanacheEntityBase.persist;

@ApplicationScoped
public class TrackingService {

    @Inject
    TrackingRepository trackingRepository;

    @Transactional
    public Uni<Tracking> createTracking(Tracking tracking) {
        return Panache.withTransaction(() -> persist(tracking))
                .onItem().transform(inserted -> tracking)
                .onFailure().invoke(Throwable::printStackTrace);
    }
    @WithSession
    public Uni<List<Tracking>> findAll() {
        return trackingRepository.listAll();
    }

    @WithSession
    public Uni<Tracking> findById(Long tracking_id) {
        return trackingRepository.findById(tracking_id);
    }

    @WithTransaction
    public Uni<Tracking> create(Tracking tracking) {
        return trackingRepository.persist(tracking)
                .onItem().transform(inserted -> tracking);
    }

    @WithTransaction
    public Uni<Tracking> update(Long tracking_id, Tracking updatedTracking) {
        return trackingRepository.findById(tracking_id)
                .onItem().ifNotNull().transformToUni(existing -> {
                    existing.setUser_id(updatedTracking.getUser_id());
                    existing.setJob_id(updatedTracking.getJob_id());
                    existing.setApplication_date(updatedTracking.getApplication_date());
                    existing.setStatus(updatedTracking.getStatus());
                    existing.setInterview(updatedTracking.getInterview());
                    existing.setInterview_date(updatedTracking.getInterview_date());
                    existing.setFinal_status(updatedTracking.getFinal_status());
                    return trackingRepository.persist(existing);
                });
    }

    @WithTransaction
    public Uni<Boolean> delete(Long tracking_id) {
        return trackingRepository.deleteById(tracking_id)
                .onItem().transform(deleted -> deleted);
    }
}

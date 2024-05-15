package harisbrulicita2024.repository;

import harisbrulicita2024.model.Tracking;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TrackingRepository implements PanacheRepository<Tracking> {
}


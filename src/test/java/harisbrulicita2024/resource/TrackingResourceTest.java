package harisbrulicita2024.resource;

import io.smallrye.mutiny.Uni;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import harisbrulicita2024.repository.TrackingRepository;
import harisbrulicita2024.model.Tracking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TrackingResourceTest {

    @Test
    public void testListAllTrackings() {
        Tracking testTracking = new Tracking();
        testTracking.tracking_id = 123L;
        testTracking.user_id = 456L;
        testTracking.job_id = 789L;
        testTracking.application_date = LocalDate.of(2021, 1, 1);
        testTracking.status = "status";
        testTracking.interview = true;
        testTracking.interview_date = LocalDateTime.of(2021, 1, 1, 12, 0);
        testTracking.final_status = "final_status";



        TrackingRepository trackingRepository = Mockito.mock(TrackingRepository.class);
        when(trackingRepository.listAll()).thenReturn(Uni.createFrom().item(Collections.singletonList(testTracking)));

        List<Tracking> result = trackingRepository.listAll().await().indefinitely();
        assertEquals(1, result.size());
        assertEquals(testTracking, result.getFirst());
    }
}
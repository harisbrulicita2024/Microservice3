package harisbrulicita2024.resource;
import harisbrulicita2024.model.Tracking;
import harisbrulicita2024.service.TrackingService;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/tracking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TrackingResource {

    @Inject
    TrackingService trackingService;

    @GET
    public Uni<List<Tracking>> findAll() {
        return trackingService.findAll();
    }

    @GET
    @Path("/{tracking_id}")
    public Uni<Tracking> findById(@PathParam("tracking_id") Long tracking_id) {
        return trackingService.findById(tracking_id);
    }

    @POST
    public Uni<Tracking> create(Tracking tracking) {
        return trackingService.create(tracking);
    }

    @PUT
    @Path("/{tracking_id}")
    public Uni<Tracking> update(@PathParam("tracking_id") Long tracking_id, Tracking updatedTracking) {
        return trackingService.update(tracking_id, updatedTracking);
    }

    @DELETE
    @Path("/{tracking_id}")
    public Uni<Boolean> delete(@PathParam("tracking_id") Long tracking_id) {
        return trackingService.delete(tracking_id);
    }
}
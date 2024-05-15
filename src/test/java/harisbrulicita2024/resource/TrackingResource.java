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
    @Path("/{id}")
    public Uni<Tracking> findById(@PathParam("id") Long id) {
        return trackingService.findById(id);
    }

    @POST
    public Uni<Tracking> create(Tracking tracking) {
        return trackingService.create(tracking);
    }

    @PUT
    @Path("/{id}")
    public Uni<Tracking> update(@PathParam("id") Long id, Tracking updatedTracking) {
        return trackingService.update(id, updatedTracking);
    }

    @DELETE
    @Path("/{id}")
    public Uni<Boolean> delete(@PathParam("id") Long id) {
        return trackingService.delete(id);
    }
}
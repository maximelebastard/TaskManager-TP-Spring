package fr.istic.taa.taskmanager.web.rest;

import fr.istic.taa.taskmanager.domain.Task;
import fr.istic.taa.taskmanager.service.BaseService;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * A base rest resource
 * @param <Entity>  The entity concerned by the rest resource
 * @param <Service> The service used by the resource
 */
public abstract class RestResource<Entity, Service extends BaseService> {
    /**
     * Logger
     */
    protected static final Logger logger = Logger.getLogger(RestResource.class.getName());

    /**
     * Service to use
     */
    protected final Service service;

    /**
     * Initializes the service
     * @param service The service
     */
    public RestResource(Service service) {
        this.service = service;
    }

    /**
     * Gets all the entities
     * @return The entities
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Entity> getAll(){
        return service.findAll();
    }

    /**
     * Gets one entity from an id
     * @param id The id to fetch
     * @return The entity if found
     */
    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOne(@PathParam("id") Long id){
        try{
            Entity entity = (Entity) service.findOneById(id);

            return Response.ok(entity, MediaType.APPLICATION_JSON).build();
        } catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    /**
     * Creates an entity
     * @return Entity created
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    //@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response post(Entity entity){
        service.create(entity);
        return Response.status(Response.Status.CREATED).entity(entity).build();
    }

    /**
     * Updates an entity
     * @param id The id of the entity to update
     * @return The updated entity
     */
    @POST
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postOne(@PathParam("id") Long id, Entity entity){
        try {
            service.update(id, entity);
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Long id){
        try {
            service.removeOneById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

}
package fr.istic.taa.taskmanager.controller;

import fr.istic.taa.taskmanager.service.BaseService;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.logging.Logger;

/**
 * A base rest resource
 * @param <Entity>  The entity concerned by the rest resource
 * @param <Service> The service used by the resource
 */
public abstract class RestController<Entity, Service extends BaseService> {
    /**
     * Logger
     */
    protected static final Logger logger = Logger.getLogger(RestController.class.getName());

    /**
     * Service to use
     */
    protected Service service;

    public RestController(Service service) {
        this.service = service;
    }

    /**
     * Gets all the entities
     * @return The entities
     */
    @RequestMapping
    public @ResponseBody List<Entity> getAll(){
        Iterable<Entity> all = this.service.findAll();
        return Lists.newArrayList(all);
    }

    /**
     * Gets one entity from an id
     * @param id The id to fetch
     * @return The entity if found
     */
    /*@RequestMapping(
            value = "/{id}",
            method= RequestMethod.GET,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Response getOne(@PathParam("id") Long id){
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
    /*@RequestMapping(
            value = "/",
            method= RequestMethod.POST,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Response post(Entity entity){
        service.create(entity);
        return Response.status(Response.Status.CREATED).entity(entity).build();
    }

    /**
     * Updates an entity
     * @param id The id of the entity to update
     * @return The updated entity
     */
    /*@RequestMapping(
            value = "/{id}",
            method= RequestMethod.POST,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Response postOne(@PathParam("id") Long id, Entity entity){
        try {
            service.update(id, entity);
            return Response.status(Response.Status.OK).entity(entity).build();
        } catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @RequestMapping(
            value = "/{id}",
            method= RequestMethod.DELETE,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Response remove(@PathParam("id") Long id){
        try {
            service.removeOneById(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch(EntityNotFoundException e){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }*/

}
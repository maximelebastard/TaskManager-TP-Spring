package fr.istic.taa.taskmanager.rest;

import fr.istic.taa.taskmanager.service.BaseService;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
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
    protected Service service;

    public RestResource(Service service) {
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
    @RequestMapping(
            value = "/{id}",
            method= RequestMethod.GET,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Entity getOne(@PathParam("id") Long id, HttpServletResponse response){
        try{
            Entity entity = (Entity) service.findOneById(id);
            return entity;
        } catch(EntityNotFoundException e){
            response.setStatus(404);
            return null;
        }
    }

    /**
     * Creates an entity
     * @return Entity created
     */
    @RequestMapping(
            value = "/",
            method= RequestMethod.POST,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Entity post(Entity entity, HttpServletResponse response){
        service.create(entity);
        response.setStatus(201);
        return entity;
    }

    /**
     * Updates an entity
     * @param id The id of the entity to update
     * @return The updated entity
     */
    @RequestMapping(
            value = "/{id}",
            method= RequestMethod.POST,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Entity postOne(@PathParam("id") Long id, Entity entity, HttpServletResponse response){
        try {
            service.update(id, entity);
            return entity;
        } catch(EntityNotFoundException e){
            response.setStatus(404);
            return null;
        }
    }

    @RequestMapping(
            value = "/{id}",
            method= RequestMethod.DELETE,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    public @ResponseBody Entity remove(@PathParam("id") Long id, HttpServletResponse response){
        try {
            service.removeOneById(id);
            response.setStatus(204);
        } catch(EntityNotFoundException e){
            response.setStatus(404);
        }
        return null;
    }

}
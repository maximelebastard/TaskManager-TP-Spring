package fr.istic.taa.taskmanager.rest;

import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import fr.istic.taa.taskmanager.service.BaseService;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
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
    @RequestMapping(
            method= RequestMethod.GET,
            produces = {MediaType.APPLICATION_JSON}
    )
    @ApiOperation(value = "Gets all the objects", responseContainer = "List")
    @ApiResponse(code = 200, message = "All the objects")
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
            produces = {MediaType.APPLICATION_JSON}
    )
    @ApiOperation(value = "Gets one object from its id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "One object if found"),
            @ApiResponse(code = 404, message = "Object with this id not found")
    })
    public @ResponseBody Entity getOne(
            @ApiParam(value = "Id of the object", required = true)
            @PathParam("id")
            Long id,
            HttpServletResponse response){
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
            method= RequestMethod.POST,
            consumes={MediaType.APPLICATION_JSON},
            produces = {MediaType.APPLICATION_JSON}
    )
    @ApiOperation(value = "Creates an object")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Object created"),
            @ApiResponse(code = 400, message = "Provided fields are incorrects")
    })
    public @ResponseBody Entity post(
            @ApiParam(value = "New values of the object", required = true)
            @RequestBody
            Entity entity,
            HttpServletResponse response){
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
    @ApiOperation(value = "Updates an object")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Object updated"),
            @ApiResponse(code = 400, message = "Provided fields are incorrects"),
            @ApiResponse(code = 404, message = "Cannot find an object with this id")
    })
    public @ResponseBody Entity postOne(
            @PathVariable("id")
            @ApiParam(value = "Id of the object", required = true)
            Long id,
            @ApiParam(value = "New values of the object", required = true)
            Entity entity,
            HttpServletResponse response){
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
            produces = {MediaType.APPLICATION_JSON}
    )
    @ApiOperation(value = "Deletes an object")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Object deleted"),
            @ApiResponse(code = 404, message = "Cannot find an object with this id")
    })
    public @ResponseBody Entity remove(
            @ApiParam(value = "Id of the object", required = true)
            @PathVariable("id") Long id,
            HttpServletResponse response){
        try {
            service.removeOneById(id);
            response.setStatus(204);
        } catch(EntityNotFoundException e){
            response.setStatus(404);
        }
        return null;
    }

}
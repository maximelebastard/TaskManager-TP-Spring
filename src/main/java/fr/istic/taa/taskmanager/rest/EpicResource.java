package fr.istic.taa.taskmanager.rest;

import com.wordnik.swagger.annotations.*;
import fr.istic.taa.taskmanager.domain.Epic;
import fr.istic.taa.taskmanager.service.EpicService;
import fr.istic.taa.taskmanager.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by maxime
 */
@Controller
@RequestMapping("/api/epic")
@Api(value = "epic")
public class EpicResource extends RestResource<Epic, EpicService> {

    @Autowired
    public EpicResource(EpicService service) {
        super(service);
    }

    @Override
    @ApiOperation(value = "Gets all the epics", responseContainer = "List", response = Epic.class)
    @ApiResponse(code = 200, message = "All the epics")
    public List<Epic> getAll() {
        return super.getAll();
    }

    @Override
    @ApiOperation(value = "Gets one epic by its ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "The epic"),
            @ApiResponse(code = 404, message = "No epic with this id")
    })
    public Epic getOne(@ApiParam(value = "Epic id", required = true) Long id, HttpServletResponse response) {
        return super.getOne(id, response);
    }

    @Override
    @ApiOperation(value = "Creates a new epic")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Epic has been created"),
            @ApiResponse(code = 400, message = "Provided fields are incorrects")
    })
    public Epic post(@ApiParam(value = "The new epic", required = true) Epic story, HttpServletResponse response) {
        return super.post(story, response);
    }

    @Override
    @ApiOperation(value = "Updates an epic")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Epic updated successfully"),
            @ApiResponse(code = 400, message = "Provided fields are incorrects"),
            @ApiResponse(code = 404, message = "Cannot find an epic with this id")
    })
    public Epic postOne(@ApiParam(value = "Id of the epic to update", required = true) Long id, @ApiParam(value = "New epic values", required = true) Epic story, HttpServletResponse response) {
        return super.postOne(id, story, response);
    }

    @Override
    @ApiOperation(value = "Deletes an epic")
    @ApiResponses({
            @ApiResponse(code = 204, message = "Epic deleted"),
            @ApiResponse(code = 404, message = "Cannot find an epic with this id")
    })
    public Epic remove(@ApiParam(value = "Id of the epic to delete", required = true) Long id, HttpServletResponse response) {
        return super.remove(id, response);
    }
}
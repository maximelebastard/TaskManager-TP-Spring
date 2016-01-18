package fr.istic.taa.taskmanager.domain;

import lombok.*;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.Serializable;

/**
 * Represents a task
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@NamedQueries({
    @NamedQuery(name="Task.unachievedTasks", query = "SELECT t FROM Task t WHERE t.done=false"),
    @NamedQuery(name="Task.achievedTasks", query = "SELECT t FROM Task t WHERE t.done=true")
})
public class Task extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @FormParam("summary")
    private String summary;

    @Getter
    @Setter
    @FormParam("description")
    private String description;

    @Getter
    @Setter
    @FormParam("timeRequiredInHours")
    private Integer timeRequiredInHours;

    @Getter
    @Setter
    @FormParam("timeSpentInHours")
    private Integer timeSpentInHours;

    @Getter
    @Setter
    @FormParam("done")
    private boolean done;

    @Getter
    @Setter
    @ManyToOne
    @FormParam("story")
    private Story story;

    @Getter
    @Setter
    @ManyToOne
    @FormParam("sprint")
    private Sprint sprint;

    @Getter
    @Setter
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @FormParam("worker")
    private User worker;
}

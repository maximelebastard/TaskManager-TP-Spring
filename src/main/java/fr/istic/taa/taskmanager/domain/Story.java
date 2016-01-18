package fr.istic.taa.taskmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;

/**
 * Represents an agile story
 */
@Entity
@DiscriminatorValue("Story")
@NoArgsConstructor
@ToString
public class Story extends UserFeatureRequest implements Serializable {

    @Builder
    public Story(Long id, String summary, String description, User asker, List<Task> tasks, Epic epic, Sprint sprint) {
        super(id, summary, description, asker);
        this.setTasks(tasks);
        this.setEpic(epic);
        this.setSprint(sprint);
    }

    @Getter
    @Setter
    @OneToMany(
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "story",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}
    )
    @FormParam("tasks")
    private List<Task> tasks;

    @Getter
    @Setter
    @ManyToOne
    @FormParam("epic")
    @JsonIgnore
    private Epic epic;

    @Getter
    @Setter
    @ManyToOne
    @FormParam("sprint")
    @JsonIgnore
    private Sprint sprint;
}

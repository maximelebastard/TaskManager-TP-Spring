package fr.istic.taa.taskmanager.domain;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Story extends UserFeatureRequest implements Serializable {

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
    private Epic epic;

    @Getter
    @Setter
    @ManyToOne
    @FormParam("sprint")
    private Sprint sprint;
}

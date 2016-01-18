package fr.istic.taa.taskmanager.domain;

import lombok.*;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;

/**
 * Represents an agile epic
 */
@Entity
@DiscriminatorValue("Epic")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Epic extends UserFeatureRequest implements Serializable {

    @Getter
    @Setter
    @OneToMany(
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "epic",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}
    )
    @FormParam("stories")
    private List<Story> stories;
}

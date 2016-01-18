package fr.istic.taa.taskmanager.domain;

import lombok.*;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.util.List;

/**
 * Represents a feedback from the User, which description etc...
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="UFR_TYPE")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public abstract class UserFeatureRequest extends BaseEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

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
    @ManyToOne(
            fetch = FetchType.LAZY
    )
    @FormParam("asker")
    private User asker;
}

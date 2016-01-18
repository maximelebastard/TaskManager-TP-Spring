package fr.istic.taa.taskmanager.domain;

import lombok.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.ws.rs.FormParam;
import java.io.Serializable;
import java.util.List;

/**
 * Represents an agile sprint
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sprint extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    @FormParam("name")
    private String name;

    @Getter
    @Setter
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @FormParam("start_date")
    private DateTime startDate;

    @Getter
    @Setter
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    @FormParam("due_date")
    private DateTime dueDate;

    @Getter
    @Setter
    @OneToMany(
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "sprint",
            cascade = {CascadeType.REMOVE, CascadeType.PERSIST}
    )
    @FormParam("stories")
    private List<Story> stories;
}

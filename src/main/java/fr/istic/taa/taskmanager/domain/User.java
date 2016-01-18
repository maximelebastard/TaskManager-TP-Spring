package fr.istic.taa.taskmanager.domain;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.ws.rs.FormParam;

/**
 * Represents a software user
 */
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User extends BaseEntity {

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    @FormParam("firstname")
    private String firstname;

    @Getter
    @Setter
    @FormParam("lastname")
    private String lastname;
}

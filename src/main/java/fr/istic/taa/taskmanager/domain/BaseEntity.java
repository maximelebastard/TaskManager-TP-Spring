package fr.istic.taa.taskmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base Entity
 */
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public abstract class BaseEntity {
}

package by.megatrack.models.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks_queues")
public class TasksQueue {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "queue_id")
    private UUID queueID;

    @Column(name = "title", nullable = false, length = 15)
    @JsonProperty("queue_title")
    private String title;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
}
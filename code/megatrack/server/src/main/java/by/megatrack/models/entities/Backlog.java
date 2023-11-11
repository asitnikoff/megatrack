package by.megatrack.models.entities;

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
@Table(name = "backlogs")
public class Backlog {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "backlog_id")
    private UUID backlogID;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "queue_id", referencedColumnName = "queue_id", nullable = false)
    private TasksQueue queue;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;
}

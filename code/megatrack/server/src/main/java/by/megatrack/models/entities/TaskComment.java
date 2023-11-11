package by.megatrack.models.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks_comments")
public class TaskComment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "comment_id")
    private UUID commentID;

    @Column(name = "text", nullable = false)
    private String text;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = User.class)
    @JoinColumn(name = "author_id", referencedColumnName = "user_id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Task.class)
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task task;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;
}

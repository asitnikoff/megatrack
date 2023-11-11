package by.megatrack.models.entities;

import by.megatrack.models.enums.TaskStatus;
import by.megatrack.utils.converters.TaskStatusConverter;
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
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id")
    private UUID taskID;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "story_point")
    private Double storyPoint;

    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = User.class
    )
    @JoinColumn(name = "author_id", referencedColumnName = "user_id", nullable = false)
    private User author;

    @ManyToOne(
            cascade = CascadeType.ALL,
            targetEntity = User.class
    )
    @JoinColumn(name = "assignee_id", referencedColumnName = "user_id")
    private User assignee;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private OffsetDateTime createdAt;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    @Column(name = "updated_at", nullable = false)
    @UpdateTimestamp
    private OffsetDateTime updatedAt;

    @Column(name = "status", nullable = false, columnDefinition = "TEXT")
    @Convert(converter = TaskStatusConverter.class)
    private TaskStatus status;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = TasksQueue.class)
    @JoinColumn(name = "queue_id", referencedColumnName = "queue_id", nullable = false)
    private TasksQueue tasksQueue;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Poker.class)
    @JoinColumn(name = "poker_id", referencedColumnName = "poker_id")
    private Poker poker;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Backlog.class)
    @JoinColumn(name = "backlog_id", referencedColumnName = "backlog_id")
    private Backlog backlog;
}
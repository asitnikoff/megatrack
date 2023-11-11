package by.megatrack.utils.converters;

import by.megatrack.models.enums.TaskStatus;
import jakarta.persistence.AttributeConverter;

public class TaskStatusConverter implements AttributeConverter<TaskStatus, String> {
    @Override
    public String convertToDatabaseColumn(TaskStatus taskStatus) {
        return switch (taskStatus) {
            case OPEN -> "open";
            case IN_WORK -> "in_work";
            case REVIEW -> "review";
            case TESTING -> "testing";
            case READY_FOR_RC -> "ready_for_rc";
            case CLOSED -> "closed";
        };
    }

    @Override
    public TaskStatus convertToEntityAttribute(String taskStatus) {
        return switch (taskStatus) {
            case "open" -> TaskStatus.OPEN;
            case "in_work" -> TaskStatus.IN_WORK;
            case "review" -> TaskStatus.REVIEW;
            case "testing" -> TaskStatus.TESTING;
            case "ready_for_rc" -> TaskStatus.READY_FOR_RC;
            case "closed" -> TaskStatus.CLOSED;
            default -> throw new IllegalStateException("Unexpected value: " + taskStatus);
        };
    }
}

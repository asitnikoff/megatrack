package by.megatrack.utils.converters;

import by.megatrack.models.enums.UserRole;
import jakarta.persistence.AttributeConverter;

public class UserRoleConverter implements AttributeConverter<UserRole, String> {
    @Override
    public String convertToDatabaseColumn(UserRole userRole) {
        return switch (userRole) {
            case ADMIN -> "admin";
            case COMMON -> "common";
        };
    }

    @Override
    public UserRole convertToEntityAttribute(String userRole) {
        return switch (userRole) {
            case "admin" -> UserRole.ADMIN;
            case "common" -> UserRole.COMMON;
            default -> throw new IllegalStateException("Unexpected value: " + userRole);
        };
    }
}


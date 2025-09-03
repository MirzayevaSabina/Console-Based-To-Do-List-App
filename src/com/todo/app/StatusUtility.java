package com.todo.app;

public enum StatusUtility {
    NEW("New", 1),
    IN_PROGRESS("In progress", 2),
    COMPLETED("Completed", 3),
    CANCELLED("Cancelled", 4);

    private final String description;
    private final int value;

    StatusUtility(String description, int value) {
        this.description = description;
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public static StatusUtility fromValue(int value) {
        for (StatusUtility status : StatusUtility.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid status value: " + value);
    }
}
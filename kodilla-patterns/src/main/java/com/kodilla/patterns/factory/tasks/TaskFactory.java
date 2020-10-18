package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

        public static final String FIRST_VARIABLE = "VARIABLE_FIRST";
        public static final String SECOND_VARIABLE = "VARIABLE_SECOND";
        public static final String THIRD_VARIABLE = "VARIABLE_THIRD";

        public final Task makeTask(final String taskClass) {
            switch (taskClass) {
                case FIRST_VARIABLE:
                    return new ShoppingTask("go to the grocery store", "bread", 10);
                case SECOND_VARIABLE:
                    return new PaintingTask("painting walls", "white", "walls in the bedroom");
                case THIRD_VARIABLE:
                    return new DrivingTask("go to the station", "London", "car");
                default:
                    return null;
            }

        }
}
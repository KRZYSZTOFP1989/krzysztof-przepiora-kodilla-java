package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

        public static final String ShoppingTask = "ShoppingTask";
        public static final String PaintingTask = "PaintingTask";
        public static final String DrivingTask = " DrivingTask";

        public final Task makeTask(final String TaskClass) {
            switch (TaskClass) {
                case ShoppingTask:
                    return new ShoppingTask("go to the grocery store", "bread", 10);
                case PaintingTask:
                    return new PaintingTask("painting walls", "white", "walls in the bedroom");
                case DrivingTask:
                    return new DrivingTask("go to the station", "London", "car");
                default:
                    return null;
            }

        }
}
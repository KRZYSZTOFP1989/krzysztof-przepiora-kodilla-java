package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

        public static final String FirstVariable = "FirstVariable";
        public static final String SecondVariable = "SecondVariable";
        public static final String ThirdVariable = "ThirdVariable";

        public final Task makeTask(final String taskClass) {
            switch (taskClass) {
                case FirstVariable:
                    return new ShoppingTask("go to the grocery store", "bread", 10);
                case SecondVariable :
                    return new PaintingTask("painting walls", "white", "walls in the bedroom");
                case ThirdVariable:
                    return new DrivingTask("go to the station", "London", "car");
                default:
                    return null;
            }

        }
}
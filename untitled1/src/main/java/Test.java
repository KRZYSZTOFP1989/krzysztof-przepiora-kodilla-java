public class Calculations {

    public double calculateBestAverage(Map<Student, Grades> scores) {

        Student student1 = new Student("Jan", "Kowalski");
        Student student2 = new Student("Magda", "Nowak", "EN");
        Student student3 = new Student("Kamila", "Los", "PL");

        Grades grades1 = new Grades(2, 3, 4, 5, 1);
        Grades grades2 = new Grades(2, 5, 5, 5, 5);
        Grades grades3 = new Grades(2, 3, 4, 5, 5, 5, 2);

        HashMap<Student, Grades> scores = new HashMap<Student, Grades>();

        scores.put(student1, grades1);
        scores.put(student2, grades2);
        scores.put(student3, grades3);
        return scores;

        public double averageAssessment () {
            return (double) (english + polish + plasticity + maths + history + geography + biology + physicaleducation) / 3;

        }

        for (Map.Entry<Student, Grades> entry : scores.entrySet()) {
            System.out.println("Average for student" + " " + entry.getKey() + " is " + entry.getValue().scores());
        }
    }
}
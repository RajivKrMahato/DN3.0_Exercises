public class MVCPatternDemo {
    public static void main(String[] args) {
        
        Student model = retrieveStudentFromDatabase();

      
        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

     
        controller.updateView();

      
        controller.setStudentName("Nitish Kumar");
        controller.setStudentGrade("A");

        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setName("Rajiv Kr Mahato");
        student.setId("232272");
        student.setGrade("B");
        return student;
    }
}

package workingWithAbstraction.studentSystem;

import workingWithAbstraction.studentSystem.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] args) {
        String input = args[0];
        String name = args[1];
        if (input.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                var student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (args[0].equals("Show")) {
            if (repo.containsKey(name)) {
                Student student = repo.get(name);
                StringBuilder sb = new StringBuilder();
                sb.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                   sb.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    sb.append(" Average student.");
                } else {
                   sb.append( " Very nice person.");
                }

                System.out.println(sb.toString());
            }
        }
    }
}

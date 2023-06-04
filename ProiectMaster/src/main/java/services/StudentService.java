package services;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.StudentRepository;

import java.util.List;
@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    public Iterable<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    public Student getStudentById(int studentId) {
        return this.studentRepository.findById(studentId).orElse(null);
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(int studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);
        if (existingStudent == null) {
            return null;
        }

        existingStudent.setName(updatedStudent.getName());
        existingStudent.setUniversity(updatedStudent.getUniversity());
        // Update other properties as needed

        return studentRepository.save(existingStudent);
    }

    public boolean deleteStudent(int studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            return false;
        }

        studentRepository.delete(student);
        return true;
    }
}

package com.app.escola.modules.student_module.services.enrollStudentCourse;

import com.app.escola.data_base.entitys.course_student_entity.Course_student;
import com.app.escola.data_base.entitys.course_student_entity.Course_studentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrollStudentCourseService {
    private Course_studentRepository courseStudentRepository;

    @Autowired
    public EnrollStudentCourseService(Course_studentRepository courseStudentRepository) {
        this.courseStudentRepository = courseStudentRepository;
    }

    public ResponseEntity enrollStudent(Long id_course, Long id_student) {
        try {
            Course_student enroll = new Course_student(id_course, id_student);
            courseStudentRepository.save(enroll);
            return new ResponseEntity<String>("Matricula realizada com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>("Erro ao realizar matricula!", HttpStatus.BAD_REQUEST);
        }
    }
}
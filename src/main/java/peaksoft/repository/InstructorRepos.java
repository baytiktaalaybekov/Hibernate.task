package peaksoft.repository;

import peaksoft.entity.Instructor;

public interface InstructorRepos {
    void saveInstructor(Instructor instructor);
    Instructor updateInstructor(Long idInstructor, Instructor instructor);
    Instructor getInstructorById(Long id);
    String getInstructorByCourseId(Long courseId);

    Instructor deleteInstructorById(Long instructorId);

    void assignInstructorToCourse(Long instructorId,Long courseId);


}

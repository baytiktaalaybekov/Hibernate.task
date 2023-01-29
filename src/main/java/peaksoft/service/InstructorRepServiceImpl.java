package peaksoft.service;

import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepos;
import peaksoft.repository.InstructorRepositoryImpl;

public class InstructorRepServiceImpl implements InstructorRepService{

    InstructorRepos instructorRepos = new InstructorRepositoryImpl();
    @Override
    public boolean saveInstructor(Instructor instructor) {
        instructorRepos.saveInstructor(instructor);
        return false;
    }

    @Override
    public Instructor updateInstructor(Long idInstructor, Instructor instructor) {
        return instructorRepos.updateInstructor(idInstructor,instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepos.getInstructorById(id);
    }

    @Override
    public String getInstructorByCourseId(Long courseId) {
        return instructorRepos.getInstructorByCourseId(courseId);
    }

    @Override
    public Instructor deleteInstructorById(Long instructorId) {
        return instructorRepos.deleteInstructorById(instructorId);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Long courseId) {
        instructorRepos.assignInstructorToCourse(instructorId,courseId);

    }
}

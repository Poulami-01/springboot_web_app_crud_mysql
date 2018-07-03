/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package student_crud_no_rest;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author sourav
 */
public interface StudentRepository extends CrudRepository<Student, Long>
{

    // CRUD Operations on the Student Repository
    @Override
    public Student save(Student s);

    @Override
    public List<Student> findAll();

    public List<Student> findAllById(long id);

    public Student getStudentById(long id);

    public List<Student> findByName(String name);

    public List<Student> findByAge(long age);

    //@Query("select s from Student s where s.age <= ?")
    public List<Student> findByAgeLessThanEqual(long age);

    //@Query("select s from Student s where s.age >= ?")
    public List<Student> findByAgeGreaterThanEqual(long age);

    public default String deleteById(long id)
    {
        try
        {
            delete(this.getStudentById(id));
            return "Student successfully deleted";
        } catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @Transactional
    public default String update(long id, Student s)
    {
        try
        {
            Student old = this.getStudentById(id);
            this.save(s);
            this.delete(old);
            return "Update Successful";
        } catch (Exception e)
        {
            return "Update Failed " + e.getMessage();
        }
    }
}

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

        @Query("SELECT e FROM Employee e WHERE e.name = :name")
    List<Employee> findByName(String name);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    List<Employee> findByDepartmentId(Long departmentId);

   @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain")
    List<Employee> findEmployeesByEmailDomain(@Param("domain") String domain);

       Employee findByEmail(String email);

 Page<Employee> findByNameContaining(String substring, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :departmentName")
    Page<Employee> findEmployeesByDepartmentName(@Param("departmentName") String departmentName, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain")
    Page<Employee> findEmployeesByEmailDomain(@Param("domain") String domain, Pageable pageable);
@Query("SELECT new com.example.employeemanagementsystem.dto.EmployeeDTO(e.id, e.name, e.email) FROM Employee e WHERE e.name = :name")
    List<EmployeeDTO> findByName(@Param("name") String name);
}

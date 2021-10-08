   
package com.cg.sprint.school.administration.repository;
 
import java.util.Date;
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 
import com.cg.sprint.school.administration.model.Complaint;
 
@Repository
public interface ComplaintRepository extends CrudRepository<Complaint, Integer> {


   List<Complaint> findByDate(Date date);

}
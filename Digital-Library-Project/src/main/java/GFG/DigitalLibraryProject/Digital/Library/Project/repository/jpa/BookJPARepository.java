package GFG.DigitalLibraryProject.Digital.Library.Project.repository.jpa;

import GFG.DigitalLibraryProject.Digital.Library.Project.entity.output.BookOutputEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//This is repository because here this is interacting with the database
@Repository
public interface BookJPARepository extends JpaRepository<BookOutputEntity,Long> {
    //We have kept BookOutputEntity because it is linked with the database
}

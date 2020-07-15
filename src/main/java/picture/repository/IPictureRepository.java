package picture.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import picture.model.Picture;

import javax.transaction.Transactional;

@Transactional
public interface IPictureRepository extends PagingAndSortingRepository<Picture,Long> {
    Page<Picture> findAllByFeedbackContaining(String feedback, Pageable pageable);
}

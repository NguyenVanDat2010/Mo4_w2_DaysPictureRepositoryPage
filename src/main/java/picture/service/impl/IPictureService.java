package picture.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import picture.model.Picture;
import picture.service.IGeneralService;

public interface IPictureService extends IGeneralService<Picture> {
//    void updateLike(Long id);
    Page<Picture> findAll(Pageable pageable);
}

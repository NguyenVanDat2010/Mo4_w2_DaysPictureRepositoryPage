package picture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import picture.model.Picture;
import picture.repository.IPictureRepository;

import java.util.List;

public class PictureService implements IPictureService {
    @Autowired
    IPictureRepository pictureRepository;

    @Override
    public Iterable<Picture> findAll() {
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository.findOne(id);
    }

    @Override
    public void save(Picture model) {
        pictureRepository.save(model);
    }

    @Override
    public void remove(Long id) {
        pictureRepository.delete(id);
    }

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return pictureRepository.findAll(pageable);
    }

    //    @Override
//    public void updateLike(Long id) {
//        pictureRepository.updateLike(id);
//    }
}

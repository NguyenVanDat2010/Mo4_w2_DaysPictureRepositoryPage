package picture.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import picture.model.Picture;
import picture.repository.IPictureRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PictureService implements IPictureService {
    @Autowired
    IPictureRepository pictureRepository;

    @Override
    public Iterable<Picture> findAll() {
//        PictureService pictureService = new PictureService();
//        List<Picture> pictures = new ArrayList<>();
//        for (Picture picture:pictureRepository.findAll()){
//            if (pictureService.checkFeedback(picture.getFeedback())){
//                pictures.add(picture);
//            }
//        }
//        return pictures;
        return pictureRepository.findAll();
    }

    @Override
    public Picture findById(Long id) {
        return pictureRepository.findOne(id);
    }

    @Override
    public void save(Picture model) throws Exception {
        PictureService pictureService = new PictureService();
        if (pictureService.checkFeedback(model.getFeedback())){
            pictureRepository.save(model);
        }else {
            throw new Exception("Can't add this feedback: "+model.getAuthor()+", "+model.getFeedback()+", "+ LocalDateTime.now());
        }
    }

    @Override
    public void remove(Long id) {
        pictureRepository.delete(id);
    }

    @Override
    public Page<Picture> findAll(Pageable pageable) {
        return pictureRepository.findAll(pageable);
    }

    public boolean checkFeedback(String feedback){
        ArrayList<String> myString = null;
        String[] myString2={"fuck","damned","Uppy","dirty pig","Fuck you","ass","cunt","porn"};
        for (String str:myString2){
            if (feedback.contains(str)){
                return false;
            }
        }
        return true;
    }
}

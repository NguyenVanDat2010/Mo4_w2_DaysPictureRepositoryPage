package picture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import picture.model.Picture;
import picture.service.impl.IPictureService;

@Controller
@RequestMapping("/pictures")
public class PictureController {
    @Autowired
    private IPictureService pictureService;

    @GetMapping
    public ModelAndView showPicture(@PageableDefault(size = 3,direction = Sort.Direction.ASC,sort = "id")Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("daysPicture");
//        modelAndView.addObject("comment",timeConvert());
        modelAndView.addObject("comment",pictureService.findAll(pageable));
        modelAndView.addObject("picture",new Picture());
        return modelAndView;
    }

    @PostMapping("/save")
    public String savePicture(Picture picture, RedirectAttributes redirectAttributes){
        pictureService.save(picture);
        redirectAttributes.addFlashAttribute("success","Add comment successfully!");
        return "redirect:/pictures";
    }

    @GetMapping("/like/{id}")
    public String likePicture(@PathVariable Long id){
        Picture picture = pictureService.findById(id);
        if (picture!= null){
            pictureService.save(setLikePicture(picture));
            return "redirect:/pictures";
        }else {
            return "error-404";
        }
    }

    public Picture setLikePicture(Picture picture){
        picture.setLikes(picture.getLikes()+1);
        return picture;
    }
}

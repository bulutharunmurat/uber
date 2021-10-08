package uber.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import uber.entity.DriverComments;
import uber.service.CommentService;

import java.util.List;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments/{driverssid}/{comment}")
    public DriverComments saveComment(@PathVariable Long driverssid,
                                      @PathVariable String comment){
        return commentService.saveComment(driverssid, comment);
    }

    @GetMapping("/comments")
    public List<DriverComments> findAll(){
        return commentService.findAll();
    }
}

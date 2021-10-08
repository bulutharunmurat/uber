package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.entity.Driver;
import uber.entity.DriverComments;
import uber.repository.CommentsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentsRepository commentsRepository;
    private final DriverService driverService;

    @Transactional
    public DriverComments saveComment(Long driver_ssid,  String comment){
        DriverComments driverComment = new DriverComments();

        Driver driver = driverService.findBySSID(driver_ssid);

        driverComment.setDriver(driver);
        driverComment.setComment(comment);

        return commentsRepository.save(driverComment);
    }

    public List<DriverComments> findAll(){
        Iterable<DriverComments> driverCommentsIterable = commentsRepository.findAll();

        List<DriverComments> driverComments = new ArrayList<>();

        driverCommentsIterable.iterator().forEachRemaining(driverComments::add);
        return driverComments;
    }
}

package carrental;

import carrental.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    CommentRepository commentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverCarRented_CommentInsert(@Payload CarRented carRented){

        System.out.println("######################################### kakfa Comment" );
        if(carRented.isMe() && "CAR_RENTED".equals(carRented.getProcStatus()) ){
            Comment comment = new Comment();
            comment.setId(carRented.getId());
            comment.setCarNo(carRented.getCarNo());
            comment.setResvrNo(carRented.getResrvNo());
            //comment.setComment(carRented.getC());


            commentRepository.save(comment);


            System.out.println("##### listener PointSaved : " + carRented.toJson());
        }
    }


}

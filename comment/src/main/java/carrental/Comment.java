package carrental;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="comment_table")
public class Comment {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String carNo;
    private String resvrNo;
    private String comment;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getCarNo() {
        return carNo;
    }
    public void setCarNo(String custNo) {
        this.carNo = carNo;
    }

    public String getResvrNo() {
        return resvrNo;
    }
    public void setResvrNo(String custNo) {
        this.resvrNo = resvrNo;
    }

    public String getComment() {
        return comment;
    }
    public void setComment(String point) {
        this.comment = comment;
    }




}

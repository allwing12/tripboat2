package tripboat.tripboat1.Writerfile;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Writer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length=100)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

}
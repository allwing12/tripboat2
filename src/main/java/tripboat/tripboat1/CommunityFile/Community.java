package tripboat.tripboat1.CommunityFile;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;
import tripboat.tripboat1.CommentFile.Comment;
import tripboat.tripboat1.User.Domain.SiteUser;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 3000)
    @NotNull
    private String content;

    private String subject;

    @Column(length = 20)
    private String region;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Comment> commentList;

    private LocalDateTime modifyDate;

    @ManyToOne
    private SiteUser author;

}

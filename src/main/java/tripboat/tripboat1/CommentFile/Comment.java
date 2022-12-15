package tripboat.tripboat1.CommentFile;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;
import tripboat.tripboat1.CommunityFile.Community;
import tripboat.tripboat1.User.Domain.SiteUser;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    @NotNull
    private String content;

    private LocalDateTime createDate;

    @ManyToOne
    private Community community;

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;
}

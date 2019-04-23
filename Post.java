package kr.hs.dgsw.web_0422_homework.Domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    // select 1 * from post where userId=my_id

    private String title;

    @Column(columnDefinition = "TEXT") //긴글 쓰기위해서, 다른언어에서는 LOB라고한다.
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    //Post의 ID랑 이름이 같은 것을 전부 가져옴. DB에 넣진 않지만 데이터를 읽어오고자 할때 사용, orphan=자신의 상위의 값이 없어지면
    // 알아서 지워짐.(원래는 테이블에 저장됨)

    private List<Attachment> pictures;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime created;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    private LocalDateTime updated;
}

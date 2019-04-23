package kr.hs.dgsw.web_0422_homework.Domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String storedPath; //실제로 파일의 위치를 읽어서 로컬로 읽어 들이기 위함

    private Long postId;
}

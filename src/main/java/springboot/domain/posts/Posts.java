package springboot.domain.posts;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import springboot.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter //(6) 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor //(5) 기본 생성자 자동 추가
@Entity //(1) 테이블과 링크될 클래스임을 나타냅니다.
public class Posts extends BaseTimeEntity {

    @Id //(2) 해당 테이블의 PK필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //(3) PK의 생성 규칙을 나타냅니다.
    private Long id;

    @Column(length=500,nullable=false) //(4) 테이블의 칼럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼이 됩니다.
    private String title;

    @Column(columnDefinition="TEXT",nullable=false)
    private String content;

    private String author;

    @Builder //(7) 해당 클래스 빌더 패턴 클래스를 생성성    public Posts(String title, String content,String author){
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title=title;
        this.content=content;
    }
}


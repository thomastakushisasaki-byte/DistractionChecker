package distraction_checker.demo.entity; // ここは自分のパッケージ名に合わせてね

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class DistractionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String cause;    // 邪魔した原因
    private String category; // カテゴリ
    private Integer minutes; // 奪われた時間

    private LocalDateTime createdAt = LocalDateTime.now();
}
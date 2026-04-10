package distraction_checker.demo.repository;

import distraction_checker.demo.entity.DistractionLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistractionRepository extends JpaRepository<DistractionLog, Long> {
    // これだけで、保存・削除・検索などの基本機能が全部自動で備わります！
}
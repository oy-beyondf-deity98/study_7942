package lab.spring.jpa.typing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MemoRepository  extends JpaRepository<Memo, Long>{

}

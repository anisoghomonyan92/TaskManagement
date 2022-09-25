package am.itspace.taskmanagement.repository;

import am.itspace.taskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositury extends JpaRepository<Task,Integer> {
}

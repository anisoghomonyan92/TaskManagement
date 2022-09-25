package am.itspace.taskmanagement.controller;

import am.itspace.taskmanagement.entity.Task;
import am.itspace.taskmanagement.entity.User;
import am.itspace.taskmanagement.repository.TaskRepositury;
import am.itspace.taskmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    private TaskRepositury taskRepositury;
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/tasks")
    public String task(ModelMap modelMap) {
        List<Task> all = taskRepositury.findAll();
        modelMap.addAttribute("tasks", all);
        return "tasks";
    }

    @GetMapping(value = "/tasks/add")
    public String addTasksPage(ModelMap modelMap) {
        List<User> users = userRepository.findAll();
        modelMap.addAttribute("users", users);
        return "addTask";
    }

    @PostMapping(value = "/tasks/add")
    public String addTask(@ModelAttribute Task task) {
        if(task.getUser() != null && task.getUser().getId()==0){
            task.setUser(null);
        }
        taskRepositury.save(task);
        return "redirect:/tasks";
    }
}

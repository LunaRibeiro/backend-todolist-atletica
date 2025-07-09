package backend.todolist_atletica.director.domain.entity;

import backend.todolist_atletica.enums.Role;
import backend.todolist_atletica.task.domain.entity.Task;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active = true;

    @ManyToMany
    private Set<Task> tasks = new HashSet<>();
}

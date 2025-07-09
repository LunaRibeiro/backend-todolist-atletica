package backend.todolist_atletica.task.domain.entity;

import backend.todolist_atletica.director.domain.entity.Director;
import backend.todolist_atletica.enums.Role;
import backend.todolist_atletica.enums.Status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status = Status.PENDENTE;

    private String driveLink;

    @ManyToOne
    private Director responsible;

    private LocalDateTime createdAt = LocalDateTime.now();

    @ElementCollection(targetClass = Role.class)
    @Enumerated(EnumType.STRING)
    private Set<Role> targetRoles = new HashSet<>();

    @ManyToMany
    private Set<Director> assignedUsers = new HashSet<>();
}

package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firsName;
    @Column (name = "last_name")
    private String lastName;

    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    private int phoneNumber;
    @ManyToMany
    @JoinColumn(name = "course")
    private List<Course> courses;













    public Instructor(String firsName, String lastName, String email, int phoneNumber) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}

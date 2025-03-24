package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DynamicUpdate
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private String email;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "User")
    private List<BorrowingDetails> borrowingDetails;


}

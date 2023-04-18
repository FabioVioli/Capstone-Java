package com.Capstone.auth.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.Capstone.main.entities.Coaching;
import com.Capstone.main.entities.DM;
import com.Capstone.main.entities.LFP;
import com.Capstone.main.entities.Tutorial;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "username"),
		@UniqueConstraint(columnNames = "email") })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();
    
    
    @OneToOne
    private Coaching coaching;
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Tutorial> tutorialList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<LFP> lfpList = new ArrayList<>();
    
    @OneToMany(cascade = CascadeType.PERSIST)
    private List<DM> dmList = new ArrayList<>();

	@Override
	public String toString() {
		return "User [id=" + id  + ", username=" + username + ", email=" + email + ", roles="
				+ roles + "]";
	}
    
    
}

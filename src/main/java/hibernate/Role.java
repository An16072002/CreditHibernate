package hibernate;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;



import lombok.Data;

@Data
@Entity
@Table(name = "role")
public class Role {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    @Column
	    private String name;
	     
	    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	    private Set<User> users;
}

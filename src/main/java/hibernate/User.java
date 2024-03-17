package hibernate;

import java.util.Date;
import java.util.Set;
 
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
 
import lombok.Data;





@Data
@Entity(name = "User")
@Table(name = "user")
public class User {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	 	@Column(name="id")
	    private Long id;
	 
	    @Column(name="fullname")
	    private String fullname;
	 
	    @Column(name="username",nullable = false, length = 255, unique = true)
	    private String username;
	 
	    @Column(name="password",nullable = false)
	    private String password;
	 
	    @Column(name = "created_at")
	    @Temporal(value = TemporalType.TIMESTAMP)
	    private Date createdAt;
	 
	    @Column(name = "modified_at")
	    @Temporal(value = TemporalType.TIMESTAMP)
	    private Date modifiedAt;
	 
	    
	    @Transient
	    private String additionalPropery;
	     
	    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	    private UserProfile userProfile;
	 
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	    @OrderBy("title")
	    private Set<Post> posts;
	     
	    
	    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	    @JoinTable(name = "user_roles", 
	        joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
	        inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
	    @OrderBy("name")
	    private Set<Role> roles;   
	    
	    public String toString() {
			return "\nFullname: "+fullname+
					"\nMaNguoiDung: "+id+
					"\nCode: "+password;
		}
}



package hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
import lombok.Data;

@Data
@Entity
@Table(name="post")
public class Post {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	 
	    private String title;
	 
	    private String content;
	 
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "user_id", nullable = false, 
	        foreignKey = @ForeignKey(name = "fk_post_user"))
	    private User user;
	 
	    @ManyToOne(fetch = FetchType.EAGER)
	    @JoinColumn(name = "category_id", nullable = false, 
	        foreignKey = @ForeignKey(name = "fk_post_category"))
	    private Category category;
}

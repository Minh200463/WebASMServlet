package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the User_TB database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name="User.findByKeyWord",
query="SELECT DISTINCT u FROM User_TB u WHERE u.username LIKE :keyword"),
	@NamedQuery(name="User.findOne",
query="SELECT o FROM User_TB o WHERE o.username =:us AND o.password =:pw"),
		
})
@Entity
@NamedQuery(name="User_TB.findAll", query="SELECT u FROM User_TB u")
public class User_TB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="Admin")
	private boolean admin;

	@Column(name="Email")
	private String email;

	@Column(name="Password")
	private String password;

	@Column(name="Username")
	private String username;

	//bi-directional many-to-one association to Favorite_TB
	@OneToMany(mappedBy="userTb")
	private List<Favorite_TB> favoriteTbs;

	//bi-directional many-to-one association to Share_TB
	@OneToMany(mappedBy="userTb")
	private List<Share_TB> shareTbs;

	public User_TB() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Favorite_TB> getFavoriteTbs() {
		return this.favoriteTbs;
	}

	public void setFavoriteTbs(List<Favorite_TB> favoriteTbs) {
		this.favoriteTbs = favoriteTbs;
	}

	public Favorite_TB addFavoriteTb(Favorite_TB favoriteTb) {
		getFavoriteTbs().add(favoriteTb);
		favoriteTb.setUserTb(this);

		return favoriteTb;
	}

	public Favorite_TB removeFavoriteTb(Favorite_TB favoriteTb) {
		getFavoriteTbs().remove(favoriteTb);
		favoriteTb.setUserTb(null);

		return favoriteTb;
	}

	public List<Share_TB> getShareTbs() {
		return this.shareTbs;
	}

	public void setShareTbs(List<Share_TB> shareTbs) {
		this.shareTbs = shareTbs;
	}

	public Share_TB addShareTb(Share_TB shareTb) {
		getShareTbs().add(shareTb);
		shareTb.setUserTb(this);

		return shareTb;
	}

	public Share_TB removeShareTb(Share_TB shareTb) {
		getShareTbs().remove(shareTb);
		shareTb.setUserTb(null);

		return shareTb;
	}

}
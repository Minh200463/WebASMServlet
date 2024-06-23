package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Favorite_TB database table.
 * 
 */


@Entity
@NamedQuery(name="Favorite_TB.findAll", query="SELECT f FROM Favorite_TB f")
public class Favorite_TB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="LikeDate")
	@Temporal(TemporalType.DATE)
	private Date likeDate;

	//bi-directional many-to-one association to User_TB
	@ManyToOne
	@JoinColumn(name="ID_User")
	private User_TB userTb;

	//bi-directional many-to-one association to Video_TB
	@ManyToOne
	@JoinColumn(name="ID_Video")
	private Video_TB videoTb;

	public Favorite_TB() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLikeDate() {
		return this.likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public User_TB getUserTb() {
		return this.userTb;
	}

	public void setUserTb(User_TB userTb) {
		this.userTb = userTb;
	}

	public Video_TB getVideoTb() {
		return this.videoTb;
	}

	public void setVideoTb(Video_TB videoTb) {
		this.videoTb = videoTb;
	}

}
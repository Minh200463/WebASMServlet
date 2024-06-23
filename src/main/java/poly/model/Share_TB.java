package poly.model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the Share_TB database table.
 * 
 */
@Entity
@NamedQuery(name="Share_TB.findAll", query="SELECT s FROM Share_TB s")
public class Share_TB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="Emails")
	private String emails;

	@Column(name="ShareDate")
	@Temporal(TemporalType.DATE)
	private Date shareDate;

	//bi-directional many-to-one association to User_TB
	@ManyToOne
	@JoinColumn(name="ID_User")
	private User_TB userTb;

	//bi-directional many-to-one association to Video_TB
	@ManyToOne
	@JoinColumn(name="ID_Video")
	private Video_TB videoTb;

	public Share_TB() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmails() {
		return this.emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Date getShareDate() {
		return this.shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
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
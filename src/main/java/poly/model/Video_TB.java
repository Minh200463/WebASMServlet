package poly.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;

/**
 * The persistent class for the Video_TB database table.
 * 
 */

@NamedQueries({
		@NamedQuery(name = "Video.findByKeyWord", query = "SELECT DISTINCT v FROM Video_TB v WHERE v.tittle LIKE :keyword OR v.description LIKE :keyword OR v.poster LIKE :keyword"),
		@NamedQuery(name = "Video.findByUser", query = "SELECT f.videoTb FROM Favorite_TB f WHERE f.userTb.id =:id"),
		@NamedQuery(name = "Video.findPage", query = "SELECT v FROM Video_TB v ORDER BY v.id") })

@NamedNativeQueries({
		@NamedNativeQuery(name = "Video.random4", query = "SELECT TOP 4 * FROM Video_TB ORDER BY NEWID()", resultClass = Video_TB.class),
		@NamedNativeQuery(name = "Video.random6", query = "SELECT TOP 6 * FROM Video_TB ORDER BY NEWID()", resultClass = Video_TB.class),
		@NamedNativeQuery(name = "Video.videodesc", query = "SELECT * FROM Video_TB ORDER BY views DESC", resultClass = Video_TB.class), 
		@NamedNativeQuery(name = "Video.findpage", query = "SELECT * FROM Video_TB ORDER BY ID OFFSET :offset ROWS FETCH NEXT :limit ROWS ONLY", resultClass = Video_TB.class)		
})
		
@Entity
@NamedQuery(name = "Video_TB.findAll", query = "SELECT v FROM Video_TB v")
public class Video_TB implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "Active")
	private boolean active;

	@Column(name = "Description")
	private String description;

	@Column(name = "Href")
	private String href;

	@Column(name = "Poster")
	private String poster;

	@Column(name = "Tittle")
	private String tittle;

	@Column(name = "Views")
	private int views;

	// bi-directional many-to-one association to Favorite_TB
	@OneToMany(mappedBy = "videoTb")
	private List<Favorite_TB> favoriteTbs;

	// bi-directional many-to-one association to Share_TB
	@OneToMany(mappedBy = "videoTb")
	private List<Share_TB> shareTbs;

	public Video_TB() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean getActive() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getHref() {
		return this.href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPoster() {
		return this.poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public int getViews() {
		return this.views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public List<Favorite_TB> getFavoriteTbs() {
		return this.favoriteTbs;
	}

	public void setFavoriteTbs(List<Favorite_TB> favoriteTbs) {
		this.favoriteTbs = favoriteTbs;
	}

	public Favorite_TB addFavoriteTb(Favorite_TB favoriteTb) {
		getFavoriteTbs().add(favoriteTb);
		favoriteTb.setVideoTb(this);

		return favoriteTb;
	}

	public Favorite_TB removeFavoriteTb(Favorite_TB favoriteTb) {
		getFavoriteTbs().remove(favoriteTb);
		favoriteTb.setVideoTb(null);

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
		shareTb.setVideoTb(this);

		return shareTb;
	}

	public Share_TB removeShareTb(Share_TB shareTb) {
		getShareTbs().remove(shareTb);
		shareTb.setVideoTb(null);

		return shareTb;
	}

}
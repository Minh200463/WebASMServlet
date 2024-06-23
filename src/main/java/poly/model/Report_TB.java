package poly.model;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "Report.favoriteByYear", procedureName = "[spFavoriteByYear]", parameters = {
@StoredProcedureParameter(name = "Year", type = Integer.class, mode = ParameterMode.IN) }, resultClasses = {
						Report_TB.class })
})
/**
 * Entity implementation class for Entity: Report_TB
 *
 */
@Entity

public class Report_TB implements Serializable {
	@Id
	private String tittle;
	@Temporal(TemporalType.DATE)
	private Date newest;
	@Temporal(TemporalType.DATE)
	private Date oldest;
	private Long likecount;
	private Long views;
	
	private static final long serialVersionUID = 1L;

	public Report_TB() {
		super();
	}   
	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}   
	public Date getNewest() {
		return this.newest;
	}

	public void setNewest(Date newest) {
		this.newest = newest;
	}   
	public Date getOldest() {
		return this.oldest;
	}

	public void setOldest(Date oldest) {
		this.oldest = oldest;
	}
	public Long getLikecount() {
		return likecount;
	}
	public void setLikecount(Long likecount) {
		this.likecount = likecount;
	}
	public Long getViews() {
		return views;
	}
	public void setViews(Long views) {
		this.views = views;
	}   

   
}

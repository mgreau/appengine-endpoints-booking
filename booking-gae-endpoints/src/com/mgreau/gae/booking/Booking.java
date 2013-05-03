package com.mgreau.gae.booking;

import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.google.appengine.api.users.User;

@Entity
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
    
	private User user;
	
	private Long hotelId;

	@Temporal(TemporalType.DATE) 
    private Date checkinDate;
    
    @Temporal(TemporalType.DATE)
    private Date checkoutDate;
    
    private boolean smoking;
    private int beds;
    
    public Booking() {
    }

   
    public Integer getTotal() {
        return new Integer(2);//hotel.getPrice().multiply( new BigDecimal( getNights() ) );
    }

    public int getNights() {
        return (int) ( checkoutDate.getTime() - checkinDate.getTime() ) / 1000 / 60 / 60 / 24;
    }

    public String getDescription() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        return hotelId==null ? null : 
            ", " + df.format( checkinDate ) + 
            " to " + df.format( checkoutDate );
    }

    public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getHotelId() {
		return hotelId;
	}


	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String toString() {
        return "Booking(" + user.getEmail() + "," + ")";
    }


	public Date getCheckinDate() {
		return checkinDate;
	}

	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public boolean isSmoking() {
		return smoking;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public int getBeds() {
		return beds;
	}

	public void setBeds(int beds) {
		this.beds = beds;
	}

	public Long getId() {
		return id;
	}
    
    

}

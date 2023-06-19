package busTicketBookingSystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BusStopDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int busStopId;
	
	@Column(nullable = false)
	private String busStopName;

	public BusStopDTO(int busStopId, String busStopName) {
		super();
		this.busStopId = busStopId;
		this.busStopName = busStopName;
	}

	public int getBusStopId() {
		return busStopId;
	}

	public void setBusStopId(int busStopId) {
		this.busStopId = busStopId;
	}

	public String getBusStopName() {
		return busStopName;
	}

	public void setBusStopName(String busStopName) {
		this.busStopName = busStopName;
	}

	public BusStopDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BusStopDTO [busStopId=" + busStopId + ", busStopName=" + busStopName + "]";
	}
	
}

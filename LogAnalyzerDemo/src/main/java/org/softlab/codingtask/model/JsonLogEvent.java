/**
 * @author Pawel Wloch ©SoftLab
 * @date 09.11.2018
 */
package org.softlab.codingtask.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Representation of input event data in json format
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(includeFieldNames=true)
public class JsonLogEvent {

	@NotNull(message="null or empty id")
	private String id;		// the unique event identifier

	@Pattern(regexp="(^STARTED$|^FINISHED$)", message="missing or wrong state value")
	private String state; // describes whether an event was started or finished

	@NotNull(message="missing timestamp") 
	@Positive(message="timestamp must be positive value")
	private Long timestamp;		// the timestamp of the event in milliseconds
	
	private String type;		// type of log
	
	private String host;		// hostname

	@Override
	public int hashCode() {
		return Objects.hash(host, id, state, timestamp, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JsonLogEvent other = (JsonLogEvent) obj;
		return Objects.equals(host, other.host) && Objects.equals(id, other.id) && Objects.equals(state, other.state)
				&& Objects.equals(timestamp, other.timestamp) && Objects.equals(type, other.type);
	}

}

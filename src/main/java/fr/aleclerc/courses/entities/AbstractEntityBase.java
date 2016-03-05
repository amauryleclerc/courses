package fr.aleclerc.courses.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.domain.Persistable;

@MappedSuperclass
public abstract class AbstractEntityBase implements Persistable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7973489440838367305L;
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	
	public String getId() {
		return id;
	}

	protected void setId(final String id) {
		this.id = id;
	}

	public boolean isNew() {
		return this.id == null;
	}


	@Override
	public String toString() {
		return String.format("Entity of type %s with id: %s", this.getClass().getName(), getId());
	}


	@Override
	public boolean equals(Object obj) {

		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!getClass().equals(obj.getClass())) {
			return false;
		}
		AbstractEntityBase rhs = (AbstractEntityBase) obj;
		return this.id == null ? false : this.id.equals(rhs.getId());
	}


	@Override
	public int hashCode() {
		int hashCode = 17;
		hashCode += (this.id == null) ? 0 : this.id.hashCode() * 31;
		return hashCode;
	}
}
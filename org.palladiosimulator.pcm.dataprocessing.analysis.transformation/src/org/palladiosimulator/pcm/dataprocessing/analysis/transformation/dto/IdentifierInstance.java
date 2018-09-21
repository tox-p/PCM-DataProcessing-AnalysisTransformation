package org.palladiosimulator.pcm.dataprocessing.analysis.transformation.dto;

import java.util.Optional;

import org.palladiosimulator.pcm.core.entity.Entity;
import org.palladiosimulator.pcm.dataprocessing.analysis.transformation.util.Hash;

import de.uka.ipd.sdq.identifier.Identifier;

public class IdentifierInstance<T extends Identifier, S extends Entity> implements UniqueNameHaving {

	private final Optional<S> identifier;
	private final T entity;

	public IdentifierInstance(T entity, S identifier) {
		super();
		this.identifier = Optional.ofNullable(identifier);
		this.entity = entity;
	}

	public Optional<S> getIdentifier() {
		return identifier;
	}

	public T getEntity() {
		return entity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((entity == null) ? 0 : entity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("rawtypes")
		IdentifierInstance other = (IdentifierInstance) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (entity == null) {
			if (other.entity != null)
				return false;
		} else if (!entity.equals(other.entity))
			return false;
		return true;
	}

	@Override
	public String getUniqueName() {
		String entityName = Optional.of(entity).filter(Entity.class::isInstance).map(Entity.class::cast)
				.map(Entity::getEntityName).orElse(entity.getId());
		String entityId = entity.getId();
		String identifierId = identifier.map(Identifier::getId).orElse("");
		String hash = Hash.init(entityId).add(identifierId).getHash();
		
		return String.format("%s_%s", entityName, hash);
	}

	public static <T extends Identifier, S extends Entity> IdentifierInstance<T, S> createInstance(S identifier,
			T entity) {
		return new IdentifierInstance<T, S>(entity, identifier);
	}

}

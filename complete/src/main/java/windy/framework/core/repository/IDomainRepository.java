package windy.framework.core.repository;

import java.util.List;
import java.util.UUID;

import windy.framework.contracts.IDomain;

public interface IDomainRepository<T extends IDomain> {

	public List<T> getAll();
	public T getById(UUID id);
	public void create(T item);
	public void update(T item);
	public void delete(UUID id);
}

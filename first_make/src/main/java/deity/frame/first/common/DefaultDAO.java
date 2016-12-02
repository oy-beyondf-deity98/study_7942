package deity.frame.first.common;

import java.util.List;

public interface DefaultDAO<T> {
	public List<T> list(SearchVo search);

	public T get(String id);

	public int insert(T domain);

	public int update(T domain);

	public int delete(String id);
}

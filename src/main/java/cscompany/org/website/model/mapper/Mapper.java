package cscompany.org.website.model.mapper;

public interface Mapper<T, V> {
    T convertFromDTO(V v);
    V convertToDTO(T t);
}

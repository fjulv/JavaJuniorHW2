package randomDate;
@FunctionalInterface
public interface DateConverter<T> {
    T convert(long randomEpochDay);
}


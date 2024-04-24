import randomDate.RandomDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Homework2 {

    /**
     * 1. Создать аннотацию RandomDate со следующими возможностями:
     * 1.1 Если параметры не заданы, то в поле должна вставляться рандомная дата в диапазоне min, max.
     * 1.2 Аннотация должна работать с полем типа java.util.Date.
     * 1.3 Должна генерить дату в диапазоне [min, max)
     * 1.4 ** Научиться работать с полями LocalDateTime, LocalDate, Instant, ... (классы java.time.*)
     * <p>
     * Реализовать класс RandomDateProcessor по аналогии с RandomIntegerProcessor, который обрабатывает аннотацию.
     */
@RandomDate
   public Date date;
@RandomDate
public LocalDate localDate;
@RandomDate
public LocalDateTime localDateTime;
}


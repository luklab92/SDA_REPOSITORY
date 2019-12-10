package pl.sda.prework_programowanie1;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface SpiecesRepository<T extends Spiece> {

        List<T> getAll();
        List<T> findByAge(int age);
        Person getById(int id);
        Optional<T> findById(int id);
        List<T> findByPredicate (Predicate<T> personPredicate);
        List<T> findAllOrderedBy(Comparator<T> order);
        List<Long> getAllIds();
        void foreach(Consumer<T> person);
    }

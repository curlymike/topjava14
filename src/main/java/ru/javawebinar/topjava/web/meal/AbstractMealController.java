package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.time.LocalDate;
import java.util.Collection;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNew;

public abstract class AbstractMealController {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MealService service;

    public Meal create(Meal meal) {
        log.info("create {}", meal);
        checkNew(meal);
        return service.create(meal);
    }

    public void delete(int id) {
        log.info("delete {}", id);
        service.delete(id);
    }

    public Meal get(int id) {
        log.info("get {}", id);
        return service.get(id);
    }

    public void update(Meal meal) {
        log.info("update {}", meal);
        service.update(meal);
    }

    public Collection<Meal> getAll() {
        log.info("getAll (*)");
        return service.getAll();
    }

    public Collection<Meal> getAll(Integer userId) {
        log.info("getAll ({})", userId);
        return service.getAll(userId);
    }

    public Collection<Meal> getAll(Integer userId, LocalDate from, LocalDate to) {
        log.info("getAll ({})", userId);
        return service.getAll(userId, from, to);
    }

}

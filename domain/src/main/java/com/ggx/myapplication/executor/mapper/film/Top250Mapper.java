package com.ggx.myapplication.executor.mapper.film;

import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListEntity;
import com.ggx.myapplication.executor.entity.response.film.simple.ImageEntity;
import com.ggx.myapplication.executor.entity.response.film.simple.PersonEntity;
import com.ggx.myapplication.executor.entity.response.film.simple.RatingEntity;
import com.ggx.myapplication.executor.entity.response.film.simple.SimpleFilmEntity;
import com.ggx.myapplication.executor.entity.response.film.ResponseFilmListModule;
import com.ggx.myapplication.executor.entity.response.film.simple.Image;
import com.ggx.myapplication.executor.entity.response.film.simple.Person;
import com.ggx.myapplication.executor.entity.response.film.simple.Rating;
import com.ggx.myapplication.executor.entity.response.film.simple.SimpleFilmModule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ggx on 2018/5/19.
 */

public class Top250Mapper {

    public static ResponseFilmListModule transformFilmList(ResponseFilmListEntity entity) {
        ResponseFilmListModule module = new ResponseFilmListModule();
        module.setCount(entity.getCount());
        module.setStart(entity.getStart());
        module.setTitle(entity.getTitle());
        module.setTotal(entity.getTotal());
        module.setSubjects(transformSubjectList(entity.getSubjects()));
        return module;
    }

    private static List<SimpleFilmModule> transformSubjectList(List<SimpleFilmEntity> subjects) {
        List<SimpleFilmModule> list = new ArrayList<>();
        for (SimpleFilmEntity entity : subjects) {
            SimpleFilmModule simpleFilmModule = new SimpleFilmModule();
            simpleFilmModule.setTitle(entity.getTitle());
            simpleFilmModule.setGenres(entity.getGenres());
            simpleFilmModule.setRating(transformRating(entity.getRating()));
            simpleFilmModule.setCasts(transformPersonList(entity.getCasts()));
            simpleFilmModule.setCollect_count(entity.getCollect_count());
            simpleFilmModule.setSubtype(entity.getSubtype());
            simpleFilmModule.setDirectors(transformPersonList(entity.getDirectors()));
            simpleFilmModule.setYear(entity.getYear());
            simpleFilmModule.setImages(transformImage(entity.getImages()));
            simpleFilmModule.setAlt(entity.getAlt());
            simpleFilmModule.setId(entity.getId());
            list.add(simpleFilmModule);
        }
        return list;
    }

    private static Rating transformRating(RatingEntity entity) {
        Rating rating = new Rating();
        rating.setStars(entity.getStars());
        rating.setAverage(entity.getAverage());
        rating.setMax(entity.getMax());
        rating.setMin(entity.getMin());
        return rating;
    }

    public static List<Person> transformPersonList(List<PersonEntity> personEntityList) {
        List<Person> personList = new ArrayList<>();
        for (PersonEntity entity : personEntityList)
            personList.add(transformPserson(entity));
        return personList;
    }

    public static Person transformPserson(PersonEntity entity) {
        Person person = new Person();
        person.setName(entity.getName());
        person.setId(entity.getId());
        person.setAlt(entity.getAlt());
        person.setAvatars(transformImage(entity.getAvatars()));
        return person;
    }

    public static Image transformImage(ImageEntity entity) {
        Image image = new Image();
        image.setSmall(entity.getSmall());
        image.setMedium(entity.getMedium());
        image.setLarge(entity.getLarge());
        return image;
    }
}

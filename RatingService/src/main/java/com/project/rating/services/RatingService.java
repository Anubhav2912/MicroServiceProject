package com.project.rating.services;

import com.project.rating.entities.Rating;

import java.util.List;

public interface RatingService {

    Rating create(Rating rating);

    List<Rating> getRatings();

    List<Rating> getRatingByUserId(String UserId);

    List<Rating> getRatingByHotelId(String HotelId);
}

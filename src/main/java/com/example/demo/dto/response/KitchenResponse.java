package com.example.demo.dto.response;

import com.example.demo.entity.Menu;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KitchenResponse {

    private Long id;
    private String name;
    private List<DayOfWeek> workingDays;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Menu> menuItems;

}

package com.kodilla.footballapp;

import com.kodilla.footballapp.domain.League;
import com.kodilla.footballapp.service.LeagueService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class LeagueView extends VerticalLayout {

    private Grid grid = new Grid<>(League.class);

    public LeagueView() {
        grid.setColumns("id", "name", "description");
        add(grid);
        setSizeFull();
    }
}

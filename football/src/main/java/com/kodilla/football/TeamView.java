package com.kodilla.football;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route
public class TeamView extends VerticalLayout {

    public TeamView() {
        add(new Button("Click me", e -> Notification.show("Hello world")));
    }

}
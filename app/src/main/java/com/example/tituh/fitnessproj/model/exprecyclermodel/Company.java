package com.example.tituh.fitnessproj.model.exprecyclermodel;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class Company extends ExpandableGroup<Product> {


    public Company(String title, List<Product> items) {
        super(title, items);
    }
}

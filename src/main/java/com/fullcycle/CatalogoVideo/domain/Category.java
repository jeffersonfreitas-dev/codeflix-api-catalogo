package com.fullcycle.CatalogoVideo.domain;

import java.util.UUID;

public class Category {
    private final UUID id;
    private String name;
    private String description;
    private Boolean isActive;

    public Category (String name, String description){
        this.id = UUID.randomUUID();
        this.setName(name);
        this.setDescription(description);
        this.active();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) throw new IllegalArgumentException("Can not be null");
        if(name.isEmpty()) throw new IllegalArgumentException("Can not be blank");
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return isActive;
    }

    public Boolean active(){
        return this.isActive = true;
    }

    public Boolean deactivate(){
        return this.isActive = false;
    }

    public void update(String name, String description, Boolean isActive){
        this.setName(name);
        this.setDescription(description);
        if(isActive != null && isActive != this.getActive()){
            this.isActive = isActive ? this.active() : this.deactivate();
         }
    }
}

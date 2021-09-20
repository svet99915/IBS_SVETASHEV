package ru.appline.logic;

import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

public class PetModel implements Serializable {
    private static final PetModel instance = new PetModel();

    private final Map<Integer, Pet> model;

    public PetModel()
    {
        model = new HashMap<Integer, Pet>();
    }

    public static PetModel getInstance()
    {
        return instance;
    }

    public void add(Pet pet, int id)
    {
        model.put(id,pet);
    }

    public void deletePet(int id)
    {
        model.remove(id);
    }

    public Pet getFromList(int id)
    {
        return model.get(id);
    }

    public void put(Pet pet,int id)
    {
        model.put(id,pet);
    }

    public Map<Integer, Pet> getAll()
    {

        return model;
    }
}

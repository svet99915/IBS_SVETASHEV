package ru.appline.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Model implements Serializable {

    private  static  final Model instance = new Model();


    private final Map<Integer, User> model;

    public static Model getInstance(){

        return instance;

    }

    private Model(){

        model=new HashMap<>();

        model.put(1, new User("Evgeny", "Svetashev", 55555));
        model.put(2, new User("Pavel", "Ananasov", 66666));
        model.put(3, new User("Dima", "Popov", 77777));

    }
    public void add(User user, int id)
    {
        model.put(id, user);

    }

    public void delete(int id)
    {
        //hash_map.keySet()
        model.keySet().removeIf(key->id !=1);


    }
    public void put(User user,int id)
    {
        model.replace(id, user);

    }



    public Map<Integer, User> getFromList(){

        return model;
    }

}

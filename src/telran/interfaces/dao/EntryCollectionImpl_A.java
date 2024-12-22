package telran.interfaces.dao;

import telran.interfaces.dao.Entity;
import telran.interfaces.dao.EntityCollection;

import java.util.*;

public class EntryCollectionImpl_A implements EntityCollection {

    public HashMap<Integer, Entity> entryCol;
    private final Comparator<Integer> comparator = (i1, i2) -> Integer.compare(i1, i2);

    public void EntryCollectionImpl_D(){
        entryCol = new HashMap<>();
    }

    //O(1)
    @Override
    public void add(Entity entity) {
        entryCol.put(entity.getValue(), entity);
    }

    //O(n)
    @Override
    public Entity removeMaxValue() {
        if (entryCol.isEmpty()){
            return null;
        }

        Integer index = entryCol.keySet().stream()
                .max(comparator)
                .orElse(null);
        if (index != null) {
            Entity victim = entryCol.get(index);
            entryCol.remove(index);
            return victim;
        }

        return null;
    }
}

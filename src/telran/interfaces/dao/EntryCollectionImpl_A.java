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

    //O(log n)
    @Override
    public Entity removeMaxValue() {
        if (entryCol.isEmpty()){
            return null;
        }

        List<Integer> list = new ArrayList<>(entryCol.keySet());
        int index = Collections.binarySearch(list, Integer.MAX_VALUE, comparator);

        index = index < 0? -index - 1: index;

        int key = list.get(index);

        Entity victim = entryCol.get(key);
        entryCol.remove(key);

        return victim;
    }
}

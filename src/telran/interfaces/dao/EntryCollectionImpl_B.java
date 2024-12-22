package telran.interfaces.dao;

import telran.interfaces.dao.Entity;
import telran.interfaces.dao.EntityCollection;

import java.util.*;

public class EntryCollectionImpl_B implements EntityCollection {

    public ArrayList<Entity> entryCol;
    Comparator<Entity> comparator = (ent1, ent2) -> Integer.compare(ent1.getValue(), ent2.getValue());

    public EntryCollectionImpl_B(){
        entryCol = new ArrayList<>();
    }


    //O(log n)
    @Override
    public void add(Entity entity) {
        int index = Collections.binarySearch(entryCol, entity, comparator);
        if (index > 0) {
            return;
        }
        index = -index - 1;
        entryCol.add(index, entity);
    }

    //O(1)
    @Override
    public Entity removeMaxValue() {
        if (entryCol.isEmpty()) {
            return null;
        }

        Entity victim = entryCol.get(entryCol.size() - 1);
        entryCol.remove(victim);
        return victim;
    }
}

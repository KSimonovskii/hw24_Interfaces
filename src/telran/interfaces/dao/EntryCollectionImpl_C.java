package telran.interfaces.dao;

import telran.interfaces.dao.Entity;
import telran.interfaces.dao.EntityCollection;

import java.util.Comparator;
import java.util.TreeSet;

public class EntryCollectionImpl_C implements EntityCollection {

    public TreeSet<Entity> entryCol;
    Comparator<Entity> comparator = (ent1, ent2) -> Integer.compare(ent1.getValue(), ent2.getValue());

    public void EntryCollectionImpl_C(){
        entryCol = new TreeSet<>(comparator);
    }

    //O(log n)
    @Override
    public void add(Entity entity) {
        if (entryCol.contains(entity)){
            return;
        }
        entryCol.add(entity);
    }

    //O(1)
    @Override
    public Entity removeMaxValue() {
        if (entryCol.isEmpty()){
            return null;
        }
        Entity victim = entryCol.last();
        entryCol.remove(victim);

        return victim;
    }
}

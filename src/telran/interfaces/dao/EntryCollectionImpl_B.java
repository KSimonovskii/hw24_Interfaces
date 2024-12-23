package telran.interfaces.dao;

import java.util.Comparator;
import java.util.TreeSet;

public class EntryCollectionImpl_B implements EntityCollection {

    public TreeSet<Entity> entryCol;

    Comparator<Entity> comparator = (ent1, ent2) -> Integer.compare(ent1.getValue(), ent2.getValue());

    public void EntryCollectionImpl_B(){
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

    //O(log n)
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

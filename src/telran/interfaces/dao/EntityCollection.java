package telran.interfaces.dao;

public interface EntityCollection {
    public void add(Entity entity);

    public Entity removeMaxValue();
}

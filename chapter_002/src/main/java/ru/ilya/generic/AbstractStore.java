package ru.ilya.generic;

/**
 * Created by Lenovo2 on 13.04.2018.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> items = new SimpleArray<>(100);

    public void add(T item) {
        items.add(item);
    }

    /**
     * Method for updating .
     * @param model model to update.
     */
    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int a = getIndexById(id);
        if (a != -1) {
            result = items.update(a, model);
        }
        return result;
    }

    /**
     * delete method .
     * @param id of element to delete.
     * @return true if element deleted.
     */
    @Override
    public boolean delete(String id) {
        boolean result = false;
        int index = getIndexById(id);
        if (index != -1) {
            result = items.delete(index);
        }
        return result;
    }

    /**
     * @return null if no search id.
     */
    @Override
    public T findById(String id) {
        int index = getIndexById(id);
        return  index != -1 ? items.get(index) : null;
    }

    /**
     * @return id .
     */
    private int getIndexById(String id) {
        int result = -1;
        if (id != null) {
            final int length = items.length();
            for (int i = 0; i != length; i++) {
                T model = items.get(i);
                if (model != null && model.getId().equals(id)) {
                    result = i;
                }
            }
        }
        return result;
    }

    /**
     * @return true If store have model's id.
     */
    public boolean contains(T model) {
        return getIndexById(model.getId()) > -1;
    }


}

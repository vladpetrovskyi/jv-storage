package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int elementNumber;
    private K[] keysArray;
    private V[] valuesArray;

    public StorageImpl() {
        elementNumber = 0;
        keysArray = (K[]) new Object[10];
        valuesArray = (V[]) new Object[10];
    }

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            keysArray[elementNumber] = key;
            valuesArray[elementNumber] = value;
            elementNumber++;
        } else {
            for (int i = 0; i < keysArray.length - 1; i++) {
                if ((key == keysArray[i]) || key != null && key.equals(keysArray[i])) {
                    valuesArray[i] = value;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keysArray.length - 1; i++) {
            if ((key == keysArray[i]) || key != null && key.equals(keysArray[i])) {
                return valuesArray[i];
            }
        }
        return null;
    }
}

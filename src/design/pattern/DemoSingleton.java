package design.pattern;


import java.io.Serializable;

/**
 *
 * Use ENUM to avoid instance creation in reflection. Its only drawback is that it is not flexible i.e
 * it does not allow lazy initialization.
 *
 * serialVersionUID = 1L; This is required in cases where your class structure changes between serialization and deserialization.
 * A changed class structure will cause the JVM to give an exception in the de-serializing process.
 *
 *Recomended design for singleton.
 * Bill plugh -> thread safe lazy initilizaion -> not reflection safe.
 */
public class DemoSingleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private DemoSingleton() {
        // private constructor
    }

    private static class DemoSingletonHolder {
        public static final DemoSingleton INSTANCE = new DemoSingleton();
    }

    public static DemoSingleton getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }

    // override this to avoid instance creation during de-serialization
    protected Object readResolve() {
        return getInstance();
    }
}
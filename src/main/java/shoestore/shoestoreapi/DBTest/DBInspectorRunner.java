package shoestore.shoestoreapi.DBTest;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DBInspectorRunner implements CommandLineRunner {

    private final DBInspector databaseInspector;

    public DBInspectorRunner(DBInspector databaseInspector) {
        this.databaseInspector = databaseInspector;
    }

    @Override
    public void run(String... args) throws Exception {
        databaseInspector.inspectDatabase();
    }
}


package seedu.planner.model.module;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.commons.util.JsonUtil;


public class ModuleDataImporter {

    private static final String DOWNLOAD_URL = "https://api.nusmods.com/v2/{0}/moduleInfo.json";
    private static final String[] acadYears = new String[]{
        "2019-2020",
        "2018-2019"
    };
    private static List<Module> modules = new ArrayList<>();

    public static List<Module> run() {
        String url;
        Path path;
        Module module;
        for (String acadYear : acadYears) {
            try {
                url = DOWNLOAD_URL.replace("{0}", acadYear);
                path = Paths.get("data", "moduleInfo_{0}.json".replace("{0}", acadYear));
                if (!Files.exists(path)) {
                    try (InputStream in = new URL(url).openStream()) {
                        Files.copy(in, path);
                    }
                }
                Optional<JsonSerializableModule[]> optionalModules = JsonUtil.readJsonFile(path,
                    JsonSerializableModule[].class);
                if (optionalModules.isPresent()) {
                    JsonSerializableModule[] moduleArray = optionalModules.get();
                    for (JsonSerializableModule m : moduleArray) {
                        try {
                            module = m.toModelType();
                            if (modules.contains(module)) {
                                int a = 1;
                            } else {
                                modules.add(module);
                            }
                        } catch (IllegalValueException ex) {
                            System.err.println(ex);
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return modules;
    }

    public ObservableList<Module> getFilteredModuleList() {
        ObservableList<Module> oList = FXCollections.observableArrayList(modules);
        return oList;
    }
}

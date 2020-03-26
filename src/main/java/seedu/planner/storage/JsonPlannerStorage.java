package seedu.planner.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.planner.commons.core.LogsCenter;
import seedu.planner.commons.exceptions.DataConversionException;
import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.commons.util.FileUtil;
import seedu.planner.commons.util.JsonUtil;
import seedu.planner.model.Planner;
import seedu.planner.model.ReadOnlyPlanner;

/**
 * A class to access Planner data stored as a json file on the hard disk.
 */
public class JsonPlannerStorage implements PlannerStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonPlannerStorage.class);

    private Path filePath;

    public JsonPlannerStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getPlannerFilePath() {
        return filePath;
    }

    @Override
    public Optional<Planner> readPlanner() throws DataConversionException {
        return readPlanner(filePath);
    }

    /**
     * Similar to {@link #readPlanner()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataConversionException if the file is not in the correct format.
     */
    public Optional<Planner> readPlanner(Path filePath) throws DataConversionException {
        requireNonNull(filePath);

        Optional<JsonSerializablePlanner> jsonPlanner = JsonUtil.readJsonFile(
            filePath, JsonSerializablePlanner.class);
        if (!jsonPlanner.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonPlanner.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataConversionException(ive);
        }
    }

    public void savePlanner(ReadOnlyPlanner planner) throws IOException {
        savePlanner(planner, filePath);
    }

    /**
     * Similar to {@link #savePlanner(ReadOnlyPlanner)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void savePlanner(ReadOnlyPlanner planner, Path filePath) throws IOException {
        requireNonNull(planner);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializablePlanner(planner), filePath);
    }

}

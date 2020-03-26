package seedu.planner.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import seedu.planner.commons.exceptions.IllegalValueException;
import seedu.planner.model.module.ModuleCode;

/**
 * Jackson-friendly version of {@link ModuleCode}.
 */
class JsonAdaptedModuleCode {

    private final String value;

    /**
     * Constructs a {@code JsonAdaptedModuleCode} with the given {@code value}.
     */
    @JsonCreator
    public JsonAdaptedModuleCode(String value) {
        this.value = value;
    }

    /**
     * Converts a given {@code ModuleCode} into this class for Jackson use.
     */
    public JsonAdaptedModuleCode(ModuleCode source) {
        value = source.value;
    }

    @JsonValue
    public String getModuleCode() {
        return value;
    }

    /**
     * Converts this Jackson-friendly adapted module code object into the model's {@code ModuleCode} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted module code.
     */
    public ModuleCode toModelType() throws IllegalValueException {
        if (!ModuleCode.isValidModuleCode(value)) {
            throw new IllegalValueException(ModuleCode.MESSAGE_CONSTRAINTS);
        }
        return new ModuleCode(value);
    }

}

package seedu.planner.model.module;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class ModuleTime {
    protected LocalTime startTime;
    protected LocalTime endTime;
    protected DayOfWeek dayOfWeek;

    public ModuleTime(LocalTime startTime, LocalTime endTime, DayOfWeek dayOfWeek) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.dayOfWeek = dayOfWeek;
    }
}

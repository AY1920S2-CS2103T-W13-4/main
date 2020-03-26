package seedu.planner.model.module;

import java.util.List;

public class SemesterData {

    private int semester;
    private String examDate;
    private int examDuration;
    private List<Lesson> timetable;

    public SemesterData(int semester, String examDate, int examDuration, List<Lesson> timetable) {
        this.semester = semester;
        this.examDate = examDate;
        this.examDuration = examDuration;
        this.timetable = timetable;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getExamDate() {
        return examDate;
    }

    public void setExamDate(String examDate) {
        this.examDate = examDate;
    }

    public int getExamDuration() {
        return examDuration;
    }

    public void setExamDuration(int examDuration) {
        this.examDuration = examDuration;
    }

    public List<Lesson> getTimetable() {
        return timetable;
    }

    public void setTimetable(List<Lesson> timetable) {
        this.timetable = timetable;
    }

}

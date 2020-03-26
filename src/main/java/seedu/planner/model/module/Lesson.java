package seedu.planner.model.module;

public class Lesson {
    private String classNo;
    private String startTime;
    private String endTime;
    private Object weeks;
    private String venue;
    private String day;
    private String lessonType;
    private int size;
    private ModuleTime time;

    public Lesson() {

    }

    public Lesson(String classNo, String startTime, String endTime, Object weeks, String venue, String day,
                  String lessonType, int size) {
        this.classNo = classNo;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weeks = weeks;
        this.venue = venue;
        this.day = day;
        this.lessonType = lessonType;
        this.size = size;
    }


    public ModuleTime getTime() {
        return null;
    }

    public void setTime(ModuleTime time) {
        this.time = time;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Object getWeeks() {
        return weeks;
    }

    public void setWeeks(Object weeks) {
        this.weeks = weeks;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

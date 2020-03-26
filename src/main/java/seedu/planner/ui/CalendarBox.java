package seedu.planner.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.planner.commons.core.LogsCenter;

/**
 * An UI component that displays information of a {@code Timetable}.
 */
public class CalendarBox extends UiPart<Region> {
    private static final String FXML = "calendarBox.fxml";
    private final Logger logger = LogsCenter.getLogger(CalendarBox.class);

    @FXML
    private Label semester;

    @FXML
    private Label dayTime;

    @FXML
    private Label t89;
    @FXML
    private Label t910;
    @FXML
    private Label t1011;
    @FXML
    private Label t1112;
    @FXML
    private Label t1213;
    @FXML
    private Label t1314;
    @FXML
    private Label t1415;
    @FXML
    private Label t1516;
    @FXML
    private Label t1617;
    @FXML
    private Label t1718;
    @FXML
    private Label t1819;
    @FXML
    private Label t1920;

    @FXML
    private Label m1;
    @FXML
    private Label m2;
    @FXML
    private Label m3;
    @FXML
    private Label m4;
    @FXML
    private Label m5;
    @FXML
    private Label m6;
    @FXML
    private Label m7;
    @FXML
    private Label m8;
    @FXML
    private Label m9;
    @FXML
    private Label m10;
    @FXML
    private Label m11;
    @FXML
    private Label m12;

    @FXML
    private Label t1;
    @FXML
    private Label t2;
    @FXML
    private Label t3;
    @FXML
    private Label t4;
    @FXML
    private Label t5;
    @FXML
    private Label t6;
    @FXML
    private Label t7;
    @FXML
    private Label t8;
    @FXML
    private Label t9;
    @FXML
    private Label t10;
    @FXML
    private Label t11;
    @FXML
    private Label t12;

    @FXML
    private Label w1;
    @FXML
    private Label w2;
    @FXML
    private Label w3;
    @FXML
    private Label w4;
    @FXML
    private Label w5;
    @FXML
    private Label w6;
    @FXML
    private Label w7;
    @FXML
    private Label w8;
    @FXML
    private Label w9;
    @FXML
    private Label w10;
    @FXML
    private Label w11;
    @FXML
    private Label w12;

    @FXML
    private Label th1;
    @FXML
    private Label th2;
    @FXML
    private Label th3;
    @FXML
    private Label th4;
    @FXML
    private Label th5;
    @FXML
    private Label th6;
    @FXML
    private Label th7;
    @FXML
    private Label th8;
    @FXML
    private Label th9;
    @FXML
    private Label th10;
    @FXML
    private Label th11;
    @FXML
    private Label th12;

    @FXML
    private Label f1;
    @FXML
    private Label f2;
    @FXML
    private Label f3;
    @FXML
    private Label f4;
    @FXML
    private Label f5;
    @FXML
    private Label f6;
    @FXML
    private Label f7;
    @FXML
    private Label f8;
    @FXML
    private Label f9;
    @FXML
    private Label f10;
    @FXML
    private Label f11;
    @FXML
    private Label f12;


    /**
     * Constructor for CalendarBox class
     */
    public CalendarBox() {
        super(FXML);
        dayTime.setText("Day / Time");
        m1.setText("");
        m2.setText("");
        m3.setText("");
        m4.setText("");
        m5.setText("");
        m6.setText("");
        m7.setText("");
        m8.setText("");
        m9.setText("");
        m10.setText("");
        m11.setText("");
        m12.setText("");
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");
        w1.setText("");
        w2.setText("");
        w3.setText("");
        w4.setText("");
        w5.setText("");
        w6.setText("");
        w7.setText("");
        w8.setText("");
        w9.setText("");
        w10.setText("");
        w11.setText("");
        w12.setText("");
        th1.setText("");
        th2.setText("");
        th3.setText("");
        th4.setText("");
        th5.setText("");
        th6.setText("");
        th7.setText("");
        th8.setText("");
        th9.setText("");
        th10.setText("");
        th11.setText("");
        th12.setText("");
        f1.setText("");
        f2.setText("");
        f3.setText("");
        f4.setText("");
        f5.setText("");
        f6.setText("");
        f7.setText("");
        f8.setText("");
        f9.setText("");
        f10.setText("");
        f11.setText("");
        f12.setText("");
    }

    /**
     * Todo once timetable can be seen
     */
    public void setCalendar() {

    }


    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CalendarBox)) {
            return false;
        }
        return false;
    }

}

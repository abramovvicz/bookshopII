package utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Status {
    private static Status instance = new Status();
    private boolean status;

    private Status() {

    }

    public static Status getInstance() {
        if (instance == null) {
            synchronized (Status.class) {
                if (instance == null) {
                    instance = new Status();
                }
            }
        }
        return instance;
    }

}

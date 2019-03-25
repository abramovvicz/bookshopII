package utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ApplicationStatus {
    private static ApplicationStatus instance = new ApplicationStatus();
    private boolean status;

    private ApplicationStatus() {

    }

    public static ApplicationStatus getInstance() {
        if (instance == null) {
            synchronized (ApplicationStatus.class) {
                if (instance == null) {
                    instance = new ApplicationStatus();
                }
            }
        }
        return instance;
    }

}

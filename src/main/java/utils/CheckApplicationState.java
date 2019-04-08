package utils;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CheckApplicationState {
    private static CheckApplicationState instance = new CheckApplicationState();
    private boolean status;

    private CheckApplicationState() {

    }

    public static CheckApplicationState getInstance() {
        if (instance == null) {
            synchronized (CheckApplicationState.class) {
                if (instance == null) {
                    instance = new CheckApplicationState();
                }
            }
        }
        return instance;
    }

}

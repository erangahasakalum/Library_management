package lk.ijse.bo;

import javafx.concurrent.Task;

public class LoadingTask extends Task <Integer>{
    @Override
    protected Integer call() throws Exception {
        for (int i = 0; i <100 ; i++) {

        }
        return 100;
    }
}

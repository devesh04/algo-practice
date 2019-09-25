package util.commons;


import practice.BreakupApp;
import practice.LinearSearch;
import practice.MonkTakesAWalk;
import practice.PoliceAndTheif;

import java.io.IOException;

/**
 * Created by devesh on 03/09/18.
 */
public enum Program {

    LINEAR_SEARCH(new LinearSearch()),
    MONK_TAKES_A_WALK(new MonkTakesAWalk()),
    BREAKUP_APP(new BreakupApp()),
    POLICE_AND_THEIF(new PoliceAndTheif()),

    ;

    private Executable executable;

    Program(Executable executable){
        this.executable = executable;
    }

    public void execute() throws IOException {
        this.executable.execute();
    }

}

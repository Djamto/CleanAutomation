package com.clean.automation.core.scenario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darjandjamtovski on 2/12/18.
 */
public class ScenarioResetStepHandler {

    private static ArrayList<ScenarioDataReset> scenarioDataResetList = new ArrayList<ScenarioDataReset>();

    public static void addScenarioDataResetStepAction(ScenarioDataReset scenarioDataReset) {
        scenarioDataResetList.add(scenarioDataReset);
    }

    public static void recycle() {
        scenarioDataResetList.clear();
        scenarioDataResetList = new ArrayList<ScenarioDataReset>();
    }

    public static List<ScenarioDataReset> getScenarioDataResetList() {
        return scenarioDataResetList;
    }

}

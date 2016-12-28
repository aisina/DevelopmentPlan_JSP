package controllers;

import dao.PlanDAO;
import pojo.Plan;

import java.util.List;

/**
 * Created by innopolis on 28.12.2016.
 */
public class ControllerForAdminPlans {

    private final PlanDAO storeOfPlan = new PlanDAO();

    public List<Plan> getValues(String year){
        return this.storeOfPlan.getPlanByYear(year);
    }
}

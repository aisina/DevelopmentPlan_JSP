package controllers;

import dao.PlanDAO;
import pojo.Plan;

import java.util.List;

/**
 * Created by innopolis on 28.12.2016.
 */
public class ControllerForUserPlans {

    private final PlanDAO storeOfPlan = new PlanDAO();

    public List<Plan> getValues(String userID){
        return this.storeOfPlan.getPlanByEmplId(userID);
    }


}

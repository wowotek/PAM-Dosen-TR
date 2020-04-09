package edu.pam.tugas_rancang.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import edu.pam.tugas_rancang.entity.BudgetType;

public class GetBudgetTypeAllResponse {
    @SerializedName("budget_types")
    @Expose
    private List<BudgetType> budgetTypes = null;
    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("status")
    @Expose
    private Integer status;

    public List<BudgetType> getBudgetTypes() {
        return budgetTypes;
    }

    public void setBudgetTypes(List<BudgetType> budgetTypes) {
        this.budgetTypes = budgetTypes;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

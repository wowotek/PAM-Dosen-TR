package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.pam.tugas_rancang.adapter.BudgetListAdapter;
import edu.pam.tugas_rancang.entity.Budget;
import edu.pam.tugas_rancang.entity.BudgetType;
import edu.pam.tugas_rancang.entity.Tour;
import edu.pam.tugas_rancang.entity.Trip;

public class BudgetManagementActivity extends AppCompatActivity implements BudgetListAdapter.ItemClickListener {
    BudgetListAdapter budgetListAdapter;
    ArrayList<Budget> budgetsData = new ArrayList<>();

    /* Widgets */
    RecyclerView budgetListView;
    Button budgetAddButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget_management);

        // Prepare Widgets
        this.budgetListView = findViewById(R.id.budgetList);
        this.budgetAddButton = findViewById(R.id.budgetNewButton);

        // Prepare Adapters
        this.budgetListView.setLayoutManager(new LinearLayoutManager(this));
        this.budgetListAdapter = new BudgetListAdapter(this, this.budgetsData);
        this.budgetListAdapter.setClickListener(this);
        this.budgetListView.setAdapter(this.budgetListAdapter);
    }

    @Override
    public void onItemClick(View view, int position) {
    }

    public void newBudgetOnClick(View view){
        Intent i = new Intent(this, AddBudgetActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == Activity.RESULT_OK){
                this.budgetListAdapter.appendList(
                        new Budget(
                                this.budgetsData.size()+1,
                                new Trip(0, new Tour(0, "", "", 0), "", ""),
                                data.getStringExtra("budgetNameExtra"),
                                data.getStringExtra("budgetDescExtra"),
                                data.getDoubleExtra("budgetAmountExtra", 0.0),
                                new BudgetType(0, data.getStringExtra("budgetTypeExtra"))
                        )
                );
                this.budgetListAdapter.notifyDataSetChanged();
            }
        }
    }
}

package edu.pam.tugas_rancang;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class AddBudgetActivity extends AppCompatActivity {

    EditText wBudgetName;
    Spinner wBudgetType;
    EditText wBudgetAmount;
    EditText wBudgetDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);

        this.wBudgetName = findViewById(R.id.budget_name_input);
        this.wBudgetType = findViewById(R.id.budget_type_choose);
        this.wBudgetAmount = findViewById(R.id.budget_amount_input);
        this.wBudgetDesc = findViewById(R.id.budget_desc_input);
    }

    public void budgetAddOnClick(View view){
        Intent intent = new Intent();
        intent.putExtra("budgetNameExtra", this.wBudgetName.getText().toString());
        intent.putExtra("budgetTypeExtra", this.wBudgetType.getSelectedItem().toString());
        intent.putExtra("budgetAmountExtra", Double.parseDouble(this.wBudgetAmount.toString()));
        intent.putExtra("budgetDescExtra", this.wBudgetDesc.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}

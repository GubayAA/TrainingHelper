package ru.gubayaa.traininghelper;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;

public class FragmentCalcPresenter {

    double height;
    double weight;
    int age;
    String sex;

    void createTabs(Context context, View view) {
        TabHost tabHost = view.findViewById(R.id.tabHost);;
        tabHost.setup();

        createTab(tabHost, context.getString(R.string.tab_BMI), R.id.includeBMI);
        createTab(tabHost, context.getString(R.string.tab_PFC), R.id.includePFC);
        tabBmiProcessor(view);
        tabPfcProcessor(view);
    }

    private void tabBmiProcessor(View view) {
        Button btnBmi = view.findViewById(R.id.btnBmi);
        final EditText etHeight = view.findViewById(R.id.etBmiHeight);
        final EditText etWeight = view.findViewById(R.id.etBmiWeight);
        final ImageView ivBmi = view.findViewById(R.id.ivBmi);
        final TextView tvBmiResult = view.findViewById(R.id.tvBmiResult);

        btnBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    height = Double.parseDouble(etHeight.getText().toString());
                    weight = Double.parseDouble(etWeight.getText().toString());
                } catch (NullPointerException nullEx) {return;}

                ivBmi.setVisibility(View.VISIBLE);
                tvBmiResult.setVisibility(View.VISIBLE);

                FragmentCalcModel Model = new FragmentCalcModel();
                double yourBMI = Model.getBMI(height, weight);


                String stringBMI = String.format("Ваш индекс массы тела равен %(.2f", yourBMI);
                if (yourBMI < 18.5) {
                    ivBmi.setImageResource(R.drawable.stadia_1);
                    tvBmiResult.setText(stringBMI + " (недостаток веса)");
                }
                else if (yourBMI < 25) {
                    ivBmi.setImageResource(R.drawable.stadia_2);
                    tvBmiResult.setText(stringBMI + " (нормальный вес)");
                }
                else if (yourBMI < 30) {
                    ivBmi.setImageResource(R.drawable.stadia_3);
                    tvBmiResult.setText(stringBMI + " (избыточный вес)");
                }
                else if (yourBMI < 35) {
                    ivBmi.setImageResource(R.drawable.stadia_4);
                    tvBmiResult.setText(stringBMI + " (ожирение)");
                }
                else {
                    ivBmi.setImageResource(R.drawable.stadia_5);
                    tvBmiResult.setText(stringBMI + " (крайняя степень ожирения)");
                }
            }
        });
    }

    private void tabPfcProcessor(View view) {
        final Spinner spinnerSex = view.findViewById(R.id.spinnerSex);
        spinnerSex.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, new String[]{"Мужчина", "Женщина"}));
        final EditText etPfcHeight = view.findViewById(R.id.etPfcHeight);
        final EditText etPfcWeight = view.findViewById(R.id.etPfcWeight);
        final EditText etPfcAge = view.findViewById(R.id.etPfcAge);
        final TextView tvPfcResult = view.findViewById(R.id.tvPfcResult);
        Button btnPfc = view.findViewById(R.id.btnPfc);
        btnPfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    height = Double.parseDouble(etPfcHeight.getText().toString());
                    weight = Double.parseDouble(etPfcWeight.getText().toString());
                    age = Integer.parseInt(etPfcAge.getText().toString());
                    sex = spinnerSex.getSelectedItem().toString();
                } catch (NullPointerException nullEx) {
                    return;
                }

                FragmentCalcModel model = new FragmentCalcModel();
                Double yourPfc = model.getPFC(sex, age, weight, height);
                tvPfcResult.setVisibility(View.VISIBLE);
                tvPfcResult.setText("Опnимальное количество Ккал в день - " + yourPfc.toString());
            }
        });
    }

    private void createTab(TabHost tabHost, String indicator, int id) {
        TabHost.TabSpec spec = tabHost.newTabSpec(indicator);
        spec.setContent(id);
        spec.setIndicator(indicator);
        tabHost.addTab(spec);
    }
}

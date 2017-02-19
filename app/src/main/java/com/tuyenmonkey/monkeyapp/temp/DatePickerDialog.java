package com.tuyenmonkey.monkeyapp.temp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.NumberPicker;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.tuyenmonkey.monkeyapp.R;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Tuyen Monkey on 2/16/17.
 */

public class DatePickerDialog extends DialogFragment {
  @BindView(R.id.npDate) NumberPicker npDate;
  @BindView(R.id.npMonth) NumberPicker npMonth;
  @BindView(R.id.npYear) NumberPicker npYear;
  @BindView(R.id.btFinish) Button btFinish;

  private Unbinder unbinder;
  private OnDatePickedListener onDatePickedListener;

  public interface OnDatePickedListener {
    void onDatePicked(int date, int month, int year);
  }

  public static DatePickerDialog newInstance() {
    Bundle args = new Bundle();
    DatePickerDialog fragment = new DatePickerDialog();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onStart() {
    super.onStart();
    if (getDialog() == null || getDialog().getWindow() == null) {
      return;
    }

    ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
    params.width = WindowManager.LayoutParams.MATCH_PARENT;
    params.height = WindowManager.LayoutParams.WRAP_CONTENT;
    getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
  }

  @Nullable @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.dialog_date_picker, container);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    setUpFinishButton();
    setUpDatePicker();
    setUpMonthPicker();
    setUpYearPicker();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }

  public void setOnDatePickListener(OnDatePickedListener onDatePickListener) {
    this.onDatePickedListener = onDatePickListener;
  }

  private void setUpFinishButton() {
    btFinish.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        if (onDatePickedListener != null) {
          onDatePickedListener.onDatePicked(npDate.getValue(), npMonth.getValue(), npYear.getValue());
        }
        dismiss();
      }
    });
  }

  private void setUpMonthPicker() {
    String[] months = new String[12];
    for (int i = 1; i <= 12; i++) {
      months[i - 1] = String.format(Locale.US, "Tháng %d", i);
    }
    npMonth.setMinValue(1);
    npMonth.setMaxValue(12);
    npMonth.setDisplayedValues(months);
    npMonth.setValue(Calendar.getInstance().get(Calendar.MONTH));
  }

  private void setUpDatePicker() {
    npDate.setMinValue(1);
    npDate.setMaxValue(31);
    npDate.setValue(Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
  }

  private void setUpYearPicker() {
    npYear.setMinValue(1900);
    npYear.setMaxValue(Calendar.getInstance().get(Calendar.YEAR));
    npYear.setValue(Calendar.getInstance().get(Calendar.YEAR));
  }
}

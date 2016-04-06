# trungnt-android3-assignment2
##Yêu cầu
+ Tạo giao diện Form đăng ký thông tin Sinh viên
![Form Student](http://i477.photobucket.com/albums/rr132/trungepu/12321338_1014830671925706_1000569984899993148_n_zpsu6xe35q3.jpg)

##Chú ý khi code
+ Tạo Hộp thoại Calender (khi click vào editTextBirthday thì hộp thoại Calender hiển thị và cho phép người dùng chọn ngày)
```
//dinh nghia phuong thuc hien thi Hop thoai Calendar trong editTextBirthday
    private void setDataDatePickerDialogBirthday()
    {
        editTextBirthday = (EditText) this.findViewById(R.id.editTextBirthday);
        editTextBirthday.setOnClickListener(this);
        editTextBirthday.setInputType(InputType.TYPE_NULL);

        Calendar newCalendar = Calendar.getInstance();
        datePickerDialogBirthday = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                editTextBirthday.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }
```

##Môi trường phát triển
+ Bộ công cụ Android Studio 
+ Máy ảo Genymotion chạy hệ điều hành Android versioon 4.3
+ App dùng api18 với Hệ điều hành version 4.3

##Tham khảo
+ [DatePickerDialog on editText](http://androidopentutorials.com/android-datepickerdialog-on-edittext-click-event/)

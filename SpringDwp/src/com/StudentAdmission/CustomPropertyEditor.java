package com.StudentAdmission;

public class CustomPropertyEditor {
	public String CustomNameEditor(String studentgender, String studentname) {
		if (studentgender.equalsIgnoreCase("Male")) {
			studentname = "Mr." + studentname;
		} else {
			studentname = "Ms." + studentname;
		}
		return studentname;
	}

	public Long CustomPhoneEditor(Long studentmobile) {
		try {
			String input = String.valueOf(studentmobile);

			String number = input.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

			studentmobile = Long.valueOf(number);

		} catch (NumberFormatException e) {
			System.out.println("Invalid data provided for Studentmobile field " + e.getLocalizedMessage()+"msg "+e.getMessage());
		}
		return studentmobile;
	}
}

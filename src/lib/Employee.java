package lib;

import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Employee extends Person {

	public enum Grade {
		GRADE1,
		GRADE2,
		GRADE3
	}

	public enum Citizenship {
		FOREIGNER,
		LOCAL
	}

	private String employeeId;
	
	private int yearJoined;
	private int monthJoined;
	private int dayJoined;
	private int monthWorkingInYear;
	
	private Citizenship citizenship;
	
	private PersonSimple spouse;

	private List<PersonSimple> child;
	
	private static final Map<Grade, Integer> GradeSalaryMap = new HashMap<>() {{
        put(Grade.GRADE1, 3000000);
        put(Grade.GRADE2, 5000000);
        put(Grade.GRADE3, 7000000);
    }};

	public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, int yearJoined, int monthJoined, int dayJoined, Citizenship citizenship, Gender gender) {
		this.employeeId = employeeId;
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setIdNumber(idNumber);
		this.setAddress(address);
		this.yearJoined = yearJoined;
		this.monthJoined = monthJoined;
		this.dayJoined = dayJoined;
		this.citizenship = citizenship;
		this.setGender(gender);
		
		child = new LinkedList<PersonSimple>();
	}
	
	/**
	 * Fungsi untuk menentukan gaji bulanan pegawai berdasarkan grade kepegawaiannya (grade 1: 3.000.000 per bulan, grade 2: 5.000.000 per bulan, grade 3: 7.000.000 per bulan)
	 * Jika pegawai adalah warga negara asing gaji bulanan diperbesar sebanyak 50%
	 */
	
	public void setMonthlySalary(Grade grade) {

		int finalSalary = GradeSalaryMap.get(grade);
		if (citizenship == Citizenship.FOREIGNER) {
			finalSalary = (int) (3000000 * 1.5);
		}

		this.incomeInfo.setMonthlySalary(finalSalary);
	}

	public void setSpouse(PersonSimple spouse) {
		this.spouse = spouse;
	}

	public PersonSimple getSpouse() {
		return spouse;
	}
	
	public void addChild(PersonSimple child) {
		this.child.add(child);
	}

	public int getChildCount() {
		return child.size();
	}
	
	public int getAnnualIncomeTax() {
		
		//Menghitung berapa lama pegawai bekerja dalam setahun ini, jika pegawai sudah bekerja dari tahun sebelumnya maka otomatis dianggap 12 bulan.
		LocalDate date = LocalDate.now();
		
		if (date.getYear() == yearJoined) {
			monthWorkingInYear = date.getMonthValue() - monthJoined;
		}else {
			monthWorkingInYear = 12;
		}
		
		return TaxFunction.calculateTax(this, monthWorkingInYear);
	}
}

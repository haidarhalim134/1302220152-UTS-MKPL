package lib;

public class TaxFunction {

	
	/**
	 * Fungsi untuk menghitung jumlah pajak penghasilan pegawai yang harus dibayarkan setahun.
	 * 
	 * Pajak dihitung sebagai 5% dari penghasilan bersih tahunan (gaji dan pemasukan bulanan lainnya dikalikan jumlah bulan bekerja dikurangi pemotongan) dikurangi penghasilan tidak kena pajak.
	 * 
	 * Jika pegawai belum menikah dan belum punya anak maka penghasilan tidak kena pajaknya adalah Rp 54.000.000.
	 * Jika pegawai sudah menikah maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000.
	 * Jika pegawai sudah memiliki anak maka penghasilan tidak kena pajaknya ditambah sebesar Rp 4.500.000 per anak sampai anak ketiga.
	 * 
	 */

	private static final int NON_TAXABLE_INCOME = 54000000;
	private static final int SPOUSE_ALLOWANCE = 4500000;
	private static final int CHILD_ALLOWANCE = 1500000;
	
	public static int calculateTax(Employee employee, int numberOfMonthWorking) {
		
		int tax = 0;
		
		if (numberOfMonthWorking > 12) {
			System.err.println("More than 12 month working per year");
		}
		
		int numberOfChildren = employee.getChildCount();
		if (numberOfChildren > 3) {
			numberOfChildren = 3;
		}
		
		PersonSimple spouse = employee.getSpouse();
		IncomeInfo incomeInfo = employee.getIncomeInfo();
		if (!spouse.getName().equals("")) {
			tax = (int) Math.round(0.05 * (((incomeInfo.getMonthlySalary() + incomeInfo.getAdditionalIncome()) * numberOfMonthWorking) - incomeInfo.getAnnualDeductible() - (NON_TAXABLE_INCOME + SPOUSE_ALLOWANCE + (numberOfChildren * CHILD_ALLOWANCE))));
		}else {
			tax = (int) Math.round(0.05 * (((incomeInfo.getMonthlySalary() + incomeInfo.getAdditionalIncome()) * numberOfMonthWorking) - incomeInfo.getAnnualDeductible() - NON_TAXABLE_INCOME));
		}
		
		if (tax < 0) {
			return 0;
		}else {
			return tax;
		}
			 
	}
	
}

package lib;

public class Person {
    private String firstName;
	private String lastName;
	private String idNumber;
	private String address;

    protected IncomeInfo incomeInfo;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        String name = firstName;
        if (!lastName.equals(""))
            name+= " " + lastName;
        return name;
    }
    
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}

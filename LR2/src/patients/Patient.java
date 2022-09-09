package patients;

public class Patient {
    private int id;
    private String surname;
    private String name;
    private String fathersName;
    private String address;
    private long number;
    private int medicalNo;
    private String diagnosis;

    public Patient(int id) {this.id = id;}

    public void setId(int id) {this.id = id;}
    public int getId() {return id;}

    public void setName(String name) {this.name = name;}
    public String getName() {return name;}

    public void setSurname(String surname) {this.surname = surname;}
    public String getSurname() {return surname;}

    public void setFathersName(String fathersName) {this.fathersName = fathersName;}
    public String getFathersName() {return fathersName;}

    public void setAddress(String address) {this.address = address;}
    public String getAddress() {return address;}

    public void setNumber(long number) {this.number = number;}
    public long getNumber() {return number;}

    public void setMedicalNo(int medicalNo) {this.medicalNo = medicalNo;}
    public int getMedicalNo() {return medicalNo;}

    public void setDiagnosis(String diagnosis) {this.diagnosis = diagnosis;}
    public String getDiagnosis() {return diagnosis;}

    @Override
    public String toString() {
        return  "ID: " + id +
                ", Прізвище: '" + surname + '\'' +
                ", Ім'я: '" + name + '\'' +
                ", По-батькові: '" + fathersName + '\'' +
                ", Адреса: '" + address + '\'' +
                ", Номер: " + number +
                ", Медичний Номер: " + medicalNo +
                ", Діагноз: '" + diagnosis + '\'';
    }
}
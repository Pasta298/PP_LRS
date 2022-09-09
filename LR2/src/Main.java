import patients.Patient;
import patUtils.PatientUtil;


public class Main {
    public static void main(String[] args) {
        Patient[] patients = PatientUtil.createList();
        System.out.println();
        PatientUtil.searchDiagnosis(patients);
        System.out.println();
        PatientUtil.searchByMedNo(patients);
        System.out.println();
        PatientUtil.searchByFirstDigit(patients);
    }
}
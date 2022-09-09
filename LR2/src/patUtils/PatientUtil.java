package patUtils;

import patients.Patient;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PatientUtil {
    public static Patient[] createList() {
        List<Patient> patientList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int i = 1;
        String check = "Так";
        while(!check.equals("Ні")) {
            patientList.add(setPatient(i));
            i++;
            System.out.print("Продовжуємо? (Так/Ні) ");
            check = input.next();
        }
        return patientList.toArray(new Patient[0]);
    }
    public static Patient setPatient(int i) {
        Patient obj = new Patient(i);
        Scanner input = new Scanner(System.in);

        System.out.print("Введіть прізвище пацієнта: ");
        obj.setSurname(input.nextLine());

        System.out.print("Введіть ім'я пацієнта: ");
        obj.setName(input.nextLine());

        System.out.print("Введіть по-батькові пацієнта: ");
        obj.setFathersName(input.nextLine());

        System.out.print("Введіть адресу проживання пацієнта: ");
        obj.setAddress(input.nextLine());

        System.out.print("Введіть номер пацієнта: ");
        obj.setNumber(input.nextLong());

        System.out.print("Введіть медичний номер пацієнта: ");
        obj.setMedicalNo(input.nextInt());
        input.nextLine();

        System.out.print("Введіть діагноз пацієнта: ");
        obj.setDiagnosis(input.nextLine());

        return obj;
    }
    public static void searchDiagnosis(Patient[] patients) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть певний діагноз: ");
        String tempDiagnosis = input.nextLine();
        for (Patient temp: patients) {
            if(temp.getDiagnosis().equals(tempDiagnosis)) {
                System.out.print(temp.toString());
                System.out.println();
            }
        }
    }
    public static void searchByMedNo(Patient[] patients) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введіть певний інтервал медичних номерів: ");
        int tempMed1 = input.nextInt();
        int tempMed2 = input.nextInt();
        for (Patient temp : patients) {
            if (temp.getMedicalNo() >= tempMed1 && temp.getMedicalNo() <= tempMed2) {
                System.out.print(temp.toString());
                System.out.println();
            }
        }
    }
    public static void searchByFirstDigit(Patient[] patients) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введіть цифру для перевірки: ");
        int tempDigit = input.nextInt();
        int counter = 0;
        for (Patient temp : patients) {
            long tempNumber = temp.getNumber();
            while(tempNumber > 10) {
                 tempNumber /= 10;
                }
            tempNumber = (int)tempNumber;
            if(tempNumber == tempDigit) {
                counter++;
                System.out.print(temp.toString());
                System.out.println();
            }
        }
        System.out.printf("Кількість пацієнтів, чий номер починається на задану цифру: " + counter);
    }
}
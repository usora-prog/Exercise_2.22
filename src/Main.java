import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Scanner scanner = new Scanner(System.in);

        // Ввод первой даты
        System.out.println("Введите первую дату в формате dd.MM.yyyy:");
        String inputDate1 = scanner.nextLine();
        Date date1 = sdf.parse(inputDate1);

        // Увеличение на 45 дней
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar1.add(Calendar.DAY_OF_MONTH, 45);
        System.out.println("Дата после увеличения на 45 дней: " + sdf.format(calendar1.getTime()));

        // Сдвиг на начало года
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date1);
        calendar2.set(Calendar.MONTH, Calendar.JANUARY);
        calendar2.set(Calendar.DAY_OF_MONTH, 1);
        System.out.println("Дата после сдвига на начало года: " + sdf.format(calendar2.getTime()));

        // Увеличение на 10 рабочих дней
        int workingDaysToAdd = 10;
        int addedWorkingDays = 0;
        Calendar calendar3 = Calendar.getInstance();
        calendar3.setTime(date1);
        while (addedWorkingDays < workingDaysToAdd) {
            calendar3.add(Calendar.DAY_OF_MONTH, 1);
            if (calendar3.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && calendar3.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                addedWorkingDays++;
            }
        }
        System.out.println("Дата после увеличения на 10 рабочих дней: " + sdf.format(calendar3.getTime()));

        // Ввод второй даты
        System.out.println("Введите вторую дату в формате dd.MM.yyyy:");
        String inputDate2 = scanner.nextLine();
        Date date2 = sdf.parse(inputDate2);

        // Подсчет рабочих дней между датами
        int workingDaysBetween = 0;
        Calendar start = Calendar.getInstance();
        start.setTime(date1);
        Calendar end = Calendar.getInstance();
        end.setTime(date2);
        if (start.after(end)) {
            Calendar temp = start;
            start = end;
            end = temp;
        }
        while (start.before(end)) {
            start.add(Calendar.DAY_OF_MONTH, 1);
            if (start.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && start.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                workingDaysBetween++;
            }
        }
        System.out.println("Количество рабочих дней между введенными датами: " + workingDaysBetween);

        scanner.close();
    }
}
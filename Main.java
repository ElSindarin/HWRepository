import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        CarList carList = new CarList();
        callMainMenu(carList);
    }

    public static void callMainMenu (CarList carList) {
        System.out.println("Добро пожаловать в меню по работе с базой данных автомобилей!");
        byte number = 0;
        Scanner sc = new Scanner(System.in);
        mainMenu: while (number != -1) {
            showMainMenuText();
            number = sc.nextByte();
            switch (number) {
                case 1: {
                    callSearchMenu(carList);
                    break;
                }
                case 2: {
                    carList.addCar();
                    break;
                }
                case 3: {
                    carList.editCar();
                    break;
                }
                case 4: {
                    carList.removeCar();
                    break;
                }
                case 0: {
                    continue mainMenu;
                }
                case -1: {
                    return;
                }
                default: {
                    System.out.println("Введённая вами опция не существует!");
                    break;
                }
            }
        }
    }

    public static void callSearchMenu(CarList carList) {
        Scanner sc = new Scanner(System.in);
        byte number = 0;
               searchMenu: while (number != -1) {
            showInnerMenuText();
            number = sc.nextByte();
            switch (number) {
                case 1: {
                    carList.searchCarByVIN();
                    break;
                }
                case 2: {
                    carList.searchCarByRegNum();
                    break;
                }
                case 7: {
                    carList.showCarList();
                    break;
                }
                case 0: {
                    return;
                }
                default: {
                    System.out.println("Выбранная вами опция не существует!");
                    break;
                }
            }
        }

    }

    public static void showMainMenuText () {
        System.out.println("Выберите опцию и введите соответствующее число:");
        System.out.println("1 - Открыть меню поиска");
        System.out.println("2 - Внести автомобиль в базу данных");
        System.out.println("3 - Редактировать информацию об автомобиле по VIN-коду");
        System.out.println("4 - Удалить информацию об автомобиле по VIN-коду");
        System.out.println("0 - Вернуться в предыдущее меню");
        System.out.println("-1 - Завершить программу");
    }

    public static void showInnerMenuText () {
        System.out.println("Меню поиска:");
        System.out.println("1 - Поиск по VIN-коду автомобиля");
        System.out.println("2 - Поиск по регистрационному номеру автомобиля");
        System.out.println("7 - отобразить список всех машин");
        System.out.println("0 - Вернуться в предыдущее меню");
    }
    public static String requestReturn () {
        System.out.println("Вы можете продолжить действовать в рамках выбранной опции. Для возврата в предыдущее меню нажмите 0");
        Scanner sc = new Scanner(System.in);
        String request = sc.nextLine();
        return request;
    }
}
